define(['controller_define'], function (controllers) {
    controllers.controller('mainController',function($scope, $http){
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
                "noteBooks": [
                    {
                        "id": 1121,
                        "group": 123,
                        "name": "测试笔记",
                        "isDefault": true,
                        "order": 1,
                        "noteCount": 18,
                        "remark": "备注"
                    }
                ]
            }
        ]
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

        $scope.totalNoteCount = 230
        $scope.isFold = false              //收起文件夹
        $scope.focusRoot = false            //选中全部笔记目录
        $scope.openGroup = 123             //展开笔记本组目录
        $scope.focusGroup = 123           //选中笔记本组目录
        $scope.openNotebook = -1             //展开笔记本右侧目录
        $scope.focusNotebook = -1           //选中笔记本目录
        $scope.postUser = function(){
            var url = 'backend/user/login';
            var user = {"id": 111111, "name": "wangshan", "email": "1150207666@qq.com", "password": "590e491d5403cd7681ce6fdcb5cb2d7d75b93b93"}
            $http.post(url, user).success(function(data){
                var len = document.cookie.length
            })
        }
        $scope.postUser()
    })
})