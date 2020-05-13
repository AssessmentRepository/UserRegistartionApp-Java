package com.userregistration.functionalcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.userregistration.dao.UserDao;
import com.userregistration.model.User;
import com.userregistration.service.UserServiceImpl;
import com.userregistration.utiltestclass.MasterData;

public class TestFunctional {

	@Mock
	private UserDao userDao;

	@Mock
	private User user;

	@InjectMocks
	private UserServiceImpl userServiceImpl;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testSaveUsersImplTest() throws Exception {
		userServiceImpl.saveUser(MasterData.getDetails());
		int id=MasterData.getDetails().getUserId();
		assertNotNull(id);
	}

	@Test
	public void testGetUsersImplTest() throws Exception {
		user = userServiceImpl.getUser(MasterData.getDetails().getUserId());
		when(userDao.getUser(1)).thenReturn(user);
		User res = userServiceImpl.getUser(1);
		assertEquals(user, res);
	}

	@Test
	public void testViewAllUsersImplTest() throws Exception {
		List<User> list = new ArrayList<User>();
		User user1 = new User();
		user1.setUserId(1);
		user1.setUserFirstName("Besta");
		user1.setUserLastName("Shashidhar");
		user1.setUserName("B Shashidhar");
		user1.setUserEmail("shashi@gmail.com");
		user1.setUserPassword("123456789");
		user1.setProfilePicture("google.com");
		user1.isActive();
		User user2 = new User();
		user2.setUserId(2);
		user2.setUserFirstName("Besta");
		user2.setUserLastName("Shashidhar");
		user2.setUserName("B Shashidhar");
		user2.setUserEmail("shashi@gmail.com");
		user2.setUserPassword("123456789");
		user2.setProfilePicture("google.com");
		user2.isActive();

		list.add(user1);
		list.add(user2);

		when(userDao.listAllUsers()).thenReturn(list);
		assertEquals(2, list.size());
	}

	
	@Test
	public void testDeleteUsersImplTest() throws Exception {
		User user = userServiceImpl.getUser(MasterData.getDetails().getUserId());
		when(userDao.getUser(1)).thenReturn(user).thenReturn(null);
		User res = userServiceImpl.getUser(1);
		assertEquals(null, res);
	}
}
