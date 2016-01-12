define(['directive_define'], function (directive_define) {
	directive_define.directive('editbox',['$document',function($document){
	  return {
			templateUrl:'app/html/directive_html/editbox.html',
			replace:true,
			transclude:true,
			scope:false,
			link:function(scope,element,attrs){
				var abc = function(){
					var doms = document.getElementsByClassName("editc")
					for(var i in doms){
						doms[i].onclick = function(){
							switch(this.getAttribute("data-role")){
								case "h1":
								case "h2":
								default:
									document.execCommand(this.getAttribute("data-role"), true, true)
									break
							}
						}
					}
				}
				abc()
			}
		}
	}])
})

