package com.gisa.informacoesassociado.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RegistroMedicoDto {
    @NotBlank
    private String idAssociado;
    @NotBlank
    @Size(max = 50)
    private String nomeProfissional;
    @NotBlank
    @Size(max = 10)
    private String crm;
    @NotBlank
    @Size(max = 32767)
    private String observacoesDaConsulta;

    public String getIdAssociado() {
        return idAssociado;
    }

    public void setIdAssociado(String idAssociado) {
        this.idAssociado = idAssociado;
    }

    public String getNomeProfissional() {
        return nomeProfissional;
    }

    public void setNomeProfissional(String nomeProfissional) {
        this.nomeProfissional = nomeProfissional;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getObservacoesDaConsulta() {
        return observacoesDaConsulta;
    }

    public void setObservacoesDaConsulta(String observacoesDaConsulta) {
        this.observacoesDaConsulta = observacoesDaConsulta;
    }

    @Override
    public String toString() {
        return "RegistroMedicoDto{" +
                "idAssociado='" + idAssociado + '\'' +
                ", nomeProfissional='" + nomeProfissional + '\'' +
                ", crm='" + crm + '\'' +
                ", observacoesDaConsulta='" + observacoesDaConsulta + '\'' +
                '}';
    }
}
