define(['angular', 'property', 'cookie', 'customModel', 'http'], function () {
    return function($rootScope, $scope, $http, $location, $timeout, $document){
        $scope.unfoldGroups = false
        $scope.foldAll = function(){
            $scope.unfoldGroups = !$scope.unfoldGroups
        }

        console.log($rootScope.user)
        //var userId = $location.search().id
        $scope.groupPopupItems = groupPopupItems
        $scope.notebookPopupItems = notebookPopupItems
        $scope.groups = [
            {
                "id": 123,
                "name": "测试组1",
                "isDefault": true,
                "order": 12,
                "remark": "备注",
                "noteCount": 150,
                "isFold": false,
                "isExpand": false,
                "noteBooks": [
                    {
                        "id": 1121,
                        "group": 123,
                        "title": "测试笔记",
                        "content": "山东省肯德基的的时代精神抖擞抖擞抖擞抖擞...",
                        "isDefault": true,
                        "order": 1,
                        "noteCount": 18,
                        "remark": "备注"
                    }
                ]
            }
        ]

        $scope.noteLites = [
            {
                "id": 001,
                "name": "测试笔记1",
                "isDefault": true,
                "order": 12,
                "remark": "备注",
                "digest": "html5拖拽图片批量ajax无刷新进度上传,博客分类：Div / Css / XML /...",
                "size": 2121212121,
                "createon": "2015-10-11",
                "updateon": "2015-10-11",
                "isFold": false,
                "isExpand": false
            }
        ]
        $scope.currentGroup = undefined

        function getNoteBookGroupsByUser(){
            var url = 'backend/note/groups'
            //var params = {"user": userId}
            $http(getRequest(url)).success(function(data){
                $scope.groups = data
                $scope.currentGroup = data[0]
                $scope.getNotes($scope.currentGroup.id)
            })
        }
        getNoteBookGroupsByUser()

        /**
         * 收起或展开笔记本组
         * */
        $scope.foldGroup = function(id){
            $scope.groups.forEach(function(group){
                if(group.id == id){
                    group.isFold = !group.isFold
                    return
                }
            })
        }

        /**
         * 收起或展开笔记本组的扩展
         * */
        $scope.groupExpand = function(id){
            $scope.groups.forEach(function(group){
                if(group.id == id){
                    group.isExpand = !group.isExpand
                }
            })
        }

        /**
         * 展开笔记本组的操作列表
         * @param group
         */
		$scope.expendGroup = function(group){
			$scope.manageGroup = group
		}
		
        /**
         * 笔记本组管理
         */
        $scope.groupManager = function(group, item){
            $scope.manageGroup = -1
            switch(item) {
                case 'create':
                    console.log("==================group: " + group)
                    $scope.groupAdd = group
                case 'rename':
                case 'delete':
                default:
            }
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
                    if(data.length > 0){
                        $scope.currentGroup = group.id
                    }
                })
            }
        }

        /**
         * 笔记本管理
         * @param noteBook
         * @param item
         */
        $scope.noteBookManager = function(noteBook, item){

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
                if(data.length > 0){
                    $scope.noteLites = data
                    $scope.noteLites.forEach(function(note){
                        note.size = note.size.byteFormat()
                    })
                    $scope.currentNote = data[0].id
                    $scope.getNoteDetail($scope.currentNote)
                }
            })
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

        $scope.totalNoteCount = 230
    }
})