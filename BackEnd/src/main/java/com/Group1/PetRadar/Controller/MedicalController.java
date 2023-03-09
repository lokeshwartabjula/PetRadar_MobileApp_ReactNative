package com.Group1.PetRadar.Controller;

import com.Group1.PetRadar.Model.Medical;
import com.Group1.PetRadar.Repository.MedicalRepository;
import com.Group1.PetRadar.Service.MedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
            //return "data saved";
        }
        @DeleteMapping("/delete/{id}")
        public String deleteMovieById(@PathVariable("id") int id) {
           return medicalService.deleteMedicalById(id);
        }
    }


