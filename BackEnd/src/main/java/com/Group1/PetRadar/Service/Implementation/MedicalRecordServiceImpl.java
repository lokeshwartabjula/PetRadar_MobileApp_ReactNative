package com.Group1.PetRadar.Service.Implementation;

import com.Group1.PetRadar.DTO.AddPetMedicalRecordDTO;
import com.Group1.PetRadar.Model.MedicalHistory;
import com.Group1.PetRadar.Repository.MedicalRecordRepository;
import com.Group1.PetRadar.Service.MedicalRecordService;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {

    @Autowired
    MedicalRecordRepository medicalRecordRepository;

    @Override
    public MedicalHistory saveMedical(AddPetMedicalRecordDTO medicalrecord) {

        MedicalHistory newRecord = new MedicalHistory();
        newRecord.setVetVisitDate(medicalrecord.getVetVisitDate());
        newRecord.setSymptoms(medicalrecord.getSymptoms());
        newRecord.setVetName(medicalrecord.getVetName());
        newRecord.setVaccinationDate(medicalrecord.getVaccinationDate());
        newRecord.setSurgery(medicalrecord.getSurgery());
        newRecord.setMedication(medicalrecord.getMedication());
        return medicalRecordRepository.save(newRecord);
    }

    @Override
    public MedicalHistory getmedicalById(UUID id) {
        MedicalHistory m = medicalRecordRepository.findById(id).orElse(null);
        return m;
    }

    @Override
    public MedicalHistory updateMedical(MedicalHistory medical) {
        MedicalHistory m = medicalRecordRepository.findById(medical.getMedicalRecordId()).orElse(null);
        m.setMedication(medical.getMedication());
        m.setSurgery(medical.getSurgery());
        m.setSymptoms(medical.getSymptoms());
        m.setVetName(medical.getVetName());
        m.setVaccinationDate(medical.getVaccinationDate());
        medicalRecordRepository.save(m);
        return medical;
        // return "Details updated!";
    }

    public String deleteMedicalById(UUID id) {
        medicalRecordRepository.deleteById(id);
        return "Deleted";
    }

}