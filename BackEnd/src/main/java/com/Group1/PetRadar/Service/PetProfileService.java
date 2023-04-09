package com.Group1.PetRadar.Service;

import java.util.List;
import java.util.UUID;

import com.Group1.PetRadar.DTO.pet.AddPetDTO;
import com.Group1.PetRadar.Model.MedicalHistory;
import com.Group1.PetRadar.Model.PetprofileModel;

public interface PetProfileService {
    // String saveMovie(Movie movie);
    PetprofileModel savePetProfile(AddPetDTO petprofileModel);

    PetprofileModel getPetprofileById(UUID id) throws Exception;

    PetprofileModel updatePetprofile(AddPetDTO petprofileModel);

    List<MedicalHistory> getmedicalByPetId(UUID id) throws Exception;

    String deletePetprofileById(UUID id);

}
