package com.api.prontuario.dtos;

import java.time.LocalDateTime;
import java.util.List;

public class ProntuarioRequestDTO {
    private String doctorCrm;
    private String patientCpf;
    private String diagnosis;
    private String treatment;
    private String observations;
    List<PrescriptionRequestDTO> requestDTOS;

    public List<PrescriptionRequestDTO> getRequestDTOS() {
        return requestDTOS;
    }

    public void setRequestDTOS(List<PrescriptionRequestDTO> requestDTOS) {
        this.requestDTOS = requestDTOS;
    }

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
