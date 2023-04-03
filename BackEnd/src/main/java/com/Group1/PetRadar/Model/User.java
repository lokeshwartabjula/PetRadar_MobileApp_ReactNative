package com.Group1.PetRadar.Model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;

@Entity
@Transactional
@NoArgsConstructor
@Table(name = "user")
public class User {

	@Id()
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID userId;

	private String email;

	private String firstName;

	private String lastName;
	private String profileUrl;
	private String address;
	private String city;
	private String pincode;
	private Long phoneNumber;
	private String ImageUrl;
	@JsonIgnore
	private String password;

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private Set<PetprofileModel> pets = new HashSet<>();

	public UUID getUserId() {
		return userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
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
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<PetprofileModel> getPets() {
		return pets;
	}

	public void setPets(Set<PetprofileModel> pets) {
		this.pets = pets;
	}

	public String getImageUrl() {
		return ImageUrl;
	}

	public void setImageUrl(String imagexUrl) {
		ImageUrl = imagexUrl;
	}
}
