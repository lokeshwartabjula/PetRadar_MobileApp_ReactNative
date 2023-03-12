package com.Group1.PetRadar.Controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Group1.PetRadar.DTO.AddPetMedicalRecordDTO;
import com.Group1.PetRadar.Model.MedicalHistory;
import com.Group1.PetRadar.Service.MedicalRecordService;

@RestController
@RequestMapping("/medical")
public class MedicalRecordController {

    @Autowired
    MedicalRecordService medicalRecordService;

    @GetMapping("/get/{id}")
    public MedicalHistory getmedicalById(@PathVariable("id") UUID id) {
        return medicalRecordService.getmedicalById(id);
    }

    @PutMapping("/update")
    public MedicalHistory updateMovie(@RequestBody MedicalHistory medical) {
        return medicalRecordService.updateMedical(medical);
    }

    @PostMapping("/save")
    public MedicalHistory saveMedical(@RequestBody AddPetMedicalRecordDTO medical) {
        return medicalRecordService.saveMedical(medical);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMovieById(@PathVariable("id") UUID id) {
        return medicalRecordService.deleteMedicalById(id);
    }
}
