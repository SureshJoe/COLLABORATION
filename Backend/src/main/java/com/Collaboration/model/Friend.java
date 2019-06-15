package com.Collaboration.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Friend {
	
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Friendid")
@SequenceGenerator(name="Friendid",allocationSize=1,sequenceName="Friendid_seq")
private int friendId;
private String username;
private String friendusername;
private String friendFirstName;
private String friendSurName;
private String status;
public String getFriendFirstName() {
	return friendFirstName;
}
public void setFriendFirstName(String friendFirstName) {
	this.friendFirstName = friendFirstName;
}



public int getFriendId() {
	return friendId;
}
public void setFriendId(int friendId) {
	this.friendId = friendId;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}

public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getFriendusername() {
	return friendusername;
}
public void setFriendusername(String friendusername) {
	this.friendusername = friendusername;
}
public String getFriendSurName() {
	return friendSurName;
}
public void setFriendSurName(String friendSurName) {
	this.friendSurName = friendSurName;
}
}

