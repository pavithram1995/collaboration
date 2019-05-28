package com.coll.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.coll.DAO.FriendDAO;
import com.coll.model.Friend;


@RestController
public class FriendRestController 
{
	@Autowired
	FriendDAO friendDAO;
	
	@GetMapping("/showAllFriends/{username}")
	public ResponseEntity<List<Friend>> showAllFriends(@PathVariable("username")String username)
	{
		List<Friend> listFriends=friendDAO.getFriends(username);
		
		if(listFriends.size()>0)
		{
			return new ResponseEntity<List<Friend>>(listFriends,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Friend>>(listFriends,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getFriend/{friendId}")
	
		public ResponseEntity<Friend> getBlog(@PathVariable("friendId")int friendId)
		{
		Friend friend=(Friend)friendDAO.getFriend(friendId);
		return new ResponseEntity<Friend>(friend,HttpStatus.OK);
		}
}
