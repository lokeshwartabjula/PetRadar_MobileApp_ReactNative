package com.Group1.PetRadar.Service;

import com.Group1.PetRadar.Model.PetprofileModel;
import com.Group1.PetRadar.repository.PetProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PetProfileServiceImplementation implements  PetProfileService {

    @Autowired
    PetProfileRepository petprofileRepository;

    @Override
    public PetprofileModel savePetProfile(PetprofileModel petprofileModel) {
        petprofileModel.setPetId(petprofileModel.getPetId());
        petprofileRepository.save(petprofileModel);
        return petprofileModel;
    }

    @Override
    public PetprofileModel getPetprofileById(int id) {
        PetprofileModel m = petprofileRepository.findById(id).orElse(null);
        return m;
    }


    @Override
    public String updatePetprofile(PetprofileModel petprofileModel) {
        PetprofileModel m = petprofileRepository.findById(petprofileModel.getPetId()).orElse(null);
        if(petprofileModel.getPetName()!=null)
        m.setPetName(petprofileModel.getPetName());
        if(petprofileModel.getPetBreed()!=null)
        m.setPetBreed(petprofileModel.getPetBreed());
        if(petprofileModel.getPetDob()!=null)
        m.setPetDob(petprofileModel.getPetDob());
        if(petprofileModel.getPetCategory()!=null)
        m.setPetCategory(petprofileModel.getPetCategory());
        if(petprofileModel.getPetQrImageId()!=null)
        m.setPetQrImageId(petprofileModel.getPetQrImageId());
        if(petprofileModel.getGender()!=null)
        m.setGender(petprofileModel.getGender());
        if(petprofileModel.getBio()!=null)
        m.setBio(petprofileModel.getBio());
        if(petprofileModel.getPetHeightInCms()!=null)
        m.setPetHeightInCms(petprofileModel.getPetHeightInCms());
        if(petprofileModel.getWeightInLbs()!=null)
        m.setWeightInLbs(petprofileModel.getWeightInLbs());
        if(petprofileModel.getPetIdentificationMarks()!=null)
        m.setPetIdentificationMarks(petprofileModel.getPetIdentificationMarks());
        if(petprofileModel.getAllergies()!=null)
        m.setAllergies(petprofileModel.getAllergies());

        petprofileRepository.save(m);
        return "Petprofile updated!";
    }

    @Override
    public String deletePetprofileById(int id) {
        petprofileRepository.deleteById(id);
        return "Petprofile deleted!";
    }






}