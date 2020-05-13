package com.userregistration.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.userregistration.model.User;
@Repository
@Transactional
public class UserDaoImp implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int saveUser(User user) {
		return 0;
		
	}

	@Override
	public User getUser(int userId) {
		return null;
		
	}

	@Override
	public void updateUser(int userId, User user) {
		
	}

	@Override
	public void deleteUser(int userId) {
		
	}

	@Override
	public List<User> listAllUsers() {
		return null;
		
	}
}
