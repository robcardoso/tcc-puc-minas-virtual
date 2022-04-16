package com.gisa.informacoesassociado.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class AssociadoDto {
    @NotBlank
    @Size(max = 50)
    private String nome;
    @NotBlank
    @Size(max = 1)
    private String sexo;
    @NotBlank
    @Size(max = 10)
    private String dataNascimento;
    @NotBlank
    @Size(max = 30)
    private String profissao;
    @NotBlank
    @Size(max = 15)
    private String estadoCivil;
    @NotBlank
    @Size(max = 60)
    private String logradouro;
    @NotBlank
    @Size(max = 10)
    private String numeroLogradouro;
    @Size(max = 15)
    private String complementoEndereco;
    @NotBlank
    @Size(max = 10)
    private String cep;
    @NotBlank
    @Size(max = 20)
    private String bairro;
    @NotBlank
    @Size(max = 30)
    private String cidade;
    @NotBlank
    @Size(max = 2)
    private String uf;
    @Size(max = 2)
    private String dddCelular;
    @Size(max = 9)
    private String celular;
    @Size(max = 2)
    private String dddTelefoneFixo;
    @Size(max = 9)
    private String telefoneFixo;
    @Size(max = 50)
    private String email;
    @NotBlank
    @Size(max = 11)
    private String cpf;
    @Size(max = 15)
    private String rg;
    @Size(max = 10)
    private String orgaoExpedidorRg;
    private LocalDateTime dataExpedicaoRg;
    @NotBlank
    @Size(max = 50)
    private String nomeMae;
    private Number peso;
    private Number estatura;

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
}
