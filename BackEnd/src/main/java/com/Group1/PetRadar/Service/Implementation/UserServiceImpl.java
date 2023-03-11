package com.Group1.PetRadar.Service.Implementation;

import com.Group1.PetRadar.Model.User;
import com.Group1.PetRadar.Repository.UserRepository;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
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
    public User saveUser(User user) {
        User UserEncode = new User(user.getEmail(), user.getFirstName(), user.getLastName(), user.getProfileUrl(),
                passwordEncoder.encode(user.getPassword()));
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
    public UUID getUserEmail(String email) {
        return userRepository.findByEmail(email).get().getUserId();
    }

}
