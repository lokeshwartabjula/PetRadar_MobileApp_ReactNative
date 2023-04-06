package com.Group1.PetRadar.DTO.user;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

import com.Group1.PetRadar.Model.Location;

public class updateUserDTO extends Location {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String Pincode;
    private Long mobileNumber;
    private MultipartFile file;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String oneSignalUserId;

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

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public String getOneSignalUserId() {
        return oneSignalUserId;
    }

    public void setOneSignalUserId(String oneSignalUserId) {
        this.oneSignalUserId = oneSignalUserId;
    }

}
