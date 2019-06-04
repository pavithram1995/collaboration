package com.coll.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.DAO.FriendDAO;
import com.coll.model.Friend;
import com.coll.model.UserDetail;

public class FriendDAOTest 
{
static FriendDAO friendDAO;
	
	@BeforeClass
	public static void executefirst() 
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		friendDAO=(FriendDAO)context.getBean("friendDAO");
	}
	
	@Ignore
	@Test
	public void sendFriendRequestTest()
	{
		Friend friend=new Friend();
		
		friend.setUsername("Amazon");
		friend.setFriendusername("facebook");
		
		assertTrue("problem in sending Friend Request",friendDAO.sendFriendRequest(friend));
	}
	@Ignore
	@Test
	public void showFriendListTest()
	{
		List<Friend> friendlist=friendDAO.showFriendList("pavithra");
		assertTrue("Problem in showing Friend List",friendlist.size()>0);
		
		for(Friend friend:friendlist)
		{
			System.out.print(friend.getUsername()+":::");
			System.out.print(friend.getFriendfirstname()+":::");
			System.out.println(friend.getFriendlastname());
		}
	}
	@Ignore
	@Test
	public void acceptFriendRequest()
	{
		assertTrue("Problem in Accepting Friend Request",friendDAO.acceptFriendRequest(1021));
	}
	@Ignore
	@Test
	public void showPendingFriendListTest()
	{
		List<Friend> pendingFriendList=friendDAO.showPendingFriendList("facebook");
		assertTrue("Problem in Showing Pending Friend List",pendingFriendList.size()>0);
		
		for(Friend friend:pendingFriendList)
		{
			System.out.print(friend.getUsername());
		}
	}
	@Ignore
	@Test
	public void deleteFriendRequest()
	{
		assertTrue("Problem in Deleting Friend Request",friendDAO.deleteFriendRequest(1024));
	}
	
	@Test
	public void showSuggestedFriendListTest()
	{
		List<UserDetail> userDetailList=friendDAO.showSuggestedFriend("facebook");
		
		assertTrue("problem in showingSuggestedFriend List:",userDetailList.size()>0);
		
		for(UserDetail userDetail:userDetailList)
		{
			System.out.println(userDetail.getUsername());
		}
	}
}
