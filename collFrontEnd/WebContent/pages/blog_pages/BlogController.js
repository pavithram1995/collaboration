myApp.controller("BlogController",function($scope,$location,$rootScope,$http)
{
	$scope.blog={"blogid":0,"blogName":"","blogContent":"","username":"","createDate":"","status":"","likes":0,"dislikes":0};
	
	$scope.addBlog=function()
	{
		$scope.blog.username=$rootScope.currentUser.username;
		$http.post('http://localhost:8080/collMiddleWare/addBlog',$scope.blog)
		.then(function(response)
		{
			console.log('Blog Added');
			alert("Blog Added Successfully");
			$location.path("/addBlog");
		},
		function(errresponse)
		{
		console.log('Error occured to add a blog');
		alert("Error occured while adding Blog");
		$location.path("/addBlog");
		});
	}
	
	function listBlogs()
	{
		console.log('List Blog Method');
		
		$http.get('http://localhost:8080/collMiddleWare/showAllBlogs')
		.then(function(response){
			console.log('Showing all the Blog');
			$scope.blogdata=response.data;
		},
		function(errresponse){
			console.log('Error Occured');
		});
	}
	listBlogs();
	});