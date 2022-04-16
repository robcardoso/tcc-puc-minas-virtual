package com.gisa.informacoesassociado.dao;

import com.gisa.informacoesassociado.model.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDao extends CrudRepository<UsuarioModel, Long> {
    UsuarioModel findByNomeUsuario(String nomeUsuario);
}
