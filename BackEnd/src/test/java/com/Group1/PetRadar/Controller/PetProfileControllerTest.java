package com.Group1.PetRadar.Controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.Group1.PetRadar.DTO.pet.AddPetDTO;
import com.Group1.PetRadar.Model.PetprofileModel;
import com.Group1.PetRadar.Service.PetProfileService;

@RunWith(MockitoJUnitRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
class PetProfileControllerTest {
	
	@InjectMocks
	PetprofileController petProfileController;
	
	@Mock
	PetProfileService petProfileServiceMock;
	

	@Test
	public void createPetprofilePositiveTest1() throws Exception {
		AddPetDTO dummyPetProfile = new AddPetDTO();
		Assert.assertEquals(202, petProfileController.createPetprofile(dummyPetProfile).getBody().getStatus());
	}
	
	@Test
	public void createPetprofileNegativeTest1() throws Exception {
		AddPetDTO dummyPetProfile = new AddPetDTO();
		when(petProfileServiceMock.savePetProfile(any(AddPetDTO.class))).thenThrow(new Exception());
		Assert.assertEquals(401, petProfileController.createPetprofile(dummyPetProfile).getBody().getStatus());
	}
	
	@Test
	public void getPetprofileIdTest() {
		PetprofileModel dummyPetprofileModel = new PetprofileModel();
		dummyPetprofileModel.setBio("dummyBio");
		UUID dummyUUID = new UUID(2l,3l);
		when(petProfileServiceMock.getPetprofileById(any(UUID.class))).thenReturn(dummyPetprofileModel);
		Assert.assertEquals(dummyPetprofileModel, petProfileController.getPetprofileId(dummyUUID));
	}
	

}
