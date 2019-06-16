package com.coll.DAO;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coll.model.ProfilePicture;

@Repository("profilePictureDAO")
@Transactional
public class ProfilePictureDAOImpl implements ProfilePictureDAO
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean save(ProfilePicture profilePicture) 
	{
		try
		{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(profilePicture);
		System.out.println("Profile Picture saved");
		session.flush();
		return true;
		}
		catch(Exception e)
		{
			System.out.print("Exception"+e);
			return false;
		}
	}

	@Override
	public ProfilePicture getProfilePicture(String username)
	{
		Session session=sessionFactory.openSession();
		ProfilePicture profilePicture=session.get(ProfilePicture.class,username);
		session.close();
		return profilePicture;
	}

}
