package com.Collaboration.dao;

import com.Collaboration.model.ProfilePicture;

public interface ProfilePictureDAO {
public boolean save(ProfilePicture profilePicture);
public ProfilePicture getProfilePicture(String username);
}
