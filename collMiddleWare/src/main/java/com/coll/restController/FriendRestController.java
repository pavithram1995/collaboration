package com.coll.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coll.DAO.FriendDAO;
import com.coll.model.Friend;
import com.coll.model.UserDetail;


@RestController
public class FriendRestController 
{
	@Autowired
	FriendDAO friendDAO;
	
	@GetMapping("/showAllFriends/{username}")
	public ResponseEntity<List<Friend>> showAllFriends(@PathVariable("username")String username)
	{
		List<Friend> listFriends=friendDAO.showFriendList(username);
		
		if(listFriends.size()>0)
		{
			return new ResponseEntity<List<Friend>>(listFriends,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Friend>>(listFriends,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/showPendingFriendList/{username}")
	
		public ResponseEntity<List<Friend>> showPendingFriendList(@PathVariable("username")String username)
		{
		
		List<Friend> friendList=friendDAO.showPendingFriendList(username);
		
		if(friendList.size()>0)
		{
			return new ResponseEntity<List<Friend>>(friendList,HttpStatus.OK);
		}
		else
			return new ResponseEntity<List<Friend>>(friendList,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	@GetMapping("/showSuggestedFriendList/{username}")
	
	public ResponseEntity<List<UserDetail>> showSuggestedFriendList(@PathVariable("username")String username)
	{
	
	List<UserDetail> friendSuggestedList=friendDAO.showSuggestedFriend(username);
	
	if(friendSuggestedList.size()>0)
	{
		return new ResponseEntity<List<UserDetail>>(friendSuggestedList,HttpStatus.OK);
	}
	else
		return new ResponseEntity<List<UserDetail>>(friendSuggestedList,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/acceptFriendRequest/{friendId}")
	
	public ResponseEntity<String> acceptFriendRequest(@PathVariable("friendId")int friendId)
	{
		if(friendDAO.acceptFriendRequest(friendId))
		{
			return new ResponseEntity<String>("Friend requested Accepted",HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Failure",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/deleteFriendRequest/{friendId}")
	public ResponseEntity<String> deleteFriendRequest(@PathVariable("friendId")int friendId)
	{
		if(friendDAO.deleteFriendRequest(friendId))
		{
			return new ResponseEntity<String>("Friend requested Deleted",HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Failure",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/sendFriendRequest")
	public ResponseEntity<String> sendFriendRequest(@RequestBody Friend friend)
	{
		if(friendDAO.sendFriendRequest(friend))
		{
			return new ResponseEntity<String>("Friend requested Deleted",HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Failure",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
