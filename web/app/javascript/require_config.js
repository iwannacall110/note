require.config({
  paths: {
    "domReady": "app/javascript/domReady",
    "angular": "bower_components/angular/angular",
    "angular_bootstrap": "app/javascript/angular_bootstrap",
    "app": "app/javascript/app",

    "directive_define": "app/javascript/directives/directive_define",
    "editbox": "app/javascript/directives/editbox",

    "controller_define": "app/javascript/controllers/controller_define",
	"mainController": "app/javascript/controllers/mainController",
	"appController": "app/javascript/controllers/appController",

    "main": "app/javascript/main",
    "sha1": "app/javascript/units/sha1",
	
	"property": "app/javascript/property"
  },
  shim: {
     'angular': {
        exports: 'angular'
     }
  },
  deps: [
    'angular_bootstrap'
  ]
})