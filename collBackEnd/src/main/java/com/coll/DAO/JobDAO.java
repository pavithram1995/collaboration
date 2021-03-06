package com.coll.DAO;

import java.util.List;

import com.coll.model.Job;

public interface JobDAO 
{

public boolean publishJob(Job job);
public boolean deleteJob(Job job);
public Job getJob(int jobId);
public List<Job> getJobs();
public boolean applyJob(Job job);
public List<Job> listJobs(String username);

}
