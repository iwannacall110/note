define(['directives'], function (directives) {
    directives.directive('appVersion', function () {
        return {
			templateUrl:'editbox.html',
			replace:true,
			transclude:true,
			scope:true,
			link:function(scope,element,attrs){
				console.log("========================================scope: " + scope)
				console.log("========================================element: " + element)
				console.log("========================================attrs: " + attrs)
			}
		}
    });
});
