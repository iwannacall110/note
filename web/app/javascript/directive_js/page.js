define(["memberTypeApp"],function(memberTypeApp){
  var app=memberTypeApp;
  app.directive('page',function(){
		return {
			    templateUrl:'/assets/templates/memberapp/myDirective/page.html',
				replace:true,
				transclude:true,
				scope:true,
				link:function(scope,element,attrs){

					/*监听父作用域的recordCount,即记录总数*/
					scope.$watch('$parent.recordCount',function(newVal,oldVal){
						if(newVal==oldVal){
						}else{
							scope.setPage();
						}
						if(scope.recordCount2==1){
							scope.setPage();
						}
						scope.setPage();
					})
					/*设置分页*/
					scope.setPage = function(){
						scope.minPageNum = 1;
						scope.maxPageNum = 5;
						scope.currentPage = 1;
						/*分页总数量*/
						scope.pageCount = Math.ceil(scope.recordCount/scope.pageSize);
						if(scope.pageCount<scope.maxPageNum){
							scope.maxPageNum = scope.pageCount;
						}
						/*存放分页号的数组*/
						scope.pageArray =[];
						for(var i=1;i<scope.pageCount;i++){
							scope.pageArray.push(i);
						}
					}

					/*选择分页*/
					scope.chosePage = function(pageNum){
						scope.currentPage = pageNum;
						if(pageNum>scope.maxPageNum){
							scope.minPageNum ++;
							scope.maxPageNum ++;
						}
						if(pageNum<scope.minPageNum){
							scope.minPageNum--;
							scope.maxPageNum--;
						}
						if(pageNum==scope.pageCount){
							scope.maxPageNum = pageNum;
							scope.minPageNum = pageNum-5;
						}
						if(pageNum==1){
							scope.maxPageNum = 5;
							scope.minPageNum = 1;
						}
						/*回调父作用域的searchMembers函数*/
						scope.shareObject.currentPage = pageNum;
						scope.searchMembers();
					}
				}
		}
	})
})
