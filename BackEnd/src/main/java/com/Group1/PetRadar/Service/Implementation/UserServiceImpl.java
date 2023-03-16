package com.Group1.PetRadar.Service.Implementation;

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
import org.springframework.jdbc.core.JdbcTemplate;
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
    public UUID getUserEmail(String email) {
        return userRepository.findByEmail(email).get().getUserId();
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

}
