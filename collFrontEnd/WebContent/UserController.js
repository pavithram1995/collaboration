myApp.controller("UserController",function($scope,$location,$rootScope)
{
	$scope.userDetail={username:'',firstname:'',lastname:'',password:'',emailid:''};
	
	$scope.checkUser=function()
	{
		console.log($scope.userDetail);
		
		$location.path("/login");
	}
	$scope.register=function()
	{
		$scope.userDetail.role='ROLE_USER';
		$scope.userDetail.status='Y';
		$scope.userDetail.isOnline='N';
		
		console.log($scope.userDetail);
		
	}
	});