package com.userregistration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.userregistration.dao.UserDao;
import com.userregistration.model.User;

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;	
	@Transactional	
	@Override
	public int saveUser(User user) {
		return 0;
				
	}	
	@Override
	public User getUser(int userId) {
		return null;
		
	}	
	@Override
	public List<User> listAllUser() {
		return null;
		
	}
	@Override
	@Transactional
	public void updateUser(int userId,User user) {		
		
	}	
	@Override
	@Transactional
	public void deleteUser(int userId) {
		
	}
}
