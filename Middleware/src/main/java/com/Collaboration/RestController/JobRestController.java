package com.Collaboration.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.Collaboration.dao.JobDAO;
import com.Collaboration.model.Job;

@RestController
public class JobRestController {

	@Autowired
	JobDAO jobDAO;
	
	@GetMapping("/getJobs")
	public ResponseEntity<List<Job>> getJobs() 
	{
		List<Job> listJobs=jobDAO.getJobs();
		if(listJobs.size()>0) {
			return new ResponseEntity<List<Job>>(listJobs,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<Job>>(listJobs,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getJob/{jobId}")
	public ResponseEntity<Job> getJob(@PathVariable("jobId") int jobId)
	{
		Job job=jobDAO.getJob(jobId);
		return new ResponseEntity<Job>(job,HttpStatus.OK);
	}
}
