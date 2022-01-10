package com.neosoft.unittest;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neosoft.controller.UserController;
import com.neosoft.exception.InvalidRequestException;
import com.neosoft.model.Gender;
import com.neosoft.model.User;
import com.neosoft.repository.UserRepository;
import com.neosoft.service.UserService;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@WebMvcTest(value = UserController.class)
public class UnitTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService userService;
	
	@MockBean
	private UserRepository userRepository;
	
	@Autowired
	ObjectMapper mapper;
	
	@Test
	void contextLoads() {
	}
	
	User mockUser1 = new User(1L, "Rachel", "Zane", "9898989898", Gender.FEMALE ,new Date(2000-5-18), new Date(2021-4-19), "Ghatkopar", "Mumbai", "Maharashtra", "India", "400086", 0);
	User mockUser2 = new User(2L, "Mike", "Ross", "8898989898", Gender.MALE ,new Date(2000-2-14), new Date(2025-5-25), "Vikhroli", "Mumbai", "Maharashtra", "India", "400079",0);
	User mockUser3 = new User(3L, "Harvey", "Specter", "9888989898", Gender.MALE ,new Date(1995-6-26), new Date(2015-4-3), "Ghatkopar", "Mumbai", "Maharashtra", "India", "400086",0);
	
	@Test
	public void getAllUser() throws Exception{
		List<User> mockUsers = new ArrayList<User>
		(Arrays.asList(mockUser1,mockUser2,mockUser3));
		
		Mockito.when(userService.getAllUser()).thenReturn(mockUsers);
		
		
		mockMvc.perform(MockMvcRequestBuilders
				.get("/users")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(3)))
				.andExpect(jsonPath("$[2].name", is("Harvey")));	
		}
	
	@Test
	public void getUserByName() throws Exception{
		User mockUserWithSameName = new User(1L, "Rachel", "Zane", "9898888888", Gender.FEMALE ,new Date(2000-5-18), new Date(2021-4-19), "Ghatkopar", "Mumbai", "Maharashtra", "India", "400086",0);
		List<User> mockUserList = new ArrayList<User>(Arrays.asList(mockUser1,mockUserWithSameName));
		
		Mockito.when(userService.findByName(mockUser1.getName())).thenReturn(mockUserList);
		
		mockMvc.perform(MockMvcRequestBuilders
				.get("/user/name/Rachel")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].name", is("Rachel")));
	}
	
	@Test
	public void getUserBySurame() throws Exception{
		User mockUserWithSameName = new User(1L, "Rachel", "Zane", "9898888888", Gender.FEMALE ,new Date(2000-5-18), new Date(2021-4-19), "Ghatkopar", "Mumbai", "Maharashtra", "India", "400086",0);
		List<User> mockUserList = new ArrayList<User>(Arrays.asList(mockUser1,mockUserWithSameName));
		
		Mockito.when(userService.findBySurname(mockUser1.getSurname())).thenReturn(mockUserList);
		
		mockMvc.perform(MockMvcRequestBuilders
				.get("/user/surname/Zane")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].surname", is("Zane")));
	}
	
	@Test
	public void getUserByPincode() throws Exception{
		User mockUserWithSameName = new User(1l, "Rachel", "Zane", "9898888888", Gender.FEMALE ,new Date(2000-5-18), new Date(2021-4-19), "Ghatkopar", "Mumbai", "Maharashtra", "India", "400086",0);
		List<User> mockUserList = new ArrayList<User>(Arrays.asList(mockUser1,mockUserWithSameName));
		
		Mockito.when(userService.findByPincode(mockUser1.getPincode())).thenReturn(mockUserList);
		
		mockMvc.perform(MockMvcRequestBuilders
				.get("/user/pincode/400086")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].pincode", is("400086")));
	}
	
	@Test
	public void getSortUserByDob() throws Exception{
		List<User> sortedByDob = new ArrayList<User>(Arrays.asList(mockUser3,mockUser2,mockUser1));
		List<User> users = new ArrayList<User>(Arrays.asList(mockUser1,mockUser2,mockUser3));
		
		Mockito.when(userService.getAllUser()).thenReturn(users);
		Mockito.when(userService.getSortedUserByDob(users)).thenReturn(sortedByDob);
		
		mockMvc.perform(MockMvcRequestBuilders
				.get("/users/sortbydob")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].name", is("Harvey")));
	}
	
	@Test
	public void getSortUserByJoinDate() throws Exception{
		List<User> sortedByJoinDate = new ArrayList<User>(Arrays.asList(mockUser3,mockUser1,mockUser2));
		List<User> users = new ArrayList<User>(Arrays.asList(mockUser1,mockUser2,mockUser3));
		
		Mockito.when(userService.getAllUser()).thenReturn(users);
		Mockito.when(userService.getSortedUserByJoinDate(users)).thenReturn(sortedByJoinDate);
		
		mockMvc.perform(MockMvcRequestBuilders
				.get("/users/sortbyjoindate")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[1].name", is("Rachel")));
	}
	
	@Test
	public void addUser() throws Exception{
		User user = User.builder()
				.id(1L)
				.name("John")
				.surname("Cena")
				.contact("9809809809")
				.gender(Gender.MALE)
				.dateOfBirth(new Date(1999-1-22))
				.joiningDate(new Date(2021-6-4))
				.address("Saki Naka")
				.city("Mumbai")
				.state("Maharashtra")
				.country("India")
				.pincode("400066")
				.build();
		
		Mockito.when(userService.addUser(Mockito.any(User.class))).thenReturn(user);
		
	MockHttpServletRequestBuilder mockReuest = MockMvcRequestBuilders.post("/users")
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON)
			.content(this.mapper.writeValueAsString(user));
	
	mockMvc.perform(mockReuest)
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", notNullValue()))
		.andExpect(jsonPath("$.name", is("John")));
	}
	
	@Test
	public void updateUserById() throws Exception{
		User updatedUser = User.builder()
				.id(1L)
				.name("John")
				.surname("Cena")
				.contact("9809809809")
				.gender(Gender.MALE)
				.dateOfBirth(new Date(1999-1-22))
				.joiningDate(new Date(2021-6-4))
				.address("Saki Naka")
				.city("Mumbai")
				.state("Maharashtra")
				.country("India")
				.pincode("400066")
				.build();
		
		Mockito.when(userService.findById(mockUser1.getId()))
		.thenReturn(Optional.of(mockUser1));
		
		Mockito.when(userService.updateUser(Mockito.any(User.class))).thenReturn(updatedUser);
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/user/1")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(updatedUser));
		
		mockMvc.perform(mockRequest)
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", notNullValue()))
			.andExpect(jsonPath("$.name", is("John")));
	}
	
	@Test
	public void updateUserById_nullId() throws Exception{
		User updatedUser = User.builder()
				.name("John")
				.surname("Cena")
				.contact("9809809809")
				.gender(Gender.MALE)
				.dateOfBirth(new Date(1999-1-22))
				.joiningDate(new Date(2021-6-4))
				.address("Saki Naka")
				.city("Mumbai")
				.state("Maharashtra")
				.country("India")
				.pincode("400066")
				.build();
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/user/1")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(updatedUser));
		
		mockMvc.perform(mockRequest)
			.andDo(print())
			.andExpect(status().isBadRequest())
			.andExpect(result -> 
					assertTrue(result.getResolvedException()
							instanceof InvalidRequestException))
			.andExpect(result -> 
					assertEquals("User or Id must not be null!", 
							result.getResolvedException().getMessage()));
	}
	
	@Test
	public void updateUserById_recordNotFound() throws Exception{
		User updatedUser = User.builder()
				.id(1L)
				.name("John")
				.surname("Cena")
				.contact("9809809809")
				.gender(Gender.MALE)
				.dateOfBirth(new Date(1999-1-22))
				.joiningDate(new Date(2021-6-4))
				.address("Saki Naka")
				.city("Mumbai")
				.state("Maharashtra")
				.country("India")
				.pincode("400066")
				.build();
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/user/1")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(updatedUser));
		
		mockMvc.perform(mockRequest)
		.andDo(print())
		.andExpect(status().isBadRequest())
		.andExpect(result -> 
				assertTrue(result.getResolvedException()
						instanceof InvalidRequestException))
		.andExpect(result -> 
				assertEquals("User with ID 1 does not exist.", 
						result.getResolvedException().getMessage()));
	}
	
	@Test
	public void deleteUserById() throws Exception{
		Mockito.when(userService.findById(mockUser1.getId()))
			.thenReturn(Optional.of(mockUser1));
		
		mockMvc.perform(MockMvcRequestBuilders
				.delete("/user/delete/1")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}
	
	@Test
	public void deletePatientById_notFound() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders
				.delete("/user/delete/5")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isBadRequest())
		.andExpect(result -> 
		assertTrue(result.getResolvedException()
				instanceof InvalidRequestException))
		.andExpect(result -> 
		assertEquals("User with ID 5 does not exist.", 
				result.getResolvedException().getMessage()));;
	}
	
	@Test
	public void softDeleteUserById() throws Exception{
		Mockito.when(userService.findById(mockUser1.getId()))
		.thenReturn(Optional.of(mockUser1));
	
	mockMvc.perform(MockMvcRequestBuilders
			.put("/user/softdelete/1")
			.contentType(MediaType.APPLICATION_JSON))
	.andExpect(status().isOk());
	}
	
	@Test
	public void softDeletePatientById_notFound() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders
				.put("/user/softdelete/5")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isBadRequest())
		.andExpect(result -> 
		assertTrue(result.getResolvedException()
				instanceof InvalidRequestException))
		.andExpect(result -> 
		assertEquals("User with ID 5 does not exist.", 
				result.getResolvedException().getMessage()));;
	}
}
