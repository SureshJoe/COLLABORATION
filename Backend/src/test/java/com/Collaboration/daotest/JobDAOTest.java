package com.Collaboration.daotest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Collaboration.dao.JobDAO;
import com.Collaboration.model.Job;

public class JobDAOTest {

	static JobDAO jobDAO;
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void executefirst() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.Collaboration");
		context.refresh();
		jobDAO=(JobDAO)context.getBean("jobDAO");
	}
	
	@Test
	public void addjobtest() {
		Job job=new Job();
		job.setJobDesignation("illistrator");
		job.setCompanyName("P3 airbus");
	    job.setCTC(400000);
	    job.setJobLocation("Bangalore");
	    job.setLastDate(new java.util.Date(2019,05,20));
	    job.setSkills("java");
	    assertTrue("problem in adding job",jobDAO.addJob(job));
	}
	@Ignore
	@Test
	public void getjobtest() {
		assertNotNull("problem in getting job",jobDAO.getJob(502));
	}
	@Ignore
	@Test 
	public void getjobstest() {
		List<Job> listJobs=jobDAO.getJobs();
	    for(Job job:listJobs) {
	    	System.out.println("jobid:"+job.getJobId());
	    }
	}
	@Ignore
	@Test
	public void deletejobtest() {
		Job job=jobDAO.getJob(502);
		assertTrue("problem in adding job",jobDAO.deleteJob(job));
	}
}
