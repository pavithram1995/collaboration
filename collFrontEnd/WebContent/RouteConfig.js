var myApp=angular.module("myApp",['ngRoute','ngCookies']);

myApp.config(function($routeProvider)
		{
	
	$routeProvider
	.when("/index",{templateUrl:"/index.html"})
	.when("/login",{templateUrl:"pages/user_pages/Login.html"})
	.when("/register",{templateUrl:"pages/user_pages/Register.html"})
	.when("/contactus",{templateUrl:"pages/user_pages/Contact_us.html"})
	.when("/profileUpload",{templateUrl:"pages/user_pages/ProfileUpload.html"})
	.when("/blog",{templateUrl:"pages/blog_pages/blog.html"})
	.when("/addBlog",{templateUrl:"pages/blog_pages/AddBlog.html"})
	.when("/showBlog",{templateUrl:"pages/blog_pages/ShowBlog.html"})
	.when("/adminBlog",{templateUrl:"pages/blog_pages/ManageBlog.html"})
	.when("/updateBlog",{templateUrl:"pages/blog_pages/updateBlog.html"})
	.when("/showBlogComment",{templateUrl:"pages/blog_pages/BlogComment.html"})
	.when("/friend",{templateUrl:"pages/friend_pages/Friend.html"});
		});

myApp.run(function($rootScope,$cookieStore)
		{
	console.log('I am in run Function');
	
	if($rootScope.currentUser==undefined)
		{
		
		$rootScope.currentUser=$cookieStore.get('userDetail');
		console.log('I am in run Scope');
		}
		});