package com.api.prontuario.dtos;

public class ScreeningRequestDTO {
    private String registrationNumber;
    private String cpfPatient;
    private Double pressaoArterialSistolica;
    private Double pressaoArterialDiastolica;
    private Double temperatura;
    private Integer frequenciaCardiaca;
    private Double saturacaoOxigenio;


    public String getCpfPatient() {
        return cpfPatient;
    }
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public Double getPressaoArterialSistolica() {
        return pressaoArterialSistolica;
    }

    public Double getPressaoArterialDiastolica() {
        return pressaoArterialDiastolica;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public Integer getFrequenciaCardiaca() {
        return frequenciaCardiaca;
    }

    public Double getSaturacaoOxigenio() {
        return saturacaoOxigenio;
    }
}
