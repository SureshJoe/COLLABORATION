package com.Collaboration.daotest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Collaboration.dao.UserDetailDAO;
import com.Collaboration.model.UserDetail;

public class UserDetailDAOTest {

	static UserDetailDAO userdetailDAO;
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void executefirst() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.Collaboration");
		context.refresh();
		userdetailDAO=(UserDetailDAO)context.getBean("userdetailDAO");
	}
	
	@Ignore
	@Test
	public void addusertest() {
		UserDetail user=new UserDetail();
		user.setUsername("issacjoe");
		user.setFirstname("issac");
		user.setSurname("joe");
		user.setPassword("joe");
		user.setEmailId("issacjoe@gmail.com");
		assertTrue("problem in adding user",userdetailDAO.addUser(user));
	}
	@Ignore
	@Test
	public void getusertest() {
		assertNotNull("problem in getting user",userdetailDAO.getUser("issacjoe"));
	}
	@Ignore
	@Test
	public void updateusertest() {
		UserDetail user=userdetailDAO.getUser("issacjoe");
		user.setRole("ROLE_ADMIN");
		assertTrue("problem in updating user",userdetailDAO.updateUser(user));
	}
	@Ignore
	@Test
	public void listusertest() {
		List<UserDetail> listUsers=userdetailDAO.getUsers();
		for(UserDetail user:listUsers) {
			System.out.println("username:"+user.getUsername());
		}
	}
	
	@Test
	public void checkusertest() {
		assertTrue("problem in checking user",userdetailDAO.checkUser("issacjoe","joe"));
	}
	
}

