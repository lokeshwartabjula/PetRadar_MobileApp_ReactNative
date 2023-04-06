package com.Group1.PetRadar.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Group1.PetRadar.DTO.pet.AddPetDTO;
import com.Group1.PetRadar.Model.PetprofileModel;
import com.Group1.PetRadar.Service.PetProfileService;
import com.Group1.PetRadar.protocol.Response;

@RestController
@RequestMapping("/petprofile")
public class PetprofileController {
    @Autowired
    PetProfileService petProfileService;

    @PostMapping("/create")
    public ResponseEntity<Response> createPetprofile(@RequestParam Map<String, String> paramList,
            @RequestParam("image") MultipartFile file) throws Exception {
        Response failureResponse = null;
        PetprofileModel petDetails = null;
        AddPetDTO addPetDTO = new AddPetDTO();
        paramList.forEach((String key, String value) -> {
            switch (key) {
                case "petName" -> addPetDTO.setPetName(value);
                case "petBreed" -> addPetDTO.setPetBreed(value);
                case "age" -> addPetDTO.setAge(Integer.parseInt(value));
                case "petCategory" -> addPetDTO.setPetCategory(value);
                case "gender" -> addPetDTO.setGender(value);
                case "bio" -> addPetDTO.setBio(value);
                case "petHeightInCms" -> addPetDTO.setPetHeightInCms(Float.parseFloat(value));
                case "weightInLbs" -> addPetDTO.setWeightInLbs(Float.parseFloat(value));
                case "petIdentificationMarks" -> addPetDTO.setPetIdentificationMarks(value);
                case "allergies" -> addPetDTO.setAllergies(value);
                case "userId" -> addPetDTO.setUserId(value);
                // case "image" -> addPetDTO.setImage(value);
                default -> throw new IllegalStateException("Unexpected value: " + key);
            }
        });

        try {
            petDetails = petProfileService.savePetProfile(addPetDTO);
        } catch (Exception e) {
            failureResponse = new Response(e.getMessage(), HttpStatus.UNAUTHORIZED.value(),
                    HttpStatus.UNAUTHORIZED.name());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(failureResponse);
        }
        Response response = new Response();
        Map<String, Object> data = new HashMap<>();
        data.put("PetDetails", petDetails);
        response.setData(data);
        response.setMessage(HttpStatus.ACCEPTED.name());
        response.setStatus(HttpStatus.ACCEPTED.value());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getPetprofileId(@PathVariable("id") UUID id) {
        PetprofileModel post = null;
        Response failureResponse = null;

        try {
            post = petProfileService.getPetprofileById(id);
        } catch (Exception e) {
            failureResponse = new Response(e.getMessage(), HttpStatus.UNAUTHORIZED.value(),
                    HttpStatus.UNAUTHORIZED.name());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(failureResponse);
        }
        Map<String, Object> data = new HashMap<>();
        data.put("petProfile", post);
        Response response = new Response();
        response.setData(data);
        response.setMessage(HttpStatus.ACCEPTED.name());
        response.setStatus(HttpStatus.ACCEPTED.value());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);

    }

    @PutMapping("/update")
    public ResponseEntity<Response> updatePetprofile(@RequestParam Map<String, String> paramList,
            @RequestParam(name = "image", required = false) MultipartFile file) {
        Response failureResponse = null;
        PetprofileModel petDetails = null;
        AddPetDTO addPetDTO = new AddPetDTO();
        paramList.forEach((String key, String value) -> {
            switch (key) {
                case "petName" -> addPetDTO.setPetName(value);
                case "petBreed" -> addPetDTO.setPetBreed(value);
                case "age" -> addPetDTO.setAge(Integer.parseInt(value));
                case "petCategory" -> addPetDTO.setPetCategory(value);
                case "gender" -> addPetDTO.setGender(value);
                case "bio" -> addPetDTO.setBio(value);
                case "petHeightInCms" -> addPetDTO.setPetHeightInCms(Float.parseFloat(value));
                case "weightInLbs" -> addPetDTO.setWeightInLbs(Float.parseFloat(value));
                case "petIdentificationMarks" -> addPetDTO.setPetIdentificationMarks(value);
                case "allergies" -> addPetDTO.setAllergies(value);
                case "petId" -> addPetDTO.setPetId(value);
                // case "image" -> addPetDTO.setImage(value);
                default -> throw new IllegalStateException("Unexpected value: " + key);
            }
        });

        try {
            petDetails = petProfileService.updatePetprofile(addPetDTO);
        } catch (Exception e) {
            failureResponse = new Response(e.getMessage(), HttpStatus.UNAUTHORIZED.value(),
                    HttpStatus.UNAUTHORIZED.name());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(failureResponse);
        }
        Response response = new Response();
        Map<String, Object> data = new HashMap<>();
        data.put("PetDetails", petDetails);
        response.setData(data);
        response.setMessage(HttpStatus.ACCEPTED.name());
        response.setStatus(HttpStatus.ACCEPTED.value());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deletePetprofileById(@PathVariable("id") UUID id) {
        try {
            Response failureResponse = null;
            try {
                petProfileService.deletePetprofileById(id);
            } catch (Exception e) {
                failureResponse = new Response(e.getMessage(), HttpStatus.UNAUTHORIZED.value(),
                        HttpStatus.UNAUTHORIZED.name());
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(failureResponse);
            }
            Response response = new Response();
            response.setData("Pet deleted succesfully");
            response.setMessage(HttpStatus.ACCEPTED.name());
            response.setStatus(HttpStatus.ACCEPTED.value());
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}