package com.gisa.informacoesassociado.dto;

import com.gisa.informacoesassociado.model.UsuarioModel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UsuarioDto {
    @NotBlank
    private Integer id;

    @NotBlank
    @Size(max = 20)
    private String nomeUsuario;

    @NotBlank
    @Size(max = 20)
    private String senha;

    @NotBlank
    @Size(max = 20)
    private String perfil;

    public UsuarioModel getUsuarioFromDto(){
        UsuarioModel usuario = new UsuarioModel();
        usuario.setNomeUsuario(nomeUsuario);
        usuario.setSenha(senha);
        usuario.setPerfil(perfil);
        return usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
}
