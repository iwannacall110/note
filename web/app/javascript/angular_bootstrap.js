//当DOM结构加载完成后，angular_bootstrap.js文件将会命令AngularJS启动起来并继续执行
define(['angular', 'domReady', 'app'], function(angular, domReady) {
    require(['domReady!'], function (document) {
        angular.bootstrap(document, ['webapp']);
    });
});