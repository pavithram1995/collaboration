myApp.controller("JobController",function($scope,$location,$rootScope,$http)
{
	$scope.job={"jobId":0,"jobDesignation":"","username":"","companyName":"","ctc":0,"jobLocation":"","lastDate":"","skills":"","status":""};
	
	$rootScope.jobdata;
	
	$rootScope.jobId;
	
	$scope.publishJob=function()
	{
		console.log('--- I am in publish job ---');
		
		$http.post('http://localhost:8080/collMiddleWare/publishJob',$scope.job)
		.then(function(response)
				{
					alert("Job published");
					$location.path("/showJob");
				},
				function(errresponse)
				{
					alert("Error Occured While Job publishing");
				});
	}
	
	function listJobs()
	{
		console.log('List Job Method');
		
		$http.get('http://localhost:8080/collMiddleWare/showAllJob')
		.then(function(response)
				{
			console.log('Showing all the Jobs');
			$scope.jobdata=response.data;
		},
		function(errresponse){
			console.log('Error Occured');
		});
	}
	
	$scope.deleteJob=function(jobId)
	{
		console.log('Job Deleted');
		$http.delete('http://localhost:8080/collMiddleWare/deleteJob/'+jobId)
		.then(function(response)
				{
			listJobs();
			alert('Job Deleted');
			$location.path("/showJob");
				},
				function(errresponse)
				{
					console.log('Error Occured');
					alert('Error Occured while Deleting Job');
			
				});	
	}
	
	$scope.apply=function(jobId)
	{
		$scope.job.username=$rootScope.currentUser.username;
		$http.get('http://localhost:8080/collMiddleWare/applyJob/'+jobId)
		.then(function(response)
				{
			listJobs();
			alert('Job Applied');
			console.log('Job Applied');
			$location.path("/showJob");
				},
				function(errresponse)
				{
					console.log('Error Occured');
					alert('Error Occured while Applying Job');
			
				});	
	}
	
	listJobs();
	
});