package com.Group1.PetRadar.Service.Implementation;

import com.Group1.PetRadar.Model.Medical;
import com.Group1.PetRadar.Repository.MedicalRepository;
import com.Group1.PetRadar.Service.MedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalServiceImplementation implements MedicalService {


    @Autowired
    MedicalRepository medicalRepository;

    @Override
    public Medical saveMedical(Medical medical) {

        return medicalRepository.save(medical);
    }

    @Override
    public Medical getmedicalById(Integer id) {
        Medical m = medicalRepository.findById(id).orElse(null);
        return m;
    }

    @Override
    public Medical updateMedical(Medical medical) {
        Medical m = medicalRepository.findById(medical.getMedicalHistoryId()).orElse(null);
        m.setMedication(medical.getMedication());
        m.setSurgery(medical.getSurgery());
        m.setSymptoms(medical.getSymptoms());
        m.setVetName(medical.getVetName());
        m.setVaccinationDate(medical.getVaccinationDate());
        medicalRepository.save(m);
        return medical;
       // return "Details updated!";
    }
    public String deleteMedicalById (Integer id) {
        medicalRepository.deleteById(id);
        return "Deleted";
    }
}
