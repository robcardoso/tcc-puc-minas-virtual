package com.gisa.informacoesassociado.controller;

import com.gisa.informacoesassociado.dto.RegistroMedicoDto;
import com.gisa.informacoesassociado.model.RegistroMedicoModel;
import com.gisa.informacoesassociado.service.RegistroMedicoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/registro-medico")
public class RegistroMedicoController {
    @Autowired
    RegistroMedicoService registroMedicoService;

    @PreAuthorize("hasAnyRole('PRESTADOR')")
    @PostMapping("/gravar-bd")
    public ResponseEntity<Object> salvarRegistroMedicoNoBanco(@RequestBody @Valid RegistroMedicoDto registroMedicoDto) {
        var registroMedicoModel = new RegistroMedicoModel();
        BeanUtils.copyProperties(registroMedicoDto, registroMedicoModel);
        registroMedicoModel.setDataRegistro(LocalDateTime.now(ZoneId.of("UTC")));
        registroMedicoModel.setDataAtualizacaoRegistro(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(registroMedicoService.salvar(registroMedicoModel));
    }

    @PreAuthorize("hasAnyRole('PRESTADOR','CONVENIADO')")
    @PostMapping
    public ResponseEntity<Object> salvarRegistroMedicoComoMensagem(@RequestBody @Valid RegistroMedicoDto registroMedicoDto) {
        var registroMedicoModel = new RegistroMedicoModel();
        BeanUtils.copyProperties(registroMedicoDto, registroMedicoModel);
        registroMedicoModel.setDataRegistro(LocalDateTime.now(ZoneId.of("UTC")));
        registroMedicoModel.setDataAtualizacaoRegistro(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(registroMedicoService.salvarComoMensagem(registroMedicoModel));
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<RegistroMedicoModel>> getAllRegistrosMedicos(){
        return ResponseEntity.status(HttpStatus.OK).body(registroMedicoService.findAll());
    }

    @PreAuthorize("hasAnyRole('ADMIN','PRESTADOR','CONVENIADO')")
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneRegistroMedico(@PathVariable(value = "id") UUID id){
        Optional<RegistroMedicoModel> registroMedicoModelOptional = registroMedicoService.findById(id);
        if (!registroMedicoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registro médico não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(registroMedicoModelOptional.get());
    }

    @PreAuthorize("hasAnyRole('PRESTADOR','CONVENIADO')")
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateRegistroMedico(@PathVariable(value = "id") UUID id,
                                                  @RequestBody @Valid RegistroMedicoDto registroMedicoDto){
        Optional<RegistroMedicoModel> registroMedicoModelOptional = registroMedicoService.findById(id);
        if (!registroMedicoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registro médico não encontrado.");
        }
        var registroMedicoModel = new RegistroMedicoModel();
        BeanUtils.copyProperties(registroMedicoDto, registroMedicoModel);
        registroMedicoModel.setId(registroMedicoModelOptional.get().getId());
        registroMedicoModel.setDataRegistro(registroMedicoModelOptional.get().getDataRegistro());
        registroMedicoModel.setDataAtualizacaoRegistro(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.OK).body(registroMedicoService.salvar(registroMedicoModel));
    }
}
