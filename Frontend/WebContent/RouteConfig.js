var myApp=angular.module("myApp",['ngRoute']);
myApp.config(function($routeProvider){
	
	alert("i am in Route Provider");
	
	$routeProvider.when("/login",{templateUrl:"Userpages/Login.html"})
	              .when("/register",{templateUrl:"Userpages/Register.html"})
});