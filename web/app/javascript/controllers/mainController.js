define(['angular', 'property', 'cookie', 'customModel', 'http'], function () {
    return function($rootScope, $scope, $http, $location, $timeout, $document){
        $scope.unfoldGroups = false
        $scope.foldAll = function(){
            $scope.unfoldGroups = !$scope.unfoldGroups
            if($scope.currentGroup == undefined && $scope.groups.length > 0){
                $scope.currentGroup = $scope.groups[0].id
            }
        }
        console.log($rootScope.user)
        //var userId = $location.search().id
        $scope.groupPopupItems = groupPopupItems
        $scope.notebookPopupItems = notebookPopupItems
        $scope.currentGroup = undefined
        $scope.unfoldGroup = undefined

        function getNoteBookGroupsByUser(){
            var url = 'backend/note/groups'
            //var params = {"user": userId}
            $http(getRequest(url)).success(function(data){
                $scope.groups = data
                $scope.currentGroup = data[0].id
                $scope.getNotes($scope.currentGroup)
            })
        }
        getNoteBookGroupsByUser()

        /**
         * 添加笔记本组
         */
        $scope.addGroup = function($event){
            $scope.groupAdd = true
            $scope.noteBookAdd = false
            $event.stopPropagation()
        }

        /**
         * 保存新增笔记本组
         * @param event
         */
        $scope.saveNewGroup = function($event, name){
            if($event.ctrlKey && $event.keyCode == 83){ // ctrl + s
                var url = 'backend/note/group/add'
                var group = {"name": name}
                $http(postRequest(url, group)).success(function(data){
                    if(data != undefined){
                        $scope.groups.unshift(data)
                    }
                })
            }
        }

        /**
         * 收起或展开笔记本组
         * */
        $scope.foldGroup = function($event, id){
            if($scope.unfoldGroup != id){
                $scope.unfoldGroup = id
            } else {$scope.unfoldGroup = undefined}
            $event.stopPropagation()
        }

        /**
         * 展开笔记本组的操作列表
         * @param group
         */
		$scope.expendGroup = function($event, group){
            if($scope.manageGroup != group){
                $scope.manageGroup = group
            } else { $scope.manageGroup = -1}
            $event.stopPropagation()
		}


        /**
         * 笔记本组管理
         */
        $scope.groupManager = function($event, group, item){
            $scope.manageGroup = -1
            switch(item) {
                case 'create':
                    $scope.noteBookAdd = group
                    break
                case 'rename':
                case 'delete':
                default:
            }
            $event.stopPropagation()
        }

        /**
         * 保存新增笔记本
         * @param event
         * @param group
         */
        $scope.saveNewNoteBook = function(event, group){
            if(event.ctrlKey && event.keyCode == 83){ // ctrl + s
                var url = 'backend/note/book/add'
                var noteBook = {"noteBookGroup": group.id, "name": group.newNoteBook}
                $http(postRequest(url, noteBook)).success(function(data){
                    if(data != undefined){
                        $scope.currentGroup = group.id
                        group.noteBooks.unshift(data)
                        group.newNoteBook = undefined
                    }
                })
            }
        }

        /**
         * 删除笔记本
         * @param noteBook
         */
        $scope.deleteNoteBook = function(noteBook){
            var url = 'backend/note/book/' + noteBook + '/delete'
            $http(deleteRequest(url)).success(function(data){
                $scope.groups.forEach(function(group){
                    for(var i=0;i<group.noteBooks.length;i++){
                        if(nb.id == group.noteBooks[i]){
                            group.noteBooks.splice(i, 1)
                            i--
                            return
                        }
                    }
                })
            })
        }

        /**
         * 笔记本管理
         * @param noteBook
         * @param item
         */
        $scope.noteBookManager = function($event, noteBook, item){
            $scope.manageNoteBook = -1
            switch(item) {
                case 'create':
                    $scope.createNote(noteBook.id, noteBook.noteBookGroup);
                    break
                case 'rename':
                case 'delete':
                    $scope.deleteNoteBook(noteBook.id)
                    break
                default:
            }
            $event.stopPropagation()
        }

        /**
         * 展开笔记本组的操作列表
         * @param group
         */
        $scope.expendNoteBook = function($event, noteBook){
            if($scope.manageNoteBook != noteBook){
                $scope.manageNoteBook = noteBook
            } else { $scope.manageNoteBook = -1}
            if ($event.stopPropagation)
                $event.stopPropagation()
            else
                $event.cancelBubble = true
        }

        /**
         * 新增笔记
         * @param noteBook
         * @param noteBookGroup
         */
        $scope.createNote = function(noteBook, noteBookGroup){
            var url = 'backend/note/create'
            var note = {"noteBook": noteBook ,"noteBookGroup": noteBookGroup}
            $http(postRequest(url, note)).success(function(data){
                $scope.getNotes(noteBookGroup, noteBook)
                //$scope.noteLites.unshift(data)
                $scope.groups.forEach(function(group){
                    group.noteBooks.forEach(function(nb){
                        if(nb.id == noteBook){
                            group.noteCount = group.noteCount + 1
                            nb.noteCount = nb.noteCount + 1
                        }
                    })
                })
            })
        }

        /**
         * 根据笔记本组id或笔记本id获取笔记
         * */
        $scope.getNotes = function(group, noteBook){
            if(group != undefined){ $scope.currentGroup = group}
            if(noteBook != undefined){ $scope.currentNoteBook = noteBook}
            var url = 'backend/note/lite/list'
            var params = {"group": group, "noteBook": noteBook}
            $http(getRequest(url, params)).success(function(data){
                $scope.noteLites = undefined
                showContent("")
                if(data != null && data.length > 0){
                    $scope.noteLites = data
                    $scope.currentNote = data[0].id
                    $scope.getNoteDetail($scope.currentNote)
                    $scope.noteLites.forEach(function(note){
                        if(note != null && note.size != null){
                            note.size = note.size.byteFormat()
                        }
                    })
                }
            })
        }

        /**
         * 删除笔记
         * @param noteLite
         */
        $scope.deleteNote = function(noteLite){
            var url = 'backend/note/' + noteLite.id + '/delete'
            $http(deleteRequest(url)).success(function(data){
                for(var i=0;i<$scope.noteLites.length;i++){
                    if($scope.noteLites[i].id == noteLite.id){
                        $scope.noteLites.splice(i, 1)
                        i--
                        break
                    }
                }
            })
            $scope.groups.forEach(function(group){
                group.noteBooks.forEach(function(nb){
                    if(nb.id == noteLite.noteBook){
                        group.noteCount = group.noteCount - 1
                        nb.noteCount = nb.noteCount -1
                    }
                })
            })
            //阻止冒泡
            return false
        }

        /**
         * 根据笔记id获取笔记详情
         * */
        $scope.getNoteDetail = function(note){
            var url = 'backend/note/' + note
            $http(getRequest(url)).success(function(data){
                $scope.currentNote = note
                showContent(data.content)
            })
        }
		
        /**
         * 将文档内容填充到页面中
         * @param content
         */
        function showContent(content){
            var dom = document.getElementById("editContent")
            dom.style.height = (document.body.clientHeight -20) + "px"
            dom.innerHTML = content
        }

        /**
         * 保存文档
         * @param event
         */
        function saveNote(content, size, digest){
            var url = "backend/note/" + $scope.currentNote + "/save"
            var postModel = {}
            postModel.content = content
            postModel.size = size
            postModel.digest = digest
            $http(postRequest(url, postModel)).success(function(data){

            })
        }


        /**
         * 键盘事件
         * @param event
         */
		$scope.keyDown = function(event){
			if(event.ctrlKey && event.keyCode == 83){ // ctrl + s
				var content = document.getElementById("editContent")
                var size = content.textContent.byteLength()
                var digest = content.textContent.substr(0, 30)
                saveNote(content.innerHTML, size, digest)
			}
		}

        /**
         * 阻止浏览器的默认行为
         * @param event
         */
        $document[0].onkeydown = function(event){
            event = window.event || event
            if(event.ctrlKey && event.keyCode == 83){
                console.log("ban save")
                event.returnValue = false
            }
        }
    }
})