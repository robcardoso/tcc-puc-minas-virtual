package com.gisa.informacoesassociado.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="TB_REGISTRO_MEDICO")
public class RegistroMedicoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private String idAssociado;
    @Column(nullable = false, length = 50)
    private String nomeProfissional;
    @Column(nullable = false, length = 10)
    private String crm;
    @Column(nullable = false, length = 32767)
    private String observacoesDaConsulta;
    @Column(nullable = false)
    private LocalDateTime dataRegistro;
    @Column(nullable = false)
    private LocalDateTime dataAtualizacaoRegistro;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public LocalDateTime getDataAtualizacaoRegistro() {
        return dataAtualizacaoRegistro;
    }

    public void setDataAtualizacaoRegistro(LocalDateTime dataAtualizacaoRegistro) {
        this.dataAtualizacaoRegistro = dataAtualizacaoRegistro;
    }

    @Override
    public String toString() {
        return "RegistroMedicoModel{" +
                "id=" + id +
                ", idAssociado='" + idAssociado + '\'' +
                ", nomeProfissional='" + nomeProfissional + '\'' +
                ", crm='" + crm + '\'' +
                ", observacoesDaConsulta='" + observacoesDaConsulta + '\'' +
                ", dataRegistro=" + dataRegistro +
                ", dataAtualizacaoRegistro=" + dataAtualizacaoRegistro +
                '}';
    }
}
