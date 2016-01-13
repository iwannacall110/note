define(['controller_define'], function (controllers) {
    controllers.controller('mainController',["$scope", "$http", "$location", "$timeout", "$document",function($scope, $http, $location, $timeout, $document){
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
                "noteCount": 150,
                "digest": "html5拖拽图片批量ajax无刷新进度上传,博客分类：Div / Css / XML /...",
                "isFold": false,
                "isExpand": false,
            },{
                "id": 002,
                "name": "测试笔记2",
                "isDefault": false,
                "order": 12,
                "remark": "备注",
                "noteCount": 150,
                "isFold": false,
                "isExpand": false,
            },{
                "id": 003,
                "name": "测试笔记3",
                "isDefault": false,
                "order": 12,
                "remark": "备注",
                "noteCount": 150,
                "isFold": false,
                "isExpand": false,
            }
        ]
        $scope.currentGroup = undefined
        /*收起或展开笔记本组*/
        $scope.foldGroup = function(id){
            $scope.groups.forEach(function(group){
                if(group.id == id){
                    group.isFold = !group.isFold
                    return
                }
            })
        }

        /*根据笔记本组id或笔记本id获取笔记*/
        $scope.getNotes = function(group, notebook){
            var url = 'backend/group/' + group + '/notes'
            if(notebook != undefined){
                url = 'backend/group/' + group + '/notebook/' + notebook + '/notes'
            }
            $http.get(url).success(function(data){

            })
        }

        /*根据笔记id获取笔记详情*/
        $scope.getNoteDetail = function(note){
            var url = 'backend/note/' + note
            $http.get(url).success(function(data){

            })
        }

        /*收起或展开笔记本组的扩展*/
        $scope.groupExpand = function(id){
            $scope.groups.forEach(function(group){
                if(group.id == id){
                    group.isExpand = !group.isExpand
                }
            })
        }

        
		$scope.test = function(){
			var abc = document.getElementById("editContent")
			console.log("======================= " + abc.innerHTML)
		}
		
		$scope.retest = function(){
			var html = "<b><i><u><strike>dsdnsj桑德斯柯达开始倒计时</strike></u></i></b>"
			var abc = document.getElementById("editContent")
			abc.innerHTML = html
			console.log("======================= " + abc.innerHTML)
		}

        /**
         * 保存文档
         * @param event
         */
        function saveNote(){
            var url = "backend/note/" + $scope.currentNote + "/save"
        }

		$scope.keyDown = function(event){
			if(event.ctrlKey && event.keyCode == 83){ // ctrl + s
				console.log("save")
				var abc = document.getElementById("editContent")
				console.log("======================= " + abc.innerHTML)
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
        $scope.postUser = function(){
            var url = 'backend/user/login';
            var user = {"id": 111111, "name": "wangshan", "email": "1150207666@qq.com", "password": "590e491d5403cd7681ce6fdcb5cb2d7d75b93b93"}
            $http.post(url, user).success(function(data){
                var len = document.cookie.length
            })
        }
        $scope.postUser()
    }])
})