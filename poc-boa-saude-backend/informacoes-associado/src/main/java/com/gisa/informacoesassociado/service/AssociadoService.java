package com.gisa.informacoesassociado.service;

import com.gisa.informacoesassociado.model.AssociadoModel;
import com.gisa.informacoesassociado.dao.AssociadoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AssociadoService {

    @Autowired
    AssociadoDao associadoDao;

    public AssociadoService(AssociadoDao associadoDao) {
        this.associadoDao = associadoDao;
    }

    @Transactional
    public AssociadoModel salvar(AssociadoModel associadoModel) {
        return associadoDao.save(associadoModel);
    }

    public boolean existsByCpf(String cpf) {
        return associadoDao.existsByCpf(cpf);
    }

    public boolean existsByRg(String rg) {
        return associadoDao.existsByCpf(rg);
    }

    public List<AssociadoModel> findAll() {
        return associadoDao.findAll();
    }

    public Optional<AssociadoModel> findById(UUID id) {
        return associadoDao.findById(id);
    }

    @Transactional
    public void delete(AssociadoModel associadoModel) {
        associadoDao.delete(associadoModel);
    }
}
