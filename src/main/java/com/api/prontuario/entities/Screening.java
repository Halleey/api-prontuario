package com.api.prontuario.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private String registrationNumber;
    private String cpfPatient;
    private Double pressaoArterialSistolica;
    private Double pressaoArterialDiastolica;
    private Double temperatura;
    private Integer frequenciaCardiaca;
    private Double saturacaoOxigenio;
    private LocalDateTime dateTime;


    public String getCpfPatient() {
        return cpfPatient;
    }

    public void setCpfPatient(String cpfPatient) {
        this.cpfPatient = cpfPatient;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
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
