package com.coll.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.DAO.UserDetailDAO;
import com.coll.model.UserDetail;

public class UserDetailDAOTest
{
static UserDetailDAO userdetailDAO;
	
	@BeforeClass
	public static void executefirst() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		userdetailDAO=(UserDetailDAO)context.getBean("userdetailDAO");
	}
	
	@Ignore
	@Test
	public void addusertest() 
	{
		UserDetail user=new UserDetail();
		user.setUsername("pavithra");
		user.setFirstname("pavi");
		user.setLastname("thra");
		user.setPassword("pavithra123");
		user.setEmailId("pavithra@gmail.com");
		assertTrue("problem in adding user",userdetailDAO.addUser(user));
	}
	
	@Test
	public void getusertest() {
		assertNotNull("problem in getting user",userdetailDAO.getUser("pavithra"));
	}
	
	@Test
	public void updateusertest() 
	{
		UserDetail user=userdetailDAO.getUser("pavithra");
		user.setIsOnline("Y");
		user.setStatus("NA");
		assertTrue("problem in updating user",userdetailDAO.updateUser(user));
	}
	
	@Test
	public void listusertest() 
	{
		List<UserDetail> listUsers=userdetailDAO.getUsers();
		for(UserDetail user:listUsers)
		{
			System.out.println("username:"+user.getUsername());
		}
	}
	@Test
	public void checkusertest() 
	{
		UserDetail user=userdetailDAO.getUser("pavithra");
		System.out.println("User has been checked");
		assertNotNull("problem in checking user",userdetailDAO.checkUser(user));
	}

	
	
}
