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
import com.Group1.PetRadar.DTO.pet.AddPetDTO;
import com.Group1.PetRadar.Model.PetprofileModel;
import com.Group1.PetRadar.Service.PetProfileService;

@RestController
@RequestMapping("/petprofile")
public class PetprofileController {

    @Autowired
    PetProfileService petProfileService;

    @PostMapping("/create")
    public PetprofileModel createPetprofile(@RequestBody AddPetDTO petprofile) throws Exception {
        return petProfileService.savePetProfile(petprofile);

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