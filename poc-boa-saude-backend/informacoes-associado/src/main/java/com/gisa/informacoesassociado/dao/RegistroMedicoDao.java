package com.gisa.informacoesassociado.dao;

import com.gisa.informacoesassociado.model.RegistroMedicoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RegistroMedicoDao extends JpaRepository<RegistroMedicoModel, UUID> {

}
