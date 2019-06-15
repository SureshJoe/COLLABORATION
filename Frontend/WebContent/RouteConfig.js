var myApp=angular.module("myApp",['ngRoute','ngCookies']);
myApp.config(function($routeProvider){
	
	alert("i am in Route Provider");
	
	$routeProvider.when("/login",{templateUrl:"c_userpage/Login.html"})
	              .when("/register",{templateUrl:"c_userpage/Register.html"})
	              
	              
	              .when("/addBlog",{templateUrl:"c_blog/AddBlog.html"})
                  .when("/manageBlog",{templateUrl:"c_blog/ManageBlog.html"})
                  .when("/showBlog",{templateUrl:"c_blog/ShowBlog.html"})
                  .when("/updateBlog",{templateUrl:"c_blog/UpdateBlog.html"})
                  .when("/myBlog",{templateUrl:"c_blog/MyBlog.html"})
});


myApp.run(function($rootScope,$cookieStore)
{
		console.log('I am in bestrun Function');

if($rootScope.currentUser==undefined)
	{
	$rootScope.currentUser=$cookieStore.get('userDetail');
	}

});