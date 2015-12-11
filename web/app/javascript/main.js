require.config({
  paths: {
    "angular": "/bower_components/angular/angular",
    "app": "app",
	"sha1": "units/sha1",
    "editbox": "directive_js/editbox",
    "angular_bootstrap": "angular_bootstrap",
	"mainController": "mainController",
	"appController": "appController",
	"module": "module"
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