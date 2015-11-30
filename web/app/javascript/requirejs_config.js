require.config({
  paths: {
    "jquery": "bower_components/jquery/dist/jquery",
    "angular": "bower_components/angular/angular",
    "app": "app/javascript/app",
    "main": "app/javascript/main",
	"sha1": "app/javascript/units/sha1"
  },
  shim: {
    "endless": {
      deps: ["jquery"]
    },
    "app": {
      deps: ["angular"]
    },
    "main": {
      deps: ["app"]
    }
  }
})