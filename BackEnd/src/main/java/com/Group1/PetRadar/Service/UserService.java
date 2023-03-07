package com.Group1.PetRadar.Service;

import org.springframework.security.core.Authentication;

import com.Group1.PetRadar.DTO.AuthReqDTO;
import com.Group1.PetRadar.Model.User;
import com.Group1.PetRadar.Model.UserModel;

public interface UserService {
//    public UserModel registerUser(UserModel user) throws Exception;
	User saveUser(User user);

    String generateToken(String tokenSubject);

//    int getUserId(String userName);

	int getUserEmail(String email);
}
