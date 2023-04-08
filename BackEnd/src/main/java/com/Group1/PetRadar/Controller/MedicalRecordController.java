package com.Group1.PetRadar.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.Group1.PetRadar.protocol.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Group1.PetRadar.DTO.medicalRecord.AddPetMedicalRecordDTO;
import com.Group1.PetRadar.Model.MedicalHistory;
import com.Group1.PetRadar.Service.MedicalRecordService;

@RestController
@RequestMapping("/medical")
public class MedicalRecordController {

    @Autowired
    MedicalRecordService medicalRecordService;

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getmedicalById(@PathVariable("id") UUID id) throws Exception {
        MedicalHistory medicalHistory = null;
        Response failureResponse = null;
        try {
            medicalHistory = medicalRecordService.getmedicalById(id);
        } catch (Exception e) {
            failureResponse = new Response(e.getMessage(), HttpStatus.UNAUTHORIZED.value(),
                    HttpStatus.UNAUTHORIZED.name());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(failureResponse);
        }
        Map<String, Object> data = new HashMap<>();
        data.put("medicalHistory", medicalHistory);
        Response response = new Response();
        response.setData(data);
        response.setMessage(HttpStatus.ACCEPTED.name());
        response.setStatus(HttpStatus.ACCEPTED.value());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
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
