package com.Group1.PetRadar.DTO.user;

import org.springframework.web.multipart.MultipartFile;

public class updateUserDTO {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String Pincode;
    private Long mobileNumber;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return Pincode;
    }

    public void setPincode(String pincode) {
        Pincode = pincode;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setPhoneNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

}
