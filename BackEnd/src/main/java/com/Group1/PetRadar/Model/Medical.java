package com.Group1.PetRadar.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;
@Entity

@Table(name="Medical_History")
public class Medical {

    @Id
    Integer medicalHistoryId;

    Date vetVisitDate;

    String symptoms;

    String vetName;

    Date vaccinationDate;

    String surgery;

    String medication;

    public Integer getMedicalHistoryId() {
        return medicalHistoryId;
    }

    public void setMedicalHistoryId(Integer medicalHistoryId) {
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


    public Object getId() {
        return null;
    }
}
