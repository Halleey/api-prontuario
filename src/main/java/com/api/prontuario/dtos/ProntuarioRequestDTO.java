package com.api.prontuario.dtos;

import java.time.LocalDateTime;

public class ProntuarioRequestDTO {
    private String doctorCrm;
    private String patientCpf;

    private LocalDateTime consultationDate;
    private String diagnosis;
    private String treatment;
    private String observations;

    public String doctorCrm() {
        return doctorCrm;
    }

    public void setDoctorCrm(String doctorCrm) {
        this.doctorCrm = doctorCrm;
    }

    public String patientCpf() {
        return patientCpf;
    }

    public void setPatientCpf(String patientCpf) {
        this.patientCpf = patientCpf;
    }

    public LocalDateTime consultationDate() {
        return consultationDate;
    }

    public void setConsultationDate(LocalDateTime consultationDate) {
        this.consultationDate = consultationDate;
    }

    public String diagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String treatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String observations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }
}
