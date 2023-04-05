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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public ResponseEntity<Response> createPetprofile(@RequestBody AddPetDTO petprofile) throws Exception {
        Response failureResponse = null;
        PetprofileModel petDetails = null;
        try {
            petDetails = petProfileService.savePetProfile(petprofile);
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
    public PetprofileModel getPetprofileId(@PathVariable("id") UUID id) {
        return petProfileService.getPetprofileById(id);
    }

    @PutMapping("/update")
    public PetprofileModel updatePetprofile(@RequestBody PetprofileModel petprofile) {
        return petProfileService.updatePetprofile(petprofile);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePetprofileById(@PathVariable("id") UUID id) {
        return petProfileService.deletePetprofileById(id);
    }
}