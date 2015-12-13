define(["module"],function(controllers){
	console.log("=============================cont: " + controllers)
    controllers.controller('appController',function($scope){
        //控制器的具体js代码
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