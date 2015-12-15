define(['controller_define'], function (controllers) {
    controllers.controller('mainController',function($scope, $http){
        $scope.groups = [
            {
                "id": 123,
                "name": "测试组",
                "isDefault": true,
                "order": 12,
                "remark": "备注",
                "notebooks": [
                    {
                        "id": 1121,
                        "groups": 123,
                        "name": "测试笔记",
                        "isDefault": true,
                        "order": 1,
                        "noteCount": 18,
                        "remark": "备注"
                    }
                ]
            }
        ]
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