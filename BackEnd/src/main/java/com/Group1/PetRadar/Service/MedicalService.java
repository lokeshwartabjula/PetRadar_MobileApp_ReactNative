package com.Group1.PetRadar.Service;

import com.Group1.PetRadar.Model.Medical;

public interface MedicalService {
    /*static String saveMedicalhistory(Medical medicalhistory);*/

/*    static Medical getmedicalhistoryById(int id) {
    }*/

    Medical saveMedical(Medical medical);


    Medical getmedicalById(Integer id);
    Medical updateMedical(Medical medical);
    String deleteMedicalById(Integer id);

}
