package com.userregistration.boundarycases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.userregistration.model.User;
import com.userregistration.utiltestclass.MasterData;

public class TestBoundary {
    
    @Test
	public void testUserNameLength() {
    	User user = MasterData.getDetails();
		user.getUserName();
		int maxChar = 5;
		boolean usernameLength = ((user.getUserName().length()) >= maxChar);
		assertEquals(usernameLength, true);
	}
    
    @Test
	public void testPasswordLength() {
    	User user = MasterData.getDetails();
		user.getUserPassword();
		int passwordLength = 10;
		assertEquals(passwordLength, user.getUserPassword().length());
	}
    @Test
    public void testActiveUser() {
    	User user = MasterData.getDetails();
    	user.isActive();
    	boolean reslut = true;
    	assertEquals(reslut, user.isActive());
    }
}