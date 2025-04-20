package com.api.prontuario.dtos;
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
    public String patientCpf() {
        return patientCpf;
    }

    public String diagnosis() {
        return diagnosis;
    }

    public String treatment() {
        return treatment;
    }



    public String observations() {
        return observations;
    }


}
