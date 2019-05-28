package com.coll.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.coll.DAO.UserDetailDAO;
import com.coll.model.UserDetail;


@RestController
public class UserDetailRestController 
{
@Autowired
UserDetailDAO userdetailDAO;

@GetMapping("/showAllUser")
public ResponseEntity<List<UserDetail>> showAllUser()
{
	List<UserDetail> listUserDetail=userdetailDAO.getUsers();
	
	if(listUserDetail.size()>0)
	{
		return new ResponseEntity<List<UserDetail>>(listUserDetail,HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<List<UserDetail>>(listUserDetail,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
@GetMapping("/getUser/{username}")

	public ResponseEntity<UserDetail> getBlog(@PathVariable("username")String username)
	{
	UserDetail user=(UserDetail)userdetailDAO.getUser(username);
	
	return new ResponseEntity<UserDetail>(user,HttpStatus.OK);
	}
}
