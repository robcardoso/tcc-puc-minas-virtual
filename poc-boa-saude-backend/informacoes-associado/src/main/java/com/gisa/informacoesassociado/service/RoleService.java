package com.gisa.informacoesassociado.service;

import com.gisa.informacoesassociado.model.RoleModel;

public interface RoleService {
    RoleModel findByNome(String nome);
}
