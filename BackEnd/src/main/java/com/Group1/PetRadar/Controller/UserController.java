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

@RestController
@RequestMapping("/user")
public class UserController {

	// @Autowired
	// UserService userService;
	//
	// @PostMapping("/register")
	// public UserModel registerUser(@RequestBody UserModel user) throws Exception {
	//
	// return userService.registerUser(user);
	// }
	//
	// @PostMapping("/login")
	// public AuthRespDTO loginUser(@RequestBody AuthReqDTO authDto) {
	//
	//
	// return null;
	//
	// }
	//
	// @PostMapping({ "/hello" })
	// public String sampleMethod() {
	// return "Hello World";
	// }

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

		String token = userService.generateToken(registerUserDTO.getEmail());
		User newUser = new User(
				registerUserDTO.getEmail(),
				registerUserDTO.getFirstname(),
				registerUserDTO.getLastname(),
				registerUserDTO.getProfileurl(),
				registerUserDTO.getPassword());
		userService.saveUser(newUser);
		Response response = new Response(token, HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name());
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
	}

	@PostMapping("/login")
	public ResponseEntity<Response> login(@RequestBody AuthReqDTO authReqDTO) {
		// System.out.print(payload.toString());
		// TODO: Check with database and fetch user details
		// TODO: pass that user object to generateToken method and get the token
		String token = userService.generateToken(authReqDTO.getEmail());

		Response response = new Response(token, HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name());
		System.out.println(userService.getUserEmail("user3@email.com"));
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
	}

	// @GetMapping("/login")
	// public ResponseEntity<Response> token(Authentication authentication) {
	// Response response = new
	// Response(userService.generateToken(authentication),HttpStatus.ACCEPTED.value(),
	// HttpStatus.ACCEPTED.name());
	// return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
	// }

	// @GetMapping("/me/{userName}")
	// public ResponseEntity<Response> me(@PathVariable("userName") String userName)
	// {
	// Response response = new
	// Response(userService.getUserId(userName),HttpStatus.OK.value(),
	// HttpStatus.OK.name());
	// return ResponseEntity.status(HttpStatus.OK).body(response);
	// }

}
