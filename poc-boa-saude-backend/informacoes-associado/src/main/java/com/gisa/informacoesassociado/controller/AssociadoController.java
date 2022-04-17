package com.gisa.informacoesassociado.controller;

import com.gisa.informacoesassociado.dto.AssociadoDto;
import com.gisa.informacoesassociado.model.AssociadoModel;
import com.gisa.informacoesassociado.service.AssociadoService;
import org.springframework.beans.BeanUtils;
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
@RequestMapping("/api/associado")
public class AssociadoController {

    final AssociadoService associadoService;

    public AssociadoController(AssociadoService associadoService) {
        this.associadoService = associadoService;
    }

    @PreAuthorize("hasAnyRole('ADMIN','PRESTADOR','CONVENIADO')")
    @PostMapping
    public ResponseEntity<Object> salvarAssociado(@RequestBody @Valid AssociadoDto associadoDto) {

        if (associadoService.existsByCpf(associadoDto.getCpf())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Atenção: CPF já cadastrado!");
        }
        if (associadoService.existsByRg(associadoDto.getRg())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Atenção: RG já cadastrado!");
        }
        var associadoModel = new AssociadoModel();
        BeanUtils.copyProperties(associadoDto, associadoModel);
        associadoModel.setDataRegistro(LocalDateTime.now(ZoneId.of("UTC")));
        associadoModel.setDataAtualizacaoRegistro(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(associadoService.salvar(associadoModel));
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<AssociadoModel>> getAllAssociados(){
        return ResponseEntity.status(HttpStatus.OK).body(associadoService.findAll());
    }

    @PreAuthorize("hasAnyRole('ADMIN','PRESTADOR','CONVENIADO')")
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneAssociado(@PathVariable(value = "id") UUID id){
        Optional<AssociadoModel> associadoModelOptional = associadoService.findById(id);
        if (!associadoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Associado não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(associadoModelOptional.get());
    }
}
