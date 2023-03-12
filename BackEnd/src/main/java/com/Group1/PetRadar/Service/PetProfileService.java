package com.Group1.PetRadar.Service;

import java.util.UUID;

import com.Group1.PetRadar.DTO.AddPetDTO;
import com.Group1.PetRadar.Model.PetprofileModel;

public interface PetProfileService {
    // String saveMovie(Movie movie);
    PetprofileModel savePetProfile(AddPetDTO petprofileModel);

    PetprofileModel getPetprofileById(UUID id);

    PetprofileModel updatePetprofile(PetprofileModel petprofileModel);

    String deletePetprofileById(UUID id);

}
