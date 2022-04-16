package com.gisa.informacoesassociado.service;

import com.gisa.informacoesassociado.eventos.ProdutorEvento;
import com.gisa.informacoesassociado.model.RegistroMedicoModel;
import com.gisa.informacoesassociado.dao.RegistroMedicoDao;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RegistroMedicoService {
    @Autowired
    RegistroMedicoDao registroMedicoDao;

    @Autowired
    Gson gson;

    private final String topico = "RegistroMedico";

    @Transactional
    public RegistroMedicoModel salvar(RegistroMedicoModel registroMedicoModel) {
        return registroMedicoDao.save(registroMedicoModel);
    }

    public boolean salvarComoMensagem(RegistroMedicoModel registroMedicoModel) {
        ProdutorEvento produtor = new ProdutorEvento();
        String mensagem = new Gson().toJson(registroMedicoModel);
        return produtor.enviarMsgRegistroMedico(topico, mensagem);
    }

    public List<RegistroMedicoModel> findAll() {
        return registroMedicoDao.findAll();
    }

    public Optional<RegistroMedicoModel> findById(UUID id) {
        return registroMedicoDao.findById(id);
    }

    @Transactional
    public void delete(RegistroMedicoModel registroMedicoModel) {
        registroMedicoDao.delete(registroMedicoModel);
    }
}
