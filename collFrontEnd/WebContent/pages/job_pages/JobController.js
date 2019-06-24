myApp.controller("JobController",function($scope,$location,$rootScope,$http)
{
	$scope.job={"jobId":0,"jobDesignation":"","companyName":"","ctc":0,"jobLocation":"","lastDate":"","skills":""};
	
	$rootScope.jobdata;
	
	$scope.jobs;
	
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
	listJobs();
	
});