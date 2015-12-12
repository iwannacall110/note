//当DOM结构加载完成后，bootstrap.js文件将会命令AngularJS启动起来并继续执行
define(['angular', 'app'], function(angular) {
	require(['domReady!'], function (document) {
		angular.bootstrap(document, ['webapp']);
  });
});

