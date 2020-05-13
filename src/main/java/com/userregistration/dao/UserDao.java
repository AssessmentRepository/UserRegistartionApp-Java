package com.userregistration.dao;

import java.util.List;

import com.userregistration.model.User;

public interface UserDao {	
	int saveUser(User user);
	User getUser(int userId);
	List<User> listAllUsers();
	void updateUser(int userId,User user);
	void deleteUser(int userId);
}
