var myApp=angular.module("myApp",['ngRoute']);

myApp.config(function($routeProvider)
		{
	
	$routeProvider
	.when("/index",{templateUrl:"/index.html"})
	.when("/login",{templateUrl:"pages/user_pages/Login.html"})
	.when("/register",{templateUrl:"pages/user_pages/Register.html"})
	.when("/contactus",{templateUrl:"pages/user_pages/Contact_us.html"})
	.when("/blog",{templateUrl:"pages/blog_pages/blog.html"})
	
		});