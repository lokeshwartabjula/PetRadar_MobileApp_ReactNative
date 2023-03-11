package com.Group1.PetRadar.Service;
import java.util.UUID;
import com.Group1.PetRadar.Model.User;

public interface UserService {
	// public UserModel registerUser(UserModel user) throws Exception;
	User saveUser(User user);

	String generateToken(String tokenSubject);

	// int getUserId(String userName);

	UUID getUserEmail(String email);
}
