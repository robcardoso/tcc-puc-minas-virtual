package com.gisa.informacoesassociado.service;

import com.gisa.informacoesassociado.dto.UsuarioDto;
import com.gisa.informacoesassociado.model.UsuarioModel;

import java.util.List;

public interface UsuarioService {
    UsuarioModel save(UsuarioDto usuario);
    List<UsuarioModel> findAll();
    UsuarioModel findOne(String nomeUsuario);
}
