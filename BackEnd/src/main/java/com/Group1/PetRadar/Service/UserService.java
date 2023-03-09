package com.Group1.PetRadar.Service;

import org.springframework.security.core.Authentication;

import com.Group1.PetRadar.DTO.AuthReqDTO;
import com.Group1.PetRadar.Model.UserModel;

public interface UserService {
//    public UserModel registerUser(UserModel user) throws Exception;
	UserModel saveUser(UserModel user);

    String generateToken(String tokenSubject);

//    int getUserId(String userName);

	int getUserEmail(String email);

	Boolean googleLogin(UserModel user) throws Exception;

	Boolean appLogin(AuthReqDTO authReqDTO) throws Exception;

	Boolean registerAppUser(AuthReqDTO authReqDTO) throws Exception;
}
