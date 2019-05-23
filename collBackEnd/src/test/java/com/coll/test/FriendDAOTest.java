package com.coll.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.DAO.FriendDAO;
import com.coll.model.Friend;

public class FriendDAOTest 
{
static FriendDAO friendDAO;
	
	@BeforeClass
	public static void executefirst() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		friendDAO=(FriendDAO)context.getBean("friendDAO");
	}
	@Ignore
	@Test
	public void addfriendtest() {
		Friend friend=new Friend();
		friend.setFriendName("kaviya");
		friend.setFriendId(1002);
		friend.setUsername("pavithra");
		friend.setStatus("NA");
		assertTrue("problem in adding friend",friendDAO.addFriend(friend));
	}
	@Ignore
	@Test
	public void getfriendtest() {
		assertNotNull("problem in getting user",friendDAO.getFriend(1001));
	}
	@Ignore
	@Test
	public void deletefriendtest() {
		Friend friend=friendDAO.getFriend(1001);
		
		assertTrue("problem in adding friend",friendDAO.deleteFriend(friend));
	}
	@Test
	public void updatefriendtest() {
		Friend friend=friendDAO.getFriend(1002);
		friend.setFriendusername("kaviya");
		assertTrue("problem in adding friend",friendDAO.updateFriend(friend));
	}
	@Test
	public void getfriendstest() {
		List<Friend> listFriends=friendDAO.getFriends("pavithra");
		for(Friend friend:listFriends) {
			System.out.println("friendname:"+friend.getFriendName());
		}
	}
}
