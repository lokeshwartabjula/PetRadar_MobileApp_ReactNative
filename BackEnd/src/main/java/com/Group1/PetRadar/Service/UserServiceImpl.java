package com.Group1.PetRadar.Service;

import com.Group1.PetRadar.DTO.AuthReqDTO;
import com.Group1.PetRadar.Model.UserModel;
import com.Group1.PetRadar.Repository.UserRepository;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
//    @Override
//    public UserModel registerUser(UserModel user) throws Exception {
//        Integer registeredUser = 0;
//        registeredUser = jdbcTemplate.update("insert into IMDB.UserTable values(1,?,?,?,?) ",new Object[]{
//                user.getUserName(),
//                user.getFirstName(),
//                user.getLastname(),
//                user.getUserEmail()
//        });
//        
//
//        if(registeredUser==0)
//            throw new Exception("Error in inserting record");
//
//        return user;
//    }


    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtEncoder jwtEncoder;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserModel saveUser(UserModel user) {
        UserModel UserEncode = new UserModel(0,user.getEmail(), user.getFirstName(),user.getLastName(),user.getProfileUrl(), passwordEncoder.encode(user.getPassword()));
        return userRepository.save(UserEncode);
    }

    @Override
    public String generateToken(String tokenSubject) {
        Instant now = Instant.now();
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("PetRadar")
                .issuedAt(now)
                .expiresAt(now.plus(180, ChronoUnit.DAYS))
                .subject(tokenSubject)
                .build();
        JwsHeader jwsHeader = JwsHeader.with(() -> "HS256").build();
        return this.jwtEncoder.encode( JwtEncoderParameters.from(jwsHeader,claims)).getTokenValue();
    }

    @Override
    public int getUserEmail(String email) {
        return userRepository.findByEmail(email).get().getUserId();
    }

	@Override
	public Boolean googleLogin(UserModel user) throws Exception {
		// TODO Auto-generated method stub
		Boolean isUserFound = false;
		Boolean isGoogleUser = false;
		
		//check if user is in the db
		String ifUserExistsQuery = "select * from user_model where email = :email";
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("email", user.getEmail());
		UserModel foundUser = new UserModel();
		try {
		 foundUser = (UserModel) namedParameterJdbcTemplate.queryForObject(ifUserExistsQuery, map, new BeanPropertyRowMapper(UserModel.class) );
		}catch(EmptyResultDataAccessException e) {
			isUserFound = false;
		}
		if(foundUser.getUserId()>0)
			isUserFound = true;
		
    	//check if password is dummy
		String dummyPassword = passwordEncoder.encode("dummy");
		if( foundUser.getProfileUrl()!=null)
			isGoogleUser = true;
    	//If user is not in the db save user
		if(!isUserFound) {
    		//save user
			user.setPassword("dummy");
			saveUser(user);
			return true;
		}else {
			if(isGoogleUser)    			//if user has the password as dummy return token
				return true;
			else     			// else if user doesnt have the password as dummy, return exception stating that the user should login through app
				throw new Exception("Please login through app as you have already registered as a google user");
		}
    	
//    	//add encrypted password inside user object
//		return true;
	}

	@Override
	public Boolean appLogin(AuthReqDTO authReqDTO) throws Exception {
		
		Boolean isUserFound = false;
		Boolean isGoogleUser = false;
		
		String ifUserExistsQuery = "select * from user_model where email = :email";
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("email", authReqDTO.getEmail());
		UserModel foundUser = new UserModel();
		try {
		 foundUser = (UserModel) namedParameterJdbcTemplate.queryForObject(ifUserExistsQuery, map, new BeanPropertyRowMapper(UserModel.class) );
		}catch(EmptyResultDataAccessException e) {
			isUserFound = false;
		}
		
		if(foundUser.getUserId()>0)
			isUserFound = true;
		
		if(foundUser.getProfileUrl()!=null)
			isGoogleUser = true;
		
		if(isGoogleUser) {
			throw new Exception("Please login through google as you have already registered through app");
		}else {
			if(foundUser.getPassword().equalsIgnoreCase(passwordEncoder.encode(authReqDTO.getPassword())))
				return true;
			else
				throw new Exception("Incorrect Password. Please try again");
		}
		
		//insert into user_model (email, first_name, last_name, password, profile_url, user_id) values (?, ?, ?, ?, ?, ?)
		//with the given email, check if user exists
		// check if user is a google user
			//if user is a google user, then ask user to login through app
			//else 
			// check password 
			// else throw an exception that wrong password
		
		// TODO Auto-generated method stub
	}

	@Override
	public Boolean registerAppUser(AuthReqDTO authReqDTO) throws Exception {
		// TODO Auto-generated method stub
		//insert into user_model (email, first_name, last_name, password, profile_url, user_id) values (?, ?, ?, ?, ?, ?)

		Boolean isGoogleUser = false;
		Boolean isUserFound = false;

		String ifUserExistsQuery = "select * from user_model where email = :email";
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("email", authReqDTO.getEmail());
		UserModel foundUser = new UserModel();
		try {
		 foundUser = (UserModel) namedParameterJdbcTemplate.queryForObject(ifUserExistsQuery, map, new BeanPropertyRowMapper(UserModel.class) );
		}catch(EmptyResultDataAccessException e) {
			isUserFound = false;
		}
		
		if(foundUser.getUserId()!=0 && foundUser.getUserId()>0)
			isUserFound = true;
		
		if( foundUser.getProfileUrl()!=null)
			isGoogleUser = true;
		
		if(isGoogleUser)
			throw new Exception("You have registered already as a google user, please login through google");
		
		if(isUserFound==true && isGoogleUser==false)
			throw new Exception("You have registered already in our application. Please proceed to login");
		
		UserModel newUser = new UserModel();
		newUser.setEmail(authReqDTO.getEmail());
		newUser.setPassword(authReqDTO.getPassword());
		
		if(!isUserFound) {
			saveUser(newUser);
			return true;
		}else {
			return false;
		}	
		
	}

	
}
