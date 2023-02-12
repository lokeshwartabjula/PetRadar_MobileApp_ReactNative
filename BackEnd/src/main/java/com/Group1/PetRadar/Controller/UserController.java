package com.Group1.PetRadar.Controller;

import com.Group1.PetRadar.Model.UserModel;
import com.Group1.PetRadar.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public UserModel registerUser(@RequestBody UserModel user) throws Exception {

        return userService.registerUser(user);
    }
}
