package com.Group1.PetRadar.Model;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component;
public class MedicalhistoryModel {
    int medicalHistoryId;

    Date vetVisitDate;

    String symptoms;

    String vetName;

    Date vaccinationDate;

    String surgery;

    String medication;

    public int getMedicalHistoryId() {
        return medicalHistoryId;
    }

    public void setMedicalHistoryId(int medicalHistoryId) {
        this.medicalHistoryId = medicalHistoryId;
    }

    public Date getVetVisitDate() {
        return vetVisitDate;
    }

    public void setVetVisitDate(Date vetVisitDate) {
        this.vetVisitDate = vetVisitDate;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getVetName() {
        return vetName;
    }

    public void setVetName(String vetName) {
        this.vetName = vetName;
    }

    public Date getVaccinationDate() {
        return vaccinationDate;
    }

    public void setVaccinationDate(Date vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
    }

    public String getSurgery() {
        return surgery;
    }

    public void setSurgery(String surgery) {
        this.surgery = surgery;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }




}
