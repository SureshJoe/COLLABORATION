package com.Collaboration.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Collaboration.model.ProfilePicture;

@Repository("profilePictureDAO")
@Transactional
public class ProfilePictureDAOImpl implements ProfilePictureDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean save(ProfilePicture profilePicture) {
	    
		try {
			Session session=sessionFactory.getCurrentSession();
			session.saveOrUpdate(profilePicture);
			session.flush();
			return true;
		}
		catch(Exception e) {
			return false;
		}
		
	}

	@Override
	public ProfilePicture getProfilePicture(String username) {
		Session session=sessionFactory.openSession();
		ProfilePicture profilePicture=session.get(ProfilePicture.class,username);
		session.close();
		return profilePicture;
		}

}
