package com.Group1.PetRadar.Service.Implementation;

import com.Group1.PetRadar.DTO.pet.AddPetDTO;
import com.Group1.PetRadar.Model.PetprofileModel;
import com.Group1.PetRadar.Model.User;
import com.Group1.PetRadar.Repository.PetProfileRepository;
import com.Group1.PetRadar.Repository.UserRepository;
import com.Group1.PetRadar.Service.PetProfileService;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.UUID;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.imageio.ImageIO;

@Service
public class PetProfileServiceImplementation implements PetProfileService {
    @Autowired
    PetProfileRepository petprofileRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public PetprofileModel savePetProfile(AddPetDTO petDetails) {
        User user = userRepository.findById(petDetails.getUserId()).get();
        PetprofileModel newPet = new PetprofileModel();

        // Building Pet object
        newPet.setPetName(petDetails.getPetName());
        newPet.setPetBreed(petDetails.getPetBreed());
        newPet.setAge(petDetails.getAge());
        newPet.setPetCategory(petDetails.getPetCategory());
        newPet.setGender(petDetails.getGender());
        newPet.setBio(petDetails.getBio());
        newPet.setPetHeightInCms(petDetails.getPetHeightInCms());
        newPet.setWeightInLbs(petDetails.getWeightInLbs());
        newPet.setWeightInLbs(petDetails.getWeightInLbs());
        newPet.setAllergies(petDetails.getAllergies());
        newPet.setUser(user);
        newPet = petprofileRepository.save(newPet);

        try {
            BufferedImage QrData = generateQRCodeImage(newPet.getPetId().toString());
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(QrData, "jpeg", baos);
            byte[] byteData = baos.toByteArray();
            newPet.setPetQrImage(byteData);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        newPet = petprofileRepository.save(newPet);
        return newPet;
    }

    @Override
    public PetprofileModel getPetprofileById(UUID id) throws Exception {
        PetprofileModel petDetails = null;
        try {
            if (!petprofileRepository.existsById(id)) {
                throw new Exception("Pet not found");
            }
            petDetails = petprofileRepository.findById(id).get();
            return petDetails;

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("No pet profile found for given UUID");
        }
    }

    @Override
    public PetprofileModel updatePetprofile(PetprofileModel petprofileModel) {
        PetprofileModel m = petprofileRepository.findById(petprofileModel.getPetId()).orElse(null);
        if (petprofileModel.getPetName() != null)
            m.setPetName(petprofileModel.getPetName());
        if (petprofileModel.getPetBreed() != null)
            m.setPetBreed(petprofileModel.getPetBreed());
        if (petprofileModel.getAge() > 0)
            m.setAge(petprofileModel.getAge());
        if (petprofileModel.getPetCategory() != null)
            m.setPetCategory(petprofileModel.getPetCategory());
        if (petprofileModel.getPetQrImage() != null)
            m.setPetQrImage(petprofileModel.getPetQrImage());
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

    public static BufferedImage generateQRCodeImage(String barcodeText) throws Exception {
        QRCodeWriter barcodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = null;
        try {
            bitMatrix = barcodeWriter.encode(barcodeText, BarcodeFormat.QR_CODE, 75, 75);
        } catch (WriterException e) {
            throw new RuntimeException(e);
        }
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }
}