package com.Group1.PetRadar.Controller;

import com.Group1.PetRadar.Model.PetprofileModel;
import com.Group1.PetRadar.Model.UserModel;
import com.Group1.PetRadar.Service.PetProfileService;
import com.Group1.PetRadar.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/petprofile")
public class PetprofileController {

    @Autowired
    PetProfileService petProfileService;

    @PostMapping("/create")
    public PetprofileModel createPetprofile(@RequestBody PetprofileModel petprofile) throws Exception {
        petProfileService.savePetProfile(petprofile);
        return petprofile;

    }

    @GetMapping("/get/{id}")
    public PetprofileModel getPetprofileId(@PathVariable("id") int id)
    {
        return petProfileService.getPetprofileById(id);
    }

    @PutMapping("/update")
    public String updatePetprofile(@RequestBody PetprofileModel petprofile)
    {
        return petProfileService.updatePetprofile(petprofile);
    }


    @DeleteMapping("/delete/{id}")
    public String deletePetprofileById(@PathVariable("id") int id)
    {
        return petProfileService.deletePetprofileById(id);
    }



}