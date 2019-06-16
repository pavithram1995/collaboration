package com.coll.DAO;

import com.coll.model.ProfilePicture;

public interface ProfilePictureDAO 
{
	public boolean save(ProfilePicture profilepicture);
	public ProfilePicture getProfilePicture(String username);
}
