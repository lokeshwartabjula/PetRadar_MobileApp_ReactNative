package com.Group1.PetRadar.DTO.medicalRecord;

import java.util.Date;
import java.util.UUID;

public class AddPetMedicalRecordDTO {
    private UUID medicalRecordId;
    private Date vetVisitDate;
    private String symptoms;
    private String vetName;
    private Date vaccinationDate;
    private String surgery;
    private String medication;

    // default constructor
    public AddPetMedicalRecordDTO() {
    }

    // parameterized constructor
    public void MedicalRecordDto(
            UUID medicalRecordId,
            Date vetVisitDate,
            String symptoms,
            String vetName,
            Date vaccinationDate,
            String surgery,
            String medication) {
        this.medicalRecordId = medicalRecordId;
        this.vetVisitDate = vetVisitDate;
        this.symptoms = symptoms;
        this.vetName = vetName;
        this.vaccinationDate = vaccinationDate;
        this.surgery = surgery;
        this.medication = medication;
    }

    // getter and setter methods
    public UUID getMedicalRecordId() {
        return medicalRecordId;
    }

    public void setMedicalRecordId(UUID medicalRecordId) {
        this.medicalRecordId = medicalRecordId;
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
