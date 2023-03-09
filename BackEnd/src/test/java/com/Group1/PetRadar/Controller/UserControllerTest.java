package com.Group1.PetRadar.Controller;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.Group1.PetRadar.Service.UserService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = UserController.class)
public class UserControllerTest {
	
	@InjectMocks
	UserController mockUserController;
	
	@Mock
	UserService userService;

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
//	@Test
//	public void registerUserTest() throws Exception {
//		//GIVEN
//		UserModel dummyUser = new UserModel();
//		dummyUser.setFirstName("firstName");
//		dummyUser.setLastname("lastName");
//		dummyUser.setUserEmail("email@email.com");
//		dummyUser.setUserName("userName");
//		
//		when(userService.registerUser(any(UserModel.class))).thenReturn(dummyUser);
//		mockUserController.registerUser(dummyUser);
//		
//	}

}
