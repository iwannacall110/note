define(['angular', 'domReady', 'app'], function(angular, domReady) {
    require(['domReady!'], function (document) {
        angular.bootstrap(document, ['webapp']);
    });
});