require(["app"],function(app){
  app.directive('editbox',function(){
	  return {
			templateUrl:'app/html/directive_html/editbox.html',
			replace:true,
			transclude:true,
			scope:true,
			link:function(scope,element,attrs){
				console.log("========================================scope: " + scope)
				console.log("========================================element: " + element)
				console.log("========================================attrs: " + attrs)
			}
		}
	})
})
