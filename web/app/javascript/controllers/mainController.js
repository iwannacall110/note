define(['controller_define'], function (controllers) {
    /**
     * 在header中添加token
     * */
    var customRequest = {
        method: 'POST',
        url: 'http://example.com',
        headers: {
            'Content-Type': undefined
        },
        data: { test: 'test' }
    }

    function getRequest(md, url, params, headers){
        var req = {
            method: md,
            url: url,
            headers: headers,
            data: params
        }
        return req
    }

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
                "digest": "html5拖拽图片批量ajax无刷新进度上传,博客分类：Div / Css / XML /...",
                "size": 2121212121,
                "createon": "2015-10-11",
                "updateon": "2015-10-11",
                "isFold": false,
                "isExpand": false
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
         * 将文档内容填充到页面中
         * @param content
         */
        function showContent(content){
            document.getElementById("editContent").innerHTML = content
        }

        /**
         * 获取文档内容
         */
        function getNote(note){
            var url = "backend/note/" + note
            $http.get(url).success(function(data){
                showContent(data)
            })
        }

        /**
         * 保存文档
         * @param event
         */
        function saveNote(content){
            var url = "backend/note/" + $scope.currentNote + "/save"
            var postModel = {}
            postModel.content = content
            $http.post(url, postModel).success(function(data){

            })
        }

        /**
         * 键盘事件
         * @param event
         */
		$scope.keyDown = function(event){
			if(event.ctrlKey && event.keyCode == 83){ // ctrl + s
				var content = document.getElementById("editContent")
				console.log("======================= " + content.innerHTML)
                saveNote(content.innerHTML)
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

        setCookie("token", "1212121", 120)

        $scope.totalNoteCount = 230
        $scope.postUser = function(){
            var url = 'backend/user/login';
            var user = {"id": 111111, "name": "wangshan", "email": "1150207666@qq.com", "password": "590e491d5403cd7681ce6fdcb5cb2d7d75b93b93"}
            var headers = {'token': getCookie("token")}
            $http(getRequest('POST',url,user,headers)).success(function(){

            })
        }
        $scope.postUser()
    }])
})