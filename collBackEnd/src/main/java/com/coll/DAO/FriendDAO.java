package com.coll.DAO;

import java.util.List;

import com.coll.model.Friend;

public interface FriendDAO 
{
	public boolean addFriend(Friend friend);
	public boolean deleteFriend(Friend friend);
	public boolean updateFriend(Friend friend);
	public Friend getFriend(int friendid);
	public List<Friend> getFriends(String username);

}
