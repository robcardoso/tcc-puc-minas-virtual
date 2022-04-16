package com.gisa.informacoesassociado.dao;

import com.gisa.informacoesassociado.model.AssociadoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AssociadoDao extends JpaRepository<AssociadoModel, UUID> {
    boolean existsByCpf(String cpf);
    boolean existsByRg(String rg);
}
