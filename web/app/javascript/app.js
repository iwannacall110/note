define(['angular', 'require', 'angular-route'], function (angular, require) {
    var app = angular.module('webapp', ['ngRoute'])
    app.config(['$routeProvider', '$controllerProvider',
        function($routeProvider, $controllerProvider) {
			var routeMap = {
				'/main': {
					path: 'app/javascript/controllers/mainController.js',
					templateUrl: 'app/html/main.html',
					controller: 'mainController'
				},
				'/login': {
					path: 'app/javascript/controllers/loginController.js',
					templateUrl: 'app/html/login.html',
					controller: 'loginController'
				}
			}
			var defaultRoute = '/login'
			for(var key in routeMap){
				$routeProvider.when(key, {
					templateUrl: routeMap[key].templateUrl,
					controller: routeMap[key].controller,
					resolve: {
						keyName: requireModule(routeMap[key].path, routeMap[key].controller)
					}
				})
			}
			$routeProvider.otherwise({redirectTo: defaultRoute})

			function requireModule(path, controller) {
				return function ($q) {
					var deferred = $q.defer()
					require([path], function (ret) {
						$controllerProvider.register(controller, ret)
						deferred.resolve()
					})
					return deferred.promise
				}
			}

            /*$routeProvider.
                when('/main', {
                    templateUrl: 'app/html/main.html',
                    controller: 'mainController',
                    resolve: {
                        keyName: function ($q) {
                            var deferred = $q.defer()
                            require(['app/javascript/controllers/mainController.js'], function (controller) {
                                $controllerProvider.register('mainController', controller)
                                deferred.resolve()
                            })
                            return deferred.promise
                        }
                    }
                }).
                otherwise({
                    redirectTo: '/main'
                })*/
		}
	])

	// TODO 自定义指令部分暂时都放在这儿
	app.directive('editbox',['$document',function($document){
	  return {
			templateUrl:'app/html/directive/editbox.html',
			replace:true,
			transclude:true,
			scope:false,
			link:function(scope,element,attrs){
				var func = function(){
					var doms = document.getElementsByClassName("editc")
					for(var i in doms){
						doms[i].onclick = function(){
							switch(this.getAttribute("data-role")){
								case "h1":
								case "h2":
								default:
									document.execCommand(this.getAttribute("data-role"), true, true)
									break
							}
						}
					}
				}
				func()
			}
		}
	}])
    return app
})