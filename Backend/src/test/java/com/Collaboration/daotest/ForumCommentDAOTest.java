package com.Collaboration.daotest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Collaboration.dao.ForumCommentDAO;
import com.Collaboration.model.ForumComment;

public class ForumCommentDAOTest {

	static ForumCommentDAO forumcommentDAO;
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void executefirst() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.Collaboration");
		context.refresh();
		forumcommentDAO=(ForumCommentDAO)context.getBean("forumcommentDAO");
	}
	
	@Test
	public void addforumcommenttest() {
		ForumComment forumcomment=new ForumComment();
		forumcomment.setForumId(502);
		forumcomment.setForumComment("good");
		forumcomment.setCommentDate(new java.util.Date());
		forumcomment.setUsername("issacjoe");
		assertTrue("problem in adding forum comment",forumcommentDAO.addForumComment(forumcomment));
	}
	
	@Test
	public void getforumcommenttest() {
		assertNotNull("problem in getting forumcomment",forumcommentDAO.getForumComment(502));
	}
	
	@Test
	public void updateforumcommenttest() {
		ForumComment forumcomment=forumcommentDAO.getForumComment(502);
		forumcomment.setForumComment("nice");
		assertTrue("problem in adding forum comment",forumcommentDAO.updateForumComment(forumcomment));
	}
	@Ignore
	@Test
	public void deleteforumcomment() {
		ForumComment forumcomment=forumcommentDAO.getForumComment(502);
		assertTrue("problem in deleting forum comment",forumcommentDAO.deleteForumComment(forumcomment));
	}
	@Ignore
	@Test
	public void listforumcomment() {
		List<ForumComment> listComments=forumcommentDAO.getForumComments();
	    for(ForumComment forumcomment:listComments) {
	    	System.out.println("id:"+forumcomment.getCommentId());
	    }
	}
}

