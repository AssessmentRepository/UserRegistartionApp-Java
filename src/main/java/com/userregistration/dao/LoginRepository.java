package com.userregistration.dao;

public interface LoginRepository {
	boolean login(String userName,String password);
	boolean resetPassword(String userName,String password);
}
