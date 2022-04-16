package com.gisa.informacoesassociado.service.impl;

import com.gisa.informacoesassociado.dao.RoleDao;
import com.gisa.informacoesassociado.model.RoleModel;
import com.gisa.informacoesassociado.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public RoleModel findByNome(String nome) {
        RoleModel role = roleDao.findRoleByNome(nome);
        return role;
    }
}
