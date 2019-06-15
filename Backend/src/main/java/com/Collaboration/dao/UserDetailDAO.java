package com.Collaboration.dao;

import java.util.List;

import com.Collaboration.model.UserDetail;

public interface UserDetailDAO {

public boolean addUser(UserDetail user);
public UserDetail getUser(String username);
public boolean updateUser(UserDetail user);
public List<UserDetail> getUsers();
public UserDetail checkUser(UserDetail user);
	
}
