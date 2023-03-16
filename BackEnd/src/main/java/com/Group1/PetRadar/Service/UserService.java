package com.Group1.PetRadar.Service;

import java.io.IOException;
import java.util.UUID;

import com.Group1.PetRadar.DTO.auth.AuthReqDTO;
import com.Group1.PetRadar.DTO.user.*;
import com.Group1.PetRadar.Model.User;

public interface UserService {
	// public UserModel registerUser(UserModel user) throws Exception;
	User saveUser(RegisterUserDTO user);

	User saveUser(User user);

	String generateToken(String tokenSubject);

	// int getUserId(String userName);

	User updateUser(updateUserDTO userDetails, String userId) throws IOException;

	User getUserEmail(String email);

	Boolean googleLogin(User user) throws Exception;

	Boolean appLogin(AuthReqDTO authReqDTO) throws Exception;

	Boolean registerAppUser(AuthReqDTO authReqDTO) throws Exception;
}
