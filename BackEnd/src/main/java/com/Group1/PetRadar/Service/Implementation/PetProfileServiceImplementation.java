package com.Group1.PetRadar.Service.Implementation;

import com.Group1.PetRadar.DTO.AddPetDTO;
import com.Group1.PetRadar.Model.PetprofileModel;
import com.Group1.PetRadar.Model.User;
import com.Group1.PetRadar.Repository.PetProfileRepository;
import com.Group1.PetRadar.Repository.UserRepository;
import com.Group1.PetRadar.Service.PetProfileService;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetProfileServiceImplementation implements PetProfileService {

    @Autowired
    PetProfileRepository petprofileRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public PetprofileModel savePetProfile(AddPetDTO petDetails) {
        System.out.println(petDetails.getUserId());
        System.out.println(userRepository.findById(petDetails.getUserId()));
        System.out.println(userRepository.findById(petDetails.getUserId()).get());
        User user = userRepository.findById(petDetails.getUserId()).get();
        PetprofileModel newPet = new PetprofileModel();

        // Building Pet object
        newPet.setPetName(petDetails.getPetName());
        newPet.setPetBreed(petDetails.getPetBreed());
        newPet.setPetDob(petDetails.getPetDob());
        newPet.setPetCategory(petDetails.getPetCategory());
        newPet.setPetQrImageId(petDetails.getPetQrImageId());
        newPet.setGender(petDetails.getGender());
        newPet.setBio(petDetails.getBio());
        newPet.setPetHeightInCms(petDetails.getPetHeightInCms());
        newPet.setWeightInLbs(petDetails.getWeightInLbs());
        newPet.setWeightInLbs(petDetails.getWeightInLbs());
        newPet.setAllergies(petDetails.getAllergies());
        newPet.setUser(user);

        // PetprofileModel data =
        return petprofileRepository.save(newPet);
        // return data;
    }

    @Override
    public PetprofileModel getPetprofileById(UUID id) {
        PetprofileModel m = petprofileRepository.findById(id).orElse(null);
        return m;
    }

    @Override
    public PetprofileModel updatePetprofile(PetprofileModel petprofileModel) {
        PetprofileModel m = petprofileRepository.findById(petprofileModel.getPetId()).orElse(null);
        if (petprofileModel.getPetName() != null)
            m.setPetName(petprofileModel.getPetName());
        if (petprofileModel.getPetBreed() != null)
            m.setPetBreed(petprofileModel.getPetBreed());
        if (petprofileModel.getPetDob() != null)
            m.setPetDob(petprofileModel.getPetDob());
        if (petprofileModel.getPetCategory() != null)
            m.setPetCategory(petprofileModel.getPetCategory());
        if (petprofileModel.getPetQrImageId() != null)
            m.setPetQrImageId(petprofileModel.getPetQrImageId());
        if (petprofileModel.getGender() != null)
            m.setGender(petprofileModel.getGender());
        if (petprofileModel.getBio() != null)
            m.setBio(petprofileModel.getBio());
        if (petprofileModel.getPetHeightInCms() != null)
            m.setPetHeightInCms(petprofileModel.getPetHeightInCms());
        if (petprofileModel.getWeightInLbs() != null)
            m.setWeightInLbs(petprofileModel.getWeightInLbs());
        if (petprofileModel.getPetIdentificationMarks() != null)
            m.setPetIdentificationMarks(petprofileModel.getPetIdentificationMarks());
        if (petprofileModel.getAllergies() != null)
            m.setAllergies(petprofileModel.getAllergies());
        return petprofileRepository.save(m);
    }

    @Override
    public String deletePetprofileById(UUID id) {
        petprofileRepository.deleteById(id);
        return "Petprofile deleted!";
    }

}