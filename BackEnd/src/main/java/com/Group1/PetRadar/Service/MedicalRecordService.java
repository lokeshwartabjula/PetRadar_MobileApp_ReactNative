package com.Group1.PetRadar.Service;

import java.util.UUID;

import com.Group1.PetRadar.DTO.AddPetMedicalRecordDTO;
import com.Group1.PetRadar.Model.MedicalHistory;

public interface MedicalRecordService {

    MedicalHistory saveMedical(AddPetMedicalRecordDTO medical);

    MedicalHistory getmedicalById(UUID id);

    MedicalHistory updateMedical(MedicalHistory medical);

    String deleteMedicalById(UUID id);

}
