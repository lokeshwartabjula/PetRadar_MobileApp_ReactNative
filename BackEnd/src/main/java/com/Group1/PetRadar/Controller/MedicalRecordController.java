package com.Group1.PetRadar.Controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.Group1.PetRadar.DTO.medicalRecord.AddPetMedicalRecordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Group1.PetRadar.Model.MedicalHistory;
import com.Group1.PetRadar.Service.MedicalRecordService;
import com.Group1.PetRadar.protocol.Response;

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
    public ResponseEntity<Response> updateMovie(@RequestParam Map<String, String> paramList) {
        Response failureResponse = null;
        MedicalHistory medical = null;
        AddPetMedicalRecordDTO newMedicalRecord = new AddPetMedicalRecordDTO();

        paramList.forEach((String key, String value) -> {
            switch (key) {
                case "medicalRecordId" -> newMedicalRecord.setMedicalRecordId(value);
                case "vetVisitDate" -> newMedicalRecord.setVetVisitDate(value);
                case "symptoms" -> newMedicalRecord.setSymptoms(value);
                case "vetName" -> newMedicalRecord.setVetName(value);
                case "vaccinationDate" -> newMedicalRecord.setVaccinationDate(value);
                case "surgery" -> newMedicalRecord.setSurgery(value);
                case "medication" -> newMedicalRecord.setMedication(value);
                // case "image" -> addPetDTO.setImage(value);
                default -> throw new IllegalStateException("Unexpected value: " + key);
            }
        });

        try {
            medical = medicalRecordService.updateMedical(newMedicalRecord);
        } catch (Exception e) {
            failureResponse = new Response(e.getMessage(), HttpStatus.UNAUTHORIZED.value(),
                    HttpStatus.UNAUTHORIZED.name());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(failureResponse);
        }
        Map<String, Object> data = new HashMap<>();
        data.put("medicalRecord", medical);
        Response response = new Response();
        response.setData(data);
        response.setMessage(HttpStatus.ACCEPTED.name());
        response.setStatus(HttpStatus.ACCEPTED.value());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveMedical(@RequestParam Map<String, String> paramList) throws Exception {
        Response failureResponse = null;
        MedicalHistory medical = null;
        AddPetMedicalRecordDTO newMedicalRecord = new AddPetMedicalRecordDTO();

        paramList.forEach((String key, String value) -> {
            switch (key) {
                case "vetVisitDate" -> newMedicalRecord.setVetVisitDate(value);
                case "symptoms" -> newMedicalRecord.setSymptoms(value);
                case "vetName" -> newMedicalRecord.setVetName(value);
                case "vaccinationDate" -> newMedicalRecord.setVaccinationDate(value);
                case "surgery" -> newMedicalRecord.setSurgery(value);
                case "medication" -> newMedicalRecord.setMedication(value);
                case "petId" -> newMedicalRecord.setPetId(value);
                // case "image" -> addPetDTO.setImage(value);
                default -> throw new IllegalStateException("Unexpected value: " + key);
            }
        });

        try {
            medical = medicalRecordService.saveMedical(newMedicalRecord);
        } catch (Exception e) {
            failureResponse = new Response(e.getMessage(), HttpStatus.UNAUTHORIZED.value(),
                    HttpStatus.UNAUTHORIZED.name());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(failureResponse);
        }
        Map<String, Object> data = new HashMap<>();
        data.put("medicalRecord", medical);
        Response response = new Response();
        response.setData(data);
        response.setMessage(HttpStatus.ACCEPTED.name());
        response.setStatus(HttpStatus.ACCEPTED.value());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteMovieById(@PathVariable("id") UUID id) {
        try {
            Response failureResponse = null;
            try {
                medicalRecordService.deleteMedicalById(id);
            } catch (Exception e) {
                failureResponse = new Response(e.getMessage(), HttpStatus.UNAUTHORIZED.value(),
                        HttpStatus.UNAUTHORIZED.name());
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(failureResponse);
            }
            Response response = new Response();
            response.setData("Medical record deleted succesfully");
            response.setMessage(HttpStatus.ACCEPTED.name());
            response.setStatus(HttpStatus.ACCEPTED.value());
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
