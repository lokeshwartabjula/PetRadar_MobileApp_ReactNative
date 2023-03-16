package com.Group1.PetRadar.Service.Implementation;

import com.Group1.PetRadar.DTO.auth.AuthReqDTO;
import com.Group1.PetRadar.DTO.user.RegisterUserDTO;
import com.Group1.PetRadar.DTO.user.updateUserDTO;
import com.Group1.PetRadar.Model.User;
import com.Group1.PetRadar.Repository.UserRepository;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.UUID;

import com.Group1.PetRadar.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    // @Override
    // public UserModel registerUser(UserModel user) throws Exception {
    // Integer registeredUser = 0;
    // registeredUser = jdbcTemplate.update("insert into IMDB.UserTable
    // values(1,?,?,?,?) ",new Object[]{
    // user.getUserName(),
    // user.getFirstName(),
    // user.getLastname(),
    // user.getUserEmail()
    // });
    //
    //
    // if(registeredUser==0)
    // throw new Exception("Error in inserting record");
    //
    // return user;
    // }

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtEncoder jwtEncoder;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(RegisterUserDTO registerUserDTO) {
        User newUser = new User();
        newUser.setEmail(registerUserDTO.getEmail());
        newUser.setPassword(passwordEncoder.encode(registerUserDTO.getPassword()));
        newUser.setFirstName(registerUserDTO.getFirstname());
        newUser.setLastName(registerUserDTO.getLastname());
        newUser.setProfileUrl(registerUserDTO.getProfileurl());
        return userRepository.save(newUser);
    }

    @Override
    public User saveUser(User user) {
        User UserEncode = new User();
        UserEncode.setEmail(user.getEmail());
        UserEncode.setPassword(passwordEncoder.encode(user.getPassword()));
        UserEncode.setFirstName(user.getFirstName());
        UserEncode.setLastName(user.getFirstName());
        UserEncode.setProfileUrl(user.getProfileUrl());
        return userRepository.save(UserEncode);
    }

    @Override
    public String generateToken(String tokenSubject) {
        Instant now = Instant.now();
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("PetRadar")
                .issuedAt(now)
                .expiresAt(now.plus(1, ChronoUnit.HOURS))
                .subject(tokenSubject)
                .build();
        JwsHeader jwsHeader = JwsHeader.with(() -> "HS256").build();
        return this.jwtEncoder.encode(JwtEncoderParameters.from(jwsHeader, claims)).getTokenValue();
    }

    @Override
    public User getUserEmail(String email) {
        return userRepository.findByEmail(email).get();
    }

    public User updateUser(updateUserDTO userDetails, String userId) {
        System.out.println(userId);
        User user = userRepository.findById(UUID.fromString(userId)).get();
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setAddress(userDetails.getAddress());
        user.setCity(userDetails.getCity());
        user.setPincode(userDetails.getPincode());
        user.setPhoneNumber(userDetails.getMobileNumber());
        userRepository.save(user);
        return user;
    }

    @Override
    public Boolean googleLogin(User user) throws Exception {
        // TODO Auto-generated method stub
        Boolean isUserFound = false;
        Boolean isGoogleUser = false;

        // check if user is in the db
        String ifUserExistsQuery = "select * from user_model where email = :email";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("email", user.getEmail());
        User foundUser = new User();
        try {
            foundUser = (User) namedParameterJdbcTemplate.queryForObject(ifUserExistsQuery, map,
                    new BeanPropertyRowMapper(User.class));
        } catch (EmptyResultDataAccessException e) {
            isUserFound = false;
        }
        if (foundUser.getUserId().toString().length() > 0)
            isUserFound = true;

        // check if password is dummy
        String dummyPassword = passwordEncoder.encode("dummy");
        if (foundUser.getProfileUrl() != null)
            isGoogleUser = true;
        // If user is not in the db save user
        if (!isUserFound) {
            // save user
            user.setPassword("dummy");
            saveUser(user);
            return true;
        } else {
            if (isGoogleUser) // if user has the password as dummy return token
                return true;
            else // else if user doesnt have the password as dummy, return exception stating that
                 // the user should login through app
                throw new Exception("Please login through app as you have already registered as a google user");
        }

        // //add encrypted password inside user object
        // return true;
    }

    @Override
    public Boolean appLogin(AuthReqDTO authReqDTO) throws Exception {

        Boolean isUserFound = false;
        Boolean isGoogleUser = false;

        String ifUserExistsQuery = "select * from user where email = :email";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("email", authReqDTO.getEmail());
        User foundUser = new User();
        try {
            foundUser = (User) namedParameterJdbcTemplate.queryForObject(ifUserExistsQuery, map,
                    new BeanPropertyRowMapper(User.class));
        } catch (EmptyResultDataAccessException e) {
            isUserFound = false;
        }

        if (foundUser.getUserId() != null && foundUser.getUserId().toString().length() > 0)
            isUserFound = true;

        if (foundUser.getProfileUrl() != null)
            isGoogleUser = true;

        if (isGoogleUser) {
            throw new Exception("Please login through google as you have already registered through app");
        } else {
            if (passwordEncoder.matches(authReqDTO.getPassword(), foundUser.getPassword()))
                return true;
            else
                throw new Exception("Incorrect Password. Please try again");
        }

        // insert into user_model (email, first_name, last_name, password, profile_url,
        // user_id) values (?, ?, ?, ?, ?, ?)
        // with the given email, check if user exists
        // check if user is a google user
        // if user is a google user, then ask user to login through app
        // else
        // check password
        // else throw an exception that wrong password

        // TODO Auto-generated method stub
    }

    @Override
    public Boolean registerAppUser(AuthReqDTO authReqDTO) throws Exception {
        // TODO Auto-generated method stub
        // insert into user_model (email, first_name, last_name, password, profile_url,
        // user_id) values (?, ?, ?, ?, ?, ?)

        Boolean isGoogleUser = false;
        Boolean isUserFound = false;

        String ifUserExistsQuery = "select * from user where email = :email";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("email", authReqDTO.getEmail());
        User foundUser = new User();
        try {
            foundUser = (User) namedParameterJdbcTemplate.queryForObject(ifUserExistsQuery, map,
                    new BeanPropertyRowMapper(User.class));
        } catch (EmptyResultDataAccessException e) {
            isUserFound = false;
        }

        if (foundUser.getUserId() != null && foundUser.getUserId().toString().length() > 0)
            isUserFound = true;

        if (foundUser.getProfileUrl() != null)
            isGoogleUser = true;

        if (isGoogleUser)
            throw new Exception("You have registered already as a google user, please login through google");

        if (isUserFound == true && isGoogleUser == false)
            throw new Exception("You have registered already in our application. Please proceed to login");

        User newUser = new User();
        newUser.setEmail(authReqDTO.getEmail());
        newUser.setPassword(authReqDTO.getPassword());

        if (!isUserFound) {
            saveUser(newUser);
            return true;
        } else {
            return false;
        }

    }

    public User findById(String id) throws Exception {
        try {
            User user = null;
            if (!userRepository.existsById(UUID.fromString(id))) {
                throw new Exception("User not found");
            }
            user = userRepository.findById(UUID.fromString(id)).get();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Unable to fetch the user Details");
        }
    }
}
