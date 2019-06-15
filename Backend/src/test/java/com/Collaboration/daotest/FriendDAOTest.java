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
import com.Collaboration.model.UserDetail;

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
	public void sendfriendrequesttest() {
		Friend friend=new Friend();
		friend.setFriendFirstName("suresh");
		friend.setFriendSurName("joe");
		friend.setFriendusername("sureshjoe");
		friend.setUsername("issacjoe");
		friend.setStatus("NA");
		assertTrue("problem in adding friend",friendDAO.sendFriendRequest(friend));
	}
	@Ignore
	@Test
	public void getfriendtest() {
		assertNotNull("problem in getting user",friendDAO.getFriend(521));
	}
	@Ignore
	@Test
	public void acceptfriendrequesttest() {
		Friend friend=friendDAO.getFriend(503);
		assertTrue("problem in adding friend",friendDAO.acceptFriendRequest(friend));
	}
    @Ignore
	@Test
	public void deletefriendrequesttest() {
		Friend friend=friendDAO.getFriend(503);
		assertTrue("problem in adding friend",friendDAO.deleteFriendRequest(friend));
	}
    @Ignore
	@Test
	public void showfriendlisttest() {
		List<Friend> listFriends=friendDAO.showFriendList("issacjoe");
		for(Friend friend:listFriends) {
			System.out.println("username:"+friend.getFriendusername());
		}
	}
	@Ignore
	@Test
	public void showpendingfriendrequesttest() {
		List<Friend> listFriends=friendDAO.showPendingFriendRequest("issacjoe");
		for(Friend friend:listFriends) {
			System.out.println("username:"+friend.getFriendusername());
		}
	}
	@Ignore
	@Test
	public void showsuggestedfriendstest() {
		List<UserDetail> listUsers=friendDAO.showSuggestedFriends("issacjoe");
		for(UserDetail userDetail:listUsers) {
			System.out.println("username:"+userDetail.getUsername());
		}
	}
}
