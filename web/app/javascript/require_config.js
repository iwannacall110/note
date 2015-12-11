require.config({
  paths: {
    "angular": "bower_components/angular/angular",
    "app": "app/javascript/app",
    "main": "app/javascript/main",
	"sha1": "app/javascript/units/sha1",
    "editbox": "app/javascript/directive_js/editbox",
    "angular_bootstrap": "app/javascript/angular_bootstrap",
	"mainController": "app/javascript/mainController",
	"appController": "app/javascript/appController",
	"module": "app/javascript/module"
  },
  shim: {
    "app": {
      deps: ["angular"]
    },
    "main": {
      deps: ["app"]
    },
    "editbox": {
      deps: ["app"]
    }
  }
})