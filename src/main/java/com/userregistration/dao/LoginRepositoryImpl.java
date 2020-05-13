package com.userregistration.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class LoginRepositoryImpl implements LoginRepository {

	public boolean login(String userName, String password) {
		return false;
	}

	public boolean resetPassword(String userName, String password) {
		return false;
	}

}
