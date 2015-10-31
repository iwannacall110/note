require.config({
  paths: {
    "jquery": "bower_components/jquery/dist/jquery",
    "angular": "bower_components/angular/angular",
    "pace": "app/javascript/pace.min",
    "endless": "app/javascript/endless"
  },
  shim: {
    "endless": {
      deps: ["jquery"]
    }
  }
})