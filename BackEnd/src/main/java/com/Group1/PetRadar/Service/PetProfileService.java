package com.Group1.PetRadar.Service;

import com.Group1.PetRadar.Model.PetprofileModel;

public interface PetProfileService {
    //String saveMovie(Movie movie);
    PetprofileModel savePetProfile(PetprofileModel petprofileModel);
    PetprofileModel getPetprofileById(int id);
    String updatePetprofile(PetprofileModel petprofileModel);
    String deletePetprofileById(int id);

}
