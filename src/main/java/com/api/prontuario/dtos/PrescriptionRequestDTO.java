package com.api.prontuario.dtos;

public class PrescriptionRequestDTO {

    String medicationName;
    String dose;
    String frequency;
    String duration;

    public String getMedicationName() {
        return medicationName;
    }
    public String getDose() {
        return dose;
    }
    public String getFrequency() {
        return frequency;
    }

    public String getDuration() {
        return duration;
    }

}
