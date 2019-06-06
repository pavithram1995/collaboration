myApp.controller("UserController",function($scope,$location,$rootScope,$http)
{
	$scope.userDetail={username:'',firstname:'',lastname:'',password:'',emailid:''};
	
	$rootScope.currentUser;
	
	$scope.checkUser=function()
	{
		console.log($scope.userDetail);
		
		$http.post('http://localhost:8080/collMiddleWare/checkuser',JSON.stringify($scope.userDetail))
		.then(function(response)
		{
			console.log('Logged In');
			console.log(response.data);
			console.log(response.statusCode);
			$rootScope.currentUser=response.data;
			console.log($rootScope.currentUser);
			$location.path("/blog");
		},
		function(errresponse)
		{
			console.log('Error');
			console.log("/login");
		});
		
	}
	$scope.register=function()
	{
		$scope.userDetail.role='ROLE_USER';
		$scope.userDetail.status='Y';
		$scope.userDetail.isOnline='N';
		
		console.log($scope.userDetail);
		$http.post('http://localhost:8080/collMiddleWare/registerUser',JSON.stringify($scope.userDetail))
		.then(function(response)
		{
			console.log('User is registered');
			console.log(response.data);
			$location.path("/login");
		},
		function(errresponse)
		{
			console.log('Error occured during registration');
			console.log(errresponse.data);
		});
		
	}
	});