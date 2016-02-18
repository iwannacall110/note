define(['angular', 'property', 'cookie'], function () {
    return function($scope, $http, $location, $timeout, $document){
        $scope.login = function(){
            var url = 'backend/user/login';
            var user = {"email": "1150207666@qq.com", "password": "590e491d5403cd7681ce6fdcb5cb2d7d75b93b93"}
            $http.post(url, user).success(function(data){
                if(data == false){
                    alert("邮箱或密码错误!")
                    return
                } else {
                    setCookie('token', data.token, 120)
                    window.location.href = "#/main?id=" + data.user.id
                }
            })
        }
        $scope.login()
    }
})