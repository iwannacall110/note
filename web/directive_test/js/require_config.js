/**
 * ∂®“ÂRequireJS≈‰÷√
 */
require.config({

    paths: {
        'angular': '../lib/angular/angular',
        'domReady': '../lib/requirejs-domready/domReady',
		'bootstrap': '../js/bootstrap',
		'app': '../js/app',
		'directives': '../js/directives/directives',
		'app-version': '../js/directives/app-version',
		'index': '../js/directives/index',
    },
    shim: {
        'angular': {
            exports: 'angular'
        }
    },

    deps: [
        // kick start application... see bootstrap.js
        'bootstrap'
    ]
});