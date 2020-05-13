package com.userregistration.functionalcases;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.google.gson.Gson;
import com.userregistration.controller.UserController;
import com.userregistration.model.User;
import com.userregistration.service.UserService;
import com.userregistration.utiltestclass.MasterData;

public class TestController {

	@Mock
	private UserService userService;

	@InjectMocks
	private UserController userController;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}

	@Test
	public void testLoadingPageUrl() throws Exception {
		this.mockMvc.perform(get("/hi")).andExpect(status().isOk());
	}

	@Test
	public void testSaveUsersApi() throws Exception {
		Gson gson = new Gson();
		when(userService.saveUser(MasterData.getDetails())).thenReturn(0);
		this.mockMvc
				.perform(post("/registere").content(gson.toJson(MasterData.getDetails()))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void testGetUserApi() throws Exception {
		User user = new User();
		when(userService.getUser(1)).thenReturn(user);
		this.mockMvc.perform(get("/user/{id}", 1))
		.andExpect(status().isOk());
	}

	@Test
	public void testViewAllUsersApi() throws Exception {
		List<User> userList = new ArrayList<>();
		userList.add(new User());
		userList.add(new User());
		when(userService.listAllUser()).thenReturn((List<User>) userList);
		this.mockMvc.perform(get("/users")).andExpect(status().isOk());
	}

	@Test
	public void testViewAllUsersApiCase1() throws Exception {
		when(userService.listAllUser()).thenReturn(null);
		this.mockMvc.perform(get("/users")).andExpect(status().isOk());
	}
}
