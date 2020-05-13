package com.userregistration.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.userregistration.model.User;

@Service("LoginService")
@Transactional
public class LoginServiceImpl implements LoginService {
	
	public boolean register(User user) {
		return false;
	}

	public boolean login(String userName, String password) {
		return false;
	}
	
	public boolean resetPassword(String userName, String password) {
		return false;
	}
}
