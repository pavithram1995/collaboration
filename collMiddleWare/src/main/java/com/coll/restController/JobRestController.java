package com.coll.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.coll.DAO.JobDAO;
import com.coll.model.Job;

@RestController
public class JobRestController 
{
	@Autowired
	JobDAO jobDAO;
	
	@GetMapping("/showAllJob")
	public ResponseEntity<List<Job>> showAllJob()
	{
		List<Job> listJob=jobDAO.getJobs();
		
		if(listJob.size()>0)
		{
			return new ResponseEntity<List<Job>>(listJob,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Job>>(listJob,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getJob/{jobId}")
	
		public ResponseEntity<Job> getBlog(@PathVariable("jobId")int jobId)
		{
		Job job=(Job)jobDAO.getJob(jobId);
		return new ResponseEntity<Job>(job,HttpStatus.OK);
		}

}