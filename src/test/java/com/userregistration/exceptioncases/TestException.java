package com.userregistration.exceptioncases;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.userregistration.exception.UserAlreadyExistException;
import com.userregistration.exception.UserDoesNotExistException;
import com.userregistration.model.User;
import com.userregistration.service.LoginServiceImpl;


public class TestException {
	@InjectMocks
	private LoginServiceImpl loginServiceImpl;
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}


	@Test
	public void testForUserRegistration() throws UserAlreadyExistException {
		User user = new User();
		user.setUserId(1);
		user.setUserFirstName("Besta");
		user.setUserLastName("Shashidhar");
		user.setUserName("B Shashidhar");
		user.setUserEmail("shashi.2346@gmail.com");
		user.setUserPassword("1234567890");
		user.setProfilePicture("www.google.com");
		user.setActive(true);
		loginServiceImpl.register(user);
		assertEquals(UserAlreadyExistException.message, "user already exists !..please login");
	}

	@Test
	public void testForUserLogin() throws UserDoesNotExistException {
		User user = new User();
		user.setUserName("admin");
		user.setUserPassword("james");
		loginServiceImpl.login(user.getUserName(), user.getUserPassword());
		assertEquals(UserDoesNotExistException.message, "user already exists !..please login");
	}
}
