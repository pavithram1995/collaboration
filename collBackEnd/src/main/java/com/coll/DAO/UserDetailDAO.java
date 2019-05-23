package com.coll.DAO;

import java.util.List;

import com.coll.model.UserDetail;

public interface UserDetailDAO
{
	public boolean addUser(UserDetail user);
	public UserDetail getUser(String username);
	public boolean updateUser(UserDetail user);
	public List<UserDetail> getUsers();
	public boolean checkUser(String username,String password);
	
}
