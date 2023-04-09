package com.Group1.PetRadar.Controller;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Assertions;


import org.junit.Test;
import org.junit.Assert;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;


import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import com.Group1.PetRadar.Service.UserService;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import com.Group1.PetRadar.DTO.user.updateUserDTO;
import com.Group1.PetRadar.Model.User;
import com.Group1.PetRadar.DTO.auth.AuthReqDTO;
import org.springframework.web.multipart.MultipartFile;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = UserController.class)
public class UserControllerTest {

	@InjectMocks
	UserController mockUserController;

	@Mock
	UserService userServiceMock;

	@Test
	public void homeTest() {
		Assert.assertEquals("Home Controller!!", mockUserController.home());
	}
	@Test
	public void getUserByIdPositiveTestcase1() {
		Assert.assertEquals(202, mockUserController.getUserById("34").getBody().getStatus());
	}
	@Test
	public void getUserByIdNegativeTestcase1() throws Exception {
		when(userServiceMock.findById(anyString())).thenThrow(new Exception());
		Assert.assertEquals(401, mockUserController.getUserById("34").getBody().getStatus());
		
	}

	//Test cases for user  register,login & save

	@Test
	public void googleRegisterLoginNewUserPositive1() throws Exception {
		User dummyUser = new User();
		//returning true assuming its a valid new user
		when(userServiceMock.googleLogin(any(User.class), anyBoolean())).thenReturn(true);
		Assert.assertEquals(202, mockUserController.googleRegisterLogin(dummyUser, true).getBody().getStatus());
	}
	
	@Test
	public void googleRegisterLoginRegisterErrorNeg1() throws Exception {
		User dummyUser = new User();
		//throwing an exception assuming an error in googleLogin function
		when(userServiceMock.googleLogin(any(User.class), anyBoolean())).thenThrow(new Exception());
		Assert.assertEquals(401, mockUserController.googleRegisterLogin(dummyUser, true).getBody().getStatus());
	}

	@Test
	public void googleRegisterLoginUnsuccessfulLoginNeg2() throws Exception {
		User dummyUser = new User();
		//returning false assuming its an invalid user
		when(userServiceMock.googleLogin(any(User.class), anyBoolean())).thenReturn(false);
		Assertions.assertThrows(Exception.class, () -> {mockUserController.googleRegisterLogin(dummyUser, true).getBody().getStatus();});
	}

	@Test
	public void saveUserPositiveCase1() throws Exception {
		AuthReqDTO dummyAuthReqDTO = new AuthReqDTO();
		when(userServiceMock.registerAppUser(any(AuthReqDTO.class))).thenReturn(true);
		Assert.assertEquals(202, mockUserController.saveUser(dummyAuthReqDTO).getBody().getStatus());
	}


	@Test
	public void saveUserNegativeCase1() throws Exception {
		AuthReqDTO dummyAuthReqDTO = new AuthReqDTO();
		when(userServiceMock.registerAppUser(any(AuthReqDTO.class))).thenReturn(false);
		Assertions.assertThrows(Exception.class,() -> { mockUserController.saveUser(dummyAuthReqDTO).getBody().getStatus();});
	}
	
	@Test
	public void saveUserNegativeCase2() throws Exception {
		AuthReqDTO dummyAuthReqDTO = new AuthReqDTO();
		when(userServiceMock.registerAppUser(any(AuthReqDTO.class))).thenThrow(new Exception());
		Assert.assertEquals(401, mockUserController.saveUser(dummyAuthReqDTO).getBody().getStatus());
	}
	
	@Test
	public void loginPositive1() throws Exception {
		AuthReqDTO dummyAuthReqDTO = new AuthReqDTO();
		when(userServiceMock.appLogin(any(AuthReqDTO.class))).thenReturn(true);
		Assert.assertEquals(202, mockUserController.login(dummyAuthReqDTO).getBody().getStatus());
	
	}
	
	@Test
	public void loginNegative1() throws Exception {
		AuthReqDTO dummyAuthReqDTO = new AuthReqDTO();
		when(userServiceMock.appLogin(any(AuthReqDTO.class))).thenReturn(false);
		Assertions.assertThrows(Exception.class,() -> { mockUserController.login(dummyAuthReqDTO).getBody().getStatus();});
	
	}
	
	@Test
	public void loginNegative2() throws Exception {
		AuthReqDTO dummyAuthReqDTO = new AuthReqDTO();
		when(userServiceMock.appLogin(any(AuthReqDTO.class))).thenThrow(new Exception());
		Assert.assertEquals(401, mockUserController.login(dummyAuthReqDTO).getBody().getStatus());
	
	}
	
	//Test cases for updating the user

    @Mock
	MultipartFile multipartFileMock;
	
	@Test
	public void updateTestPositive1() {
		when(multipartFileMock.getOriginalFilename()).thenReturn("dummyFileName");
		Assert.assertEquals(202, mockUserController.update("dummyFirstName", "dummyLastName", "dummyAddress", "dummyCity", "dummyPin", "8870121270", "dummyUserId", multipartFileMock, "string", "string", "string").getBody().getStatus());
	}
	
	@Test
	public void updateTestNegative1() throws Exception {
		when(multipartFileMock.getOriginalFilename()).thenReturn("dummyFileName");
		when(userServiceMock.updateUser(any(updateUserDTO.class), anyString())).thenThrow(new Exception());
		Assert.assertEquals(401, mockUserController.update("dummyFirstName", "dummyLastName", "dummyAddress", "dummyCity", "dummyPin", "8870121270", "dummyUserId", multipartFileMock, "string", "string", "string").getBody().getStatus());
	}

//Test cases for deleting the user by id

@Test
	public void deleteUserByIdPositiveTest1() {
		Assert.assertEquals(202, mockUserController.deleteUserById("34").getBody().getStatus());
	}
	
	@Test
	public void deleteUserByIdNegativeTest1() throws Exception {
		when(userServiceMock.deleteUserById(anyString())).thenThrow(new Exception());
		Assert.assertEquals(401, mockUserController.deleteUserById("34").getBody().getStatus());
	}

}
