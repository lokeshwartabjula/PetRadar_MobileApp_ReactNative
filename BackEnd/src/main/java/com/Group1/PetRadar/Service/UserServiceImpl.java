package com.Group1.PetRadar.Service;

import com.Group1.PetRadar.Model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public UserModel registerUser(UserModel user) throws Exception {
        Integer registeredUser = 0;
        registeredUser = jdbcTemplate.update("insert into IMDB.UserTable values(1,?,?,?,?) ",new Object[]{
                user.getUserName(),
                user.getFirstName(),
                user.getLastname(),
                user.getUserEmail()
        });
        

        if(registeredUser==0)
            throw new Exception("Error in inserting record");

        return user;
    }


}
