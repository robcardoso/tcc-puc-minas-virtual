package com.gisa.informacoesassociado.dao;

import com.gisa.informacoesassociado.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<RoleModel, Integer> {
    public RoleModel findRoleByNome(String nome);
}
