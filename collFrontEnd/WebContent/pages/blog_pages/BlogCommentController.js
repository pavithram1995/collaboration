myApp.controller("BlogCommentController",function($scope,$location,$rootScope,$http)
		{
			$scope.blog={"blogid":0,"blogName":"","blogContent":"","username":"","createDate":"","status":"","likes":0,"dislikes":0};
			
			$scope.blogComment;
			
			$rootScope.blogid;
			
			$scope.comment={"commentId":0,"blogId":0,"blogComment":"","commentDate":"","username":""};		
			
			function loadBlog()
			{
				console.log('getting a Blog');
				$http.get('http://localhost:8080/collMiddleWare/getBlog/'+$rootScope.blogid)
				.then(function(response)
						{
							
							$scope.blog=response.data;
						});
			}
			
			function showAllBlogComments()
			{
				console.log('Listing using blogid');
				$http.get('http://localhost:8080/collMiddleWare/listBlogComments/'+$rootScope.blogid)
				.then(function(response)
						{	
					$scope.blogComment=response.data;
							
						},
						function(errresponse){
							console.log('Error Occured');
						}
						);
			}
			$scope.addComment=function()
			{
				console.log('I am in add comment');
				$scope.comment.blogId=$scope.blog.blogid;
				$scope.comment.username=$rootScope.currentUser.username;
				$http.post('http://localhost:8080/collMiddleWare/addBlogComment',$scope.comment)
				.then(function(response)
						{
					showAllBlogComments();
							alert("comment added");
						},
						function(errresponse)
						{
							
						alert("Error occured");
						});
			}
			$scope.deleteBlogComment=function(commentId)
			{
				console.log('Blog Comment Deleted');
				$http.delete('http://localhost:8080/collMiddleWare/deleteBlogComment/'+commentId)
				.then(function(response)
				{
					showAllBlogComments();
					alert('Blog Comment Deleted');
					$location.path("/showBlogComment");
				},
				function(errresponse)
				{
					console.log('Error Occured');
					alert('Error Occured while Deleting Blog comment');
			
				});
			}
			function listBlogs()
			{
				console.log('List Blog Method');
				
				$http.get('http://localhost:8080/collMiddleWare/showAllBlogs')
				.then(function(response)
						{
					console.log('Showing all the Blog');
					$scope.blogdata=response.data;
				},
				function(errresponse){
					console.log('Error Occured');
				});
			}
			
			
			
			$scope.incrementLikes=function(blogid)
			{
				console.log('Incremented Likes');
				$http.get('http://localhost:8080/collMiddleWare/incrementLikes/'+blogid)
				.then(function(response)
				{
					listBlogs();
					$location.path("/showBlogComment");
				},
				function(errresponse){
					console.log('Error Occured');
				});
				
			}
			$scope.incrementDisLikes=function(blogid)
			{
				console.log('Incremented dislikes');
				$http.get('http://localhost:8080/collMiddleWare/incrementDisLikes/'+blogid)
				.then(function(response)
				{
					listBlogs();
					$location.path("/showBlogComment");
				},
				function(errresponse){
					console.log('Error Occured');
				});
				
			}
			$scope.deleteBlog=function(blogid)
			{
				console.log('Blog Deleted');
				$http.get('http://localhost:8080/collMiddleWare/deleteBlog/'+blogid)
				.then(function(response)
						{
					listBlogs();
					alert('Blog Deleted');
					$location.path("/showBlogComment");
						},
						function(errresponse)
						{
							console.log('Error Occured');
							alert('Error Occured while Deleting Blog');
					
						});	
			}
			$scope.editBlog=function(blogid)
			{
				console.log('Editing a Blog');
				$rootScope.blogid=blogid;
				$location.path("/updateBlog");
			}
			$scope.updateBlog=function()
			{
				console.log('I am in update blog');
				$http.post('http://localhost:8080/collMiddleWare/updateBlog',$scope.blog)
				.then(function(response)
						{
							alert("Blog is updated");
						},
						function(errresponse)
						{
							alert("Error Occured");
						});
			}
			loadBlog();
			showAllBlogComments();
			listBlogs();
			
		});