package com.userregistration.service;

import java.util.List;

import com.userregistration.model.User;

public interface UserService {
	int saveUser(User user);
	User getUser(int userId);
	List<User> listAllUser();
	void updateUser(int userId,User user);
	void deleteUser(int userId);
}
