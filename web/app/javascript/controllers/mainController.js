define(['angular', 'property', 'cookie'], function () {
    /**
     * 在header中添加token
     * */
    function postRequest(url, data){
        var req = {
            method: 'POST',
            url: url,
            headers: {'token': getCookie("token")},
            data: data
        }
        return req
    }

    function getRequest(url, params){
        var req = {
            method: 'GET',
            url: url,
            headers: {'token': getCookie("token")},
            params: params     //路径参数
        }
        return req
    }

    return function($scope, $http, $location, $timeout, $document){
        var userId = $location.search().id
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
            var params = {"user": userId}
            $http(getRequest(url, params)).success(function(data){

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
         * 根据笔记本组id或笔记本id获取笔记
         * */
        $scope.getNotes = function(group, notebook){
            var url = 'backend/note/lite/list'
            var params = {"group": group}
            $http(getRequest(url, params)).success(function(data){

            })
        }
        $scope.getNotes(100001)
        /**
         * 根据笔记id获取笔记详情
         * */
        $scope.getNoteDetail = function(note){
            var url = 'backend/note/' + note
            $http(getRequest(url)).success(function(data){
                showContent(data.content)
            })
        }
        $scope.getNoteDetail(123456)
		
        /**
         * 将文档内容填充到页面中
         * @param content
         */
        function showContent(content){
            var dom = document.getElementById("editContent")
            dom.style.height = (document.body.clientHeight -20) + "px"
            dom.innerHTML = content
        }

        $scope.currentNote = 123456

        /**
         * 保存文档
         * @param event
         */
        function saveNote(content){
            var url = "backend/note/" + $scope.currentNote + "/save"
            var postModel = {}
            postModel.content = content
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

        $scope.totalNoteCount = 230
    }
})