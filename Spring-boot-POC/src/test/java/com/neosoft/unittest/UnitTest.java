package com.neosoft.unittest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.neosoft.controller.UserController;
import com.neosoft.model.Gender;
import com.neosoft.model.User;
import com.neosoft.service.UserService;

import static org.hamcrest.Matchers.*;

@WebMvcTest(value = UserController.class)
public class UnitTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService userService;
	
	@Test
	void contextLoads() {
	}
	
	User mockUser1 = new User(1L, "Rachel", "Zane", "9898989898", Gender.FEMALE ,new Date(2000-5-18), new Date(2021-4-19), "Ghatkopar", "Mumbai", "Maharashtra", "India", "400086");
	User mockUser2 = new User(2L, "Mike", "Ross", "8898989898", Gender.MALE ,new Date(2000-2-14), new Date(2025-5-25), "Vikhroli", "Mumbai", "Maharashtra", "India", "400079");
	User mockUser3 = new User(3L, "Harvey", "Specter", "9888989898", Gender.MALE ,new Date(1995-6-26), new Date(2015-4-3), "Ghatkopar", "Mumbai", "Maharashtra", "India", "400086");
	
	@Test
	public void getAllUser() throws Exception{
		List<User> mockUsers = new ArrayList<User>
		(Arrays.asList(mockUser1,mockUser2,mockUser3));
		
		Mockito.when(userService.getAllUser()).thenReturn(mockUsers);
		
		
		mockMvc.perform(MockMvcRequestBuilders
				.get("/users")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(3)));
	}
}
