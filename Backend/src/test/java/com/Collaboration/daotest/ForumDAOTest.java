package com.Collaboration.daotest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Collaboration.dao.ForumDAO;
import com.Collaboration.model.Forum;

public class ForumDAOTest {

	static ForumDAO forumDAO;
	@SuppressWarnings("resource")
	@BeforeClass
	public static void executefirst() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.Collaboration");
		context.refresh();
		forumDAO=(ForumDAO)context.getBean("forumDAO");
	}
	@Ignore
	@Test
	public void addforumtest() {
		Forum forum=new Forum();
		forum.setForumName("new forum");
		forum.setForumContent("iam create content");
		forum.setCreateDate(new java.util.Date());
		forum.setUsername("issacjoe");
		forum.setStatus("NA");
		assertTrue("problem in adding forum",forumDAO.addForum(forum));
	}
	@Ignore
	@Test
	public void getforumtest() {
		assertNotNull("problem in getting forum",forumDAO.getForum(502));
	}
	@Ignore
	@Test
	public void updateforumtest() {
		Forum forum=forumDAO.getForum(502);
		forum.setForumContent("first content");
		assertTrue("problem in updating forum",forumDAO.updateForum(forum));
	}
	@Ignore
	@Test
	public void deleteforumtest() {
		Forum forum=forumDAO.getForum(502);
		assertTrue("problem in deleting forum",forumDAO.deleteForum(forum));
	}
	@Ignore
	@Test
	public void listblogtest() {
		List<Forum> listForums=forumDAO.getForums();
		for(Forum forum:listForums) {
			System.out.println("id:"+forum.getForumId());
		}
	}
	@Ignore
	@Test
	public void approveforumtest() {
		Forum forum=forumDAO.getForum(502);
		assertTrue("problem in incrementing likes",forumDAO.approveForum(forum));
	}
	
	@Test
	public void rejectforumtest() {
		Forum forum=forumDAO.getForum(502);
		assertTrue("problem in incrementing likes",forumDAO.rejectForum(forum));
	}
}

