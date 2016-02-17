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
                    redirectTo: '/main'      //angular就喜欢斜杠开头
                });
        }]);

    return app;
});