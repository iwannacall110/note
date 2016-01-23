define(['directive_define'], function (directive_define) {
	directive_define.directive('scroll',['$document',function($document){
	  return {
			templateUrl:'',
			replace:false,
			transclude:false,
			scope:false,
			link:function(scope,element,attrs){
				var func = function(){
					var dom = document.getElementsByClassName("second-area")[0]
					dom.onmousewheel = function(event){
						if(dom.scrollTop = (dom.scrollHeight - dom.clientHeight)){
							console.log("scroll bottom")
						}
					}
				}
				func()
			}
		}
	}])
})

