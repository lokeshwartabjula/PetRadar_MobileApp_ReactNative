package com.Group1.PetRadar.Service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.Group1.PetRadar.DTO.user.RegisterUserDTO;
import com.Group1.PetRadar.DTO.user.updateUserDTO;
import com.Group1.PetRadar.Model.User;
import com.Group1.PetRadar.Repository.UserRepository;
import com.Group1.PetRadar.Service.Implementation.UserServiceImpl;

public class UserServiceImplTest {
    @Mock
    PasswordEncoder passwordEncoderMock;

    @Mock
    UserRepository userRepoMock;

    @InjectMocks
    UserServiceImpl userServiceImpl;

    @Test
    public void saveUserTestPositive1() {
        User dummyUser = new User();
        dummyUser.setCity("dummyCity");
        RegisterUserDTO dummyRegisterUserDTO = new RegisterUserDTO();
        dummyRegisterUserDTO.setPassword("dummyPWD");
        when(passwordEncoderMock.encode(any(CharSequence.class))).thenReturn("dummypwdString");

        when(userRepoMock.save(any(User.class))).thenReturn(dummyUser);
        Assert.assertEquals(dummyUser, userServiceImpl.saveUser(dummyRegisterUserDTO));

    }

    @Test
    public void saveGoogleUserTest() {
        User dummyUser = new User();
        when(userRepoMock.save(any(User.class))).thenReturn(dummyUser);
        Assert.assertEquals(dummyUser, userServiceImpl.saveGoogleUser(dummyUser));
    }

    @Test
    public void saveUserTest() {
        User dummyUser = new User();
        dummyUser.setPassword("dummyPass");
        when(passwordEncoderMock.encode(any(CharSequence.class))).thenReturn("dummypwdString");

        when(userRepoMock.save(any(User.class))).thenReturn(dummyUser);
        Assert.assertEquals(dummyUser, userServiceImpl.saveUser(dummyUser));

    }

    @Test
    public void getUserEmailTest() {
        User dummyUser = new User();
        Optional<User> dummyOption = Optional.of(dummyUser);
        when(userRepoMock.findByEmail(anyString())).thenReturn(dummyOption);
        Assert.assertEquals(dummyUser, userServiceImpl.getUserEmail("email"));
    }

    @Test
    public void updateUserTest() throws Exception {
        User dummyUser = new User();
        Optional<User> dummyOption = Optional.of(dummyUser);
        dummyOption.get();

        when(userRepoMock.findById(any())).thenReturn(dummyOption);

        updateUserDTO dummyUpdateUserDto = new updateUserDTO();
        Assert.assertEquals(dummyUser,
                userServiceImpl.updateUser(dummyUpdateUserDto, "0f14d0ab-9605-4a62-a9e4-5ed26688389b"));

    }

    @Test
    public void updateUserTestNegative() throws Exception {
        User dummyUser = new User();
        Optional<User> dummyOption = Optional.of(dummyUser);
        dummyOption.get();

        when(userRepoMock.findById(any())).thenReturn(dummyOption);

        updateUserDTO dummyUpdateUserDto = new updateUserDTO();
        Assertions.assertThrows(Exception.class, () -> {
            userServiceImpl.updateUser(dummyUpdateUserDto, "345");
        });

    }

}
