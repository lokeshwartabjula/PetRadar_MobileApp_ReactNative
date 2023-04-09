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

import com.Group1.PetRadar.DTO.medicalRecord.AddPetMedicalRecordDTO;
import com.Group1.PetRadar.Model.MedicalHistory;
import com.Group1.PetRadar.Service.MedicalRecordService;


@RunWith(MockitoJUnitRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
class MedicalRecordControllerTest {

	@InjectMocks
	MedicalRecordController medicalRecordController;
	
	@Mock
	MedicalRecordService medicalRecordServiceMock;
	
	@Test
	public void getMedicalByIdTest() throws Exception {
		UUID dummyUUID = new UUID(2l,3l);
		MedicalHistory dummyMedicalHistory = new MedicalHistory();
		
		when(medicalRecordServiceMock.getmedicalById(any(UUID.class))).thenReturn(dummyMedicalHistory);
		Assert.assertEquals(dummyMedicalHistory, medicalRecordController.getmedicalById(dummyUUID));
	}
	
	@Test
	public void updateMovieTest() {
		MedicalHistory dummyMedicalHistory = new MedicalHistory();
		
		when(medicalRecordServiceMock.updateMedical(any(MedicalHistory.class))).thenReturn(dummyMedicalHistory);
		Assert.assertEquals(dummyMedicalHistory,medicalRecordController.updateMovie(dummyMedicalHistory));
		
	}
	@Test
	public void saveMedicalTest() {
		MedicalHistory dummyMedicalHistory = new MedicalHistory();
		AddPetMedicalRecordDTO dummyAddPetMedicalRecordDTO = new AddPetMedicalRecordDTO();
		when(medicalRecordServiceMock.saveMedical(any(AddPetMedicalRecordDTO.class))).thenReturn(dummyMedicalHistory);
		Assert.assertEquals(dummyMedicalHistory, medicalRecordController.saveMedical(dummyAddPetMedicalRecordDTO));
	}

	@Test
	public void deleteMovieById() {
		UUID dummyUUID = new UUID(2l,3l);
		when(medicalRecordServiceMock.deleteMedicalById(any(UUID.class))).thenReturn("expectedString");

		Assert.assertEquals("expectedString", medicalRecordController.deleteMovieById(dummyUUID));
	}
	

}

