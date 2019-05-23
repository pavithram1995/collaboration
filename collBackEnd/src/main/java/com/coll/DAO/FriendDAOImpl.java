package com.coll.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coll.model.Friend;

@Repository("friendDAO")
@Transactional
public class FriendDAOImpl implements FriendDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addFriend(Friend friend)
	{
		try {
			sessionFactory.getCurrentSession().save(friend);
			System.out.println("Friend Data Created");
			return true;
		}
		catch(Exception e) 
		{
			return false;
		}
	}

	@Override
	public boolean deleteFriend(Friend friend) 
	{
		try {
			sessionFactory.getCurrentSession().delete(friend);
			System.out.println("Friend Data Deleted");
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public Friend getFriend(int friendid)
	{
		Session session=sessionFactory.openSession();
		Friend friend=session.get(Friend.class,friendid);
		session.close();
		return friend;
	}

	@Override
	public List<Friend> getFriends(String username)
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Friend where username=:uname");
		query.setParameter("uname",username);
		List<Friend> listFriends=query.list();
		return listFriends;
	}

	@Override
	public boolean updateFriend(Friend friend)
	{
		try {
			sessionFactory.getCurrentSession().update(friend);
			System.out.println("Friend Data updated");
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	
	}

}
