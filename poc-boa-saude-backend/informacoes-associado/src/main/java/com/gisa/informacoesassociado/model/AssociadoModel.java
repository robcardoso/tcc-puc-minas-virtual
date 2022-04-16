package com.gisa.informacoesassociado.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="TB_ASSOCIADO")
public class AssociadoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, length = 50)
    private String nome;
    @Column(nullable = false, length = 1)
    private String sexo;
    @Column(nullable = false, length = 10)
    private String dataNascimento;
    @Column(nullable = false, length = 30)
    private String profissao;
    @Column(nullable = false, length = 15)
    private String estadoCivil;
    @Column(nullable = false, length = 60)
    private String logradouro;
    @Column(nullable = false, length = 10)
    private String numeroLogradouro;
    @Column(nullable = true, length = 15)
    private String complementoEndereco;
    @Column(nullable = false, length = 10)
    private String cep;
    @Column(nullable = false, length = 20)
    private String bairro;
    @Column(nullable = false, length = 30)
    private String cidade;
    @Column(nullable = false, length = 2)
    private String uf;
    @Column(nullable = true, length = 2)
    private String dddCelular;
    @Column(nullable = true, length = 9)
    private String celular;
    @Column(nullable = true, length = 2)
    private String dddTelefoneFixo;
    @Column(nullable = true, length = 9)
    private String telefoneFixo;
    @Column(nullable = true, length = 50)
    private String email;
    @Column(nullable = false, length = 11)
    private String cpf;
    @Column(nullable = true, length = 15)
    private String rg;
    @Column(nullable = true, length = 10)
    private String orgaoExpedidorRg;
    @Column(nullable = true)
    private LocalDateTime dataExpedicaoRg;
    @Column(nullable = false, length = 50)
    private String nomeMae;
    @Column(nullable = true)
    private Number peso;
    @Column(nullable = true)
    private Number estatura;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumeroLogradouro() {
        return numeroLogradouro;
    }

    public void setNumeroLogradouro(String numeroLogradouro) {
        this.numeroLogradouro = numeroLogradouro;
    }

    public String getComplementoEndereco() {
        return complementoEndereco;
    }

    public void setComplementoEndereco(String complementoEndereco) {
        this.complementoEndereco = complementoEndereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getDddCelular() {
        return dddCelular;
    }

    public void setDddCelular(String dddCelular) {
        this.dddCelular = dddCelular;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDddTelefoneFixo() {
        return dddTelefoneFixo;
    }

    public void setDddTelefoneFixo(String dddTelefoneFixo) {
        this.dddTelefoneFixo = dddTelefoneFixo;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getOrgaoExpedidorRg() {
        return orgaoExpedidorRg;
    }

    public void setOrgaoExpedidorRg(String orgaoExpedidorRg) {
        this.orgaoExpedidorRg = orgaoExpedidorRg;
    }

    public LocalDateTime getDataExpedicaoRg() {
        return dataExpedicaoRg;
    }

    public void setDataExpedicaoRg(LocalDateTime dataExpedicaoRg) {
        this.dataExpedicaoRg = dataExpedicaoRg;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public Number getPeso() {
        return peso;
    }

    public void setPeso(Number peso) {
        this.peso = peso;
    }

    public Number getEstatura() {
        return estatura;
    }

    public void setEstatura(Number estatura) {
        this.estatura = estatura;
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
}
