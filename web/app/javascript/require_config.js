
var config = {
  paths: {
    'domReady': 'app/javascript/domReady',
    'angular': 'bower_components/angular/angular',
	'angular-route': 'bower_components/angular-route/angular-route',
    'angular_bootstrap': 'app/javascript/angular_bootstrap',
    'app': 'app/javascript/app',

    'directive_define': 'app/javascript/directives/directive_define',
    'editbox': 'app/javascript/directives/editbox',
	'scroll': 'app/javascript/directives/scroll',

    'controller_define': 'app/javascript/controllers/controller_define',
	'mainController': 'app/javascript/controllers/mainController',
	'appController': 'app/javascript/controllers/appController',

    'main': 'app/javascript/main',
    'sha1': 'app/javascript/units/sha1',
    'cookie': 'app/javascript/units/cookie',
    'customModel': 'app/javascript/units/customModel',
	
	'property': 'app/javascript/property'
  },
  shim: {
	 'angular': {
		exports: 'angular'
	 },
	 'angular-route': {
		deps: ['angular'],   
		exports: 'ngRouteModule'
	 }
  },
  deps: ['angular_bootstrap']
}

require.config(config)