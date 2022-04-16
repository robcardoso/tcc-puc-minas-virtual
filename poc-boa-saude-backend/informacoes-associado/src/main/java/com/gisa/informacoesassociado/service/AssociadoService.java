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
    AssociadoDao associadoRepository;

    public AssociadoService(AssociadoDao associadoRepository) {
        this.associadoRepository = associadoRepository;
    }

    @Transactional
    public AssociadoModel salvar(AssociadoModel associadoModel) {
        return associadoRepository.save(associadoModel);
    }

    public boolean existsByCpf(String cpf) {
        return associadoRepository.existsByCpf(cpf);
    }

    public boolean existsByRg(String rg) {
        return associadoRepository.existsByCpf(rg);
    }

    public List<AssociadoModel> findAll() {
        return associadoRepository.findAll();
    }

    public Optional<AssociadoModel> findById(UUID id) {
        return associadoRepository.findById(id);
    }

    @Transactional
    public void delete(AssociadoModel associadoModel) {
        associadoRepository.delete(associadoModel);
    }
}
