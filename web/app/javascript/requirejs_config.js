require.config({
  paths: {
    "jquery": "bower_components/jquery/dist/jquery",
    "angular": "bower_components/angular/angular",
    "unzip": "node_modules/unzip/unzip",
    "archiver": "node_modules/archiver/index"
  },
  shim: {
    "angular": {
      deps: ["jquery"]
    }
  }
})