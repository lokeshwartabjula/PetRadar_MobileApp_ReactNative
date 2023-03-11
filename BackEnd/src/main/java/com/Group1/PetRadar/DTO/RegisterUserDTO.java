package com.Group1.PetRadar.DTO;

public class RegisterUserDTO {
    // {
    // "email":"user3@email.com",
    // "firstname" : "user3first",
    // "lastname" : "user3last",
    // "profileurl" : "https://picsum.photos/200",
    // "password": "demo"
    // }
    private String email;
    private String firstname;
    private String lastname;
    private String profileurl;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getProfileurl() {
        return this.profileurl;
    }

    public void setProfileurl(String profileurl) {
        this.profileurl = profileurl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
