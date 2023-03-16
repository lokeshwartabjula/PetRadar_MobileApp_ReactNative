package com.Group1.PetRadar.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Group1.PetRadar.DTO.AuthReqDTO;
import com.Group1.PetRadar.DTO.RegisterUserDTO;
import com.Group1.PetRadar.Model.User;
import com.Group1.PetRadar.Service.UserService;
import com.Group1.PetRadar.protocol.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;

	// For Testing only
	@GetMapping("/message")
	public String home() {
		return "Never give up!!";
	}

	@PostMapping("/googleLogin")
	public ResponseEntity<Response> googleRegisterLogin(@RequestBody User user) {
		String token = userService.generateToken(user.getEmail());
		Response response = new Response(token, HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name());
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
	}

	@PostMapping("/register")
	public ResponseEntity<Response> saveUser(@RequestBody RegisterUserDTO registerUserDTO) {
		User newUser = new User(
				registerUserDTO.getEmail(),
				registerUserDTO.getFirstname(),
				registerUserDTO.getLastname(),
				registerUserDTO.getProfileurl(),
				registerUserDTO.getPassword());
		newUser = userService.saveUser(newUser);
		String token = userService.generateToken(newUser.getUserId().toString());
		Response response = new Response();
		Map<String,String> data = new HashMap<>();
		data.put("token",token);
		data.put("userId",newUser.getUserId().toString());

		response.setData(data);
		response.setMessage(HttpStatus.ACCEPTED.name());
		response.setStatus(HttpStatus.ACCEPTED.value());
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
	}

	@PostMapping("/login")
	public ResponseEntity<Response> login(@RequestBody AuthReqDTO authReqDTO) {

		UUID userId = userService.getUserEmail(authReqDTO.getEmail());
		String token = userService.generateToken(userId.toString());
		Response response = new Response();
		Map<String,String> data = new HashMap<>();
		data.put("token",token);
		data.put("userId",userId.toString());

		response.setData(data);
		response.setMessage(HttpStatus.ACCEPTED.name());
		response.setStatus(HttpStatus.ACCEPTED.value());
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
	}
}
