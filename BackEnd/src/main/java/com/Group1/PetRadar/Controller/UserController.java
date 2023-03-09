package com.Group1.PetRadar.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import com.Group1.PetRadar.DTO.AuthReqDTO;
//import com.Group1.PetRadar.DTO.AuthRespDTO;
//import com.Group1.PetRadar.Model.UserModel;
//import com.Group1.PetRadar.Service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Group1.PetRadar.DTO.AuthReqDTO;
import com.Group1.PetRadar.DTO.JwtRequest;
import com.Group1.PetRadar.Model.UserModel;
import com.Group1.PetRadar.Service.UserService;
import com.Group1.PetRadar.protocol.Response;


@RestController
@RequestMapping("/user")
public class UserController {

//    @Autowired
//    UserService userService;
//
//    @PostMapping("/register")
//    public UserModel registerUser(@RequestBody UserModel user) throws Exception {
//
//        return userService.registerUser(user);
//    }
//    
//    @PostMapping("/login")
//    public AuthRespDTO loginUser(@RequestBody AuthReqDTO authDto) {
//    	
//    	
//		return null;
//    	
//    }
//    
//    @PostMapping({ "/hello" })
//    public String sampleMethod() {
//    return "Hello World";
//    }
	
	 @Autowired
	    UserService userService;

	    //For Testing only
	    @GetMapping("/message")
	    public String home() {
	        return "Never give up!!";
	    }
	    
	    @PostMapping("/googleLogin")
	    public ResponseEntity<Response> googleRegisterLogin(@RequestBody UserModel user) throws Exception {
	    	Boolean isLoginSuccessful = false;
	    	Response failureResponse = null;
	    	
	    	try {
				isLoginSuccessful = userService.googleLogin(user);
	    	} catch (Exception e) {
				// TODO Auto-generated catch block
				failureResponse = new Response(e.getMessage(),HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.name());
		        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(failureResponse);
			}

	    	String token = null;
	    	if(isLoginSuccessful)
	    		token = userService.generateToken(user.getEmail());
	    	else
	    		throw new Exception("Login is not successful");
	    	
	    	
	        Response response = new Response(token,HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name());
	        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
	    }
	    
	    

	    @PostMapping("/register")
	    public ResponseEntity<Response> saveUser(@RequestBody AuthReqDTO authReqDTO) throws Exception {
	    	
	    	Boolean saveAppUserSuccessful = false;
	    	Response failureResponse = null;
	    	
	    	try {
				saveAppUserSuccessful = userService.registerAppUser(authReqDTO);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				failureResponse = new Response(e.getMessage(),HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.name());
		        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(failureResponse);
			}
	    	
	    	String token =null;
	    	if(saveAppUserSuccessful)
	    	token = userService.generateToken(authReqDTO.getEmail());
	    	else
	    		throw new Exception("Registration not successful. Please try again");

	        Response response = new Response(token,HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name());
	        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
	    }

	    @PostMapping("/login")
	    public ResponseEntity<Response> login(@RequestBody AuthReqDTO authReqDTO) throws Exception {
//	    	System.out.print(payload.toString());
	    	// TODO: Check with database and fetch user details
	    	// TODO: pass that user object to generateToken method and get the token
	    	
	    	Boolean isAppLoginSuccessful = false;
	    	Response failureResponse = null;

	    	
	    	try {
				isAppLoginSuccessful = userService.appLogin(authReqDTO);
	    	} catch (Exception e) {
				// TODO Auto-generated catch block
				failureResponse = new Response(e.getMessage(),HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.name());
		        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(failureResponse);
			}
	    	String token = null;
	    	if(isAppLoginSuccessful)
	    	 token = userService.generateToken(authReqDTO.getEmail());
	    	else
	    		throw new Exception("Login is not successful. Please try again!");
	    	
	        Response response = new Response(token,HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name());
	        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
	    }
	    
//	    @GetMapping("/login")
//	    public ResponseEntity<Response> token(Authentication authentication) {
//	        Response response = new Response(userService.generateToken(authentication),HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name());
//	        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
//	    }


//	    @GetMapping("/me/{userName}")
//	    public ResponseEntity<Response> me(@PathVariable("userName") String userName) {
//	        Response response = new Response(userService.getUserId(userName),HttpStatus.OK.value(), HttpStatus.OK.name());
//	        return ResponseEntity.status(HttpStatus.OK).body(response);
//	    }
	
}
