define(['angular', 'router', 'domReady', 'app'], function(angular, domReady) {
    require(['domReady!'], function (document) {
        angular.bootstrap(document, ['webapp'])
    })
})