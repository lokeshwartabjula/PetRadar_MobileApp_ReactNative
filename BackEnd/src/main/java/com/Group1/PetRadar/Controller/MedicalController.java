package com.Group1.PetRadar.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Group1.PetRadar.Model.Medical;
import com.Group1.PetRadar.Service.MedicalService;

@RestController
@RequestMapping("/medical")
public class MedicalController {

    @Autowired
    MedicalService medicalService;

    @GetMapping("/get/{id}")
    public Medical getmedicalById(@PathVariable("id") int id) {
        return medicalService.getmedicalById(id);
    }

    @PutMapping("/update")
    public Medical updateMovie(@RequestBody Medical medical) {
        return medicalService.updateMedical(medical);
    }

    @PostMapping("/save")
    public Medical saveMedical(@RequestBody Medical medical) {
        return medicalService.saveMedical(medical);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMovieById(@PathVariable("id") int id) {
        return medicalService.deleteMedicalById(id);
    }
}
