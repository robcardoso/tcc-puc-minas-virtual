package com.gisa.informacoesassociado.controller;

import com.gisa.informacoesassociado.config.TokenProvider;
import com.gisa.informacoesassociado.dto.UsuarioDto;
import com.gisa.informacoesassociado.model.AuthToken;
import com.gisa.informacoesassociado.model.LoginUser;
import com.gisa.informacoesassociado.model.UsuarioModel;
import com.gisa.informacoesassociado.service.RoleService;
import com.gisa.informacoesassociado.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> generateToken(@RequestBody LoginUser loginUser) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getNomeUsuario(),
                        loginUser.getSenha()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }

    //@PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value="/salvar", method = RequestMethod.POST)
    public UsuarioModel saveUser(@RequestBody UsuarioDto usuario){
        return usuarioService.save(usuario);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioModel>> listarTodos() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

//    @PreAuthorize("hasRole('ADMIN')")
//    @RequestMapping(value="/adminping", method = RequestMethod.GET)
//    public String adminPing(){
//        return "Apenas um Admin pode ler isto.";
//    }
//
//    @PreAuthorize("hasRole('USUARIO')")
//    @RequestMapping(value="/userping", method = RequestMethod.GET)
//    public String userPing(){
//        return "Apenas um usuário pode ler isto.";
//    }
}
