define(['angular', 'require', 'angular-route'], function (angular, require) {
    var app = angular.module('webapp', ['ngRoute'])
    app.config(['$routeProvider', '$controllerProvider',
        function($routeProvider, $controllerProvider) {
            $routeProvider.
                when('/main', {
                    templateUrl: 'app/html/main.html',
                    controller: 'mainController',
                    resolve: {
                        keyName: function ($q) {
                            var deferred = $q.defer();
                            require(['app/javascript/controllers/mainController.js'], function (controller) {
                                $controllerProvider.register('mainController', controller);      
                                deferred.resolve();
                            });
                            return deferred.promise;
                        }
                    }
                }).
                otherwise({
                    redirectTo: '/main'      
                });
        }])
	
	app.directive('editbox',['$document',function($document){
	  return {
			templateUrl:'app/html/directive_html/editbox.html',
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
    return app;
});