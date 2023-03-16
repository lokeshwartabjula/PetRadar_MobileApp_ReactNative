package com.Group1.PetRadar.Service;
import java.util.Map;
import java.util.UUID;

import com.Group1.PetRadar.DTO.user.*;
import com.Group1.PetRadar.Model.User;

public interface UserService {
	// public UserModel registerUser(UserModel user) throws Exception;
	User saveUser(RegisterUserDTO user);

	String generateToken(String tokenSubject);

	// int getUserId(String userName);

	User updateUser(updateUserDTO userDetails, String userId);

	UUID getUserEmail(String email);
}
