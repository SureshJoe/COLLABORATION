package com.Collaboration.daotest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Collaboration.dao.FriendDAO;
import com.Collaboration.model.Friend;

public class FriendDAOTest {

	static FriendDAO friendDAO;
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void executefirst() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.Collaboration");
		context.refresh();
		friendDAO=(FriendDAO)context.getBean("friendDAO");
	}
	
	@Test
	public void addfriendtest() {
		Friend friend=new Friend();
		friend.setFriendName("suresh");
		friend.setUsername("issacjoe");
		friend.setStatus("NA");
		assertTrue("problem in adding friend",friendDAO.addFriend(friend));
	}
	@Ignore
	@Test
	public void getfriendtest() {
		assertNotNull("problem in getting user",friendDAO.getFriend(501));
	}
	@Ignore
	@Test
	public void deletefriendtest() {
		Friend friend=friendDAO.getFriend(502);
		assertTrue("problem in adding friend",friendDAO.deleteFriend(friend));
	}
	@Ignore
	@Test
	public void getfriendstest() {
		List<Friend> listFriends=friendDAO.getFriends("issacjoe");
		for(Friend friend:listFriends) {
			System.out.println("friendname:"+friend.getFriendName());
		}
	}
}

