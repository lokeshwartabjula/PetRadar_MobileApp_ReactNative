package com.Group1.PetRadar.Service;

import com.Group1.PetRadar.DTO.AddPetDTO;
import com.Group1.PetRadar.Model.PetprofileModel;

public interface PetProfileService {
    // String saveMovie(Movie movie);
    PetprofileModel savePetProfile(AddPetDTO petprofileModel);

    PetprofileModel getPetprofileById(int id);

    String updatePetprofile(PetprofileModel petprofileModel);

    String deletePetprofileById(int id);

}
