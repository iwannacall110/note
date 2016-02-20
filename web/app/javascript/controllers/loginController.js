define(['angular', 'property', 'cookie', 'sha1'], function () {
    return function($rootScope,$scope, $http, $location, $timeout, $document){
        $scope.login = function(){
            var url = 'backend/user/login';
            var user = {"email": $scope.model.email, "password": $scope.model.password}
            user.password = hex_sha1(user.password)
            $http.post(url, user).success(function(data){
                if(data == false){
                    alert("邮箱或密码错误!")
                    return
                } else {
                    $rootScope.user = data.user
                    setCookie('token', data.token, 1200)
                    window.location.href = "#/main"
                }
            })
        }
    }
})