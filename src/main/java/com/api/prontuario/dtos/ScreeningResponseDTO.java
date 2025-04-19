package com.api.prontuario.dtos;

public class ScreeningResponseDTO {
    
    private String cpfPatient;
    private Double pressaoArterialSistolica;
    private Double pressaoArterialDiastolica;
    private Double temperatura;
    private Integer frequenciaCardiaca;
    private Double saturacaoOxigenio;

    public String getCpfPatient() {
        return cpfPatient;
    }

    public void setCpfPatient(String cpfPatient) {
        this.cpfPatient = cpfPatient;
    }

    public Double getPressaoArterialSistolica() {
        return pressaoArterialSistolica;
    }

    public void setPressaoArterialSistolica(Double pressaoArterialSistolica) {
        this.pressaoArterialSistolica = pressaoArterialSistolica;
    }

    public Double getPressaoArterialDiastolica() {
        return pressaoArterialDiastolica;
    }

    public void setPressaoArterialDiastolica(Double pressaoArterialDiastolica) {
        this.pressaoArterialDiastolica = pressaoArterialDiastolica;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Integer getFrequenciaCardiaca() {
        return frequenciaCardiaca;
    }

    public void setFrequenciaCardiaca(Integer frequenciaCardiaca) {
        this.frequenciaCardiaca = frequenciaCardiaca;
    }

    public Double getSaturacaoOxigenio() {
        return saturacaoOxigenio;
    }

    public void setSaturacaoOxigenio(Double saturacaoOxigenio) {
        this.saturacaoOxigenio = saturacaoOxigenio;
    }
}
