package com.gisa.informacoesassociado.service.impl;

import java.util.*;

import com.gisa.informacoesassociado.dao.UsuarioDao;
import com.gisa.informacoesassociado.dto.UsuarioDto;
import com.gisa.informacoesassociado.model.RoleModel;
import com.gisa.informacoesassociado.model.UsuarioModel;
import com.gisa.informacoesassociado.service.RoleService;
import com.gisa.informacoesassociado.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service(value = "UsuarioService")
public class UsuarioServiceImpl implements UserDetailsService, UsuarioService {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UsuarioDao userDao;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioModel usuario = userDao.findByNomeUsuario(username);
        if(usuario == null){
            throw new UsernameNotFoundException("Usuário ou senha inválida.");
        }
        return new org.springframework.security.core.userdetails.User(usuario.getNomeUsuario(), usuario.getSenha(), getAuthority(usuario));
    }

    private Set<SimpleGrantedAuthority> getAuthority(UsuarioModel user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getNome()));
        });
        return authorities;
    }

    public List<UsuarioModel> findAll() {
        List<UsuarioModel> list = new ArrayList<>();
        userDao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public UsuarioModel findOne(String nomeUsuario) {
        return userDao.findByNomeUsuario(nomeUsuario);
    }

    @Override
    public UsuarioModel save(UsuarioDto usuario) {

        UsuarioModel nUser = usuario.getUsuarioFromDto();
        nUser.setSenha(bcryptEncoder.encode(usuario.getSenha()));

        RoleModel role = roleService.findByNome("USUARIO");
        Set<RoleModel> roleSet = new HashSet<>();
        roleSet.add(role);

        String[] perfisDisponiveis = new String[] {"ADMIN", "PRESTADOR", "CONVENIADO"};
        boolean perfilEncontrado = Arrays.asList(perfisDisponiveis).contains(nUser.getPerfil().toUpperCase());

        if (perfilEncontrado) {
            role = roleService.findByNome(nUser.getPerfil().toUpperCase());
            roleSet.add(role);
        }

        nUser.setRoles(roleSet);
        return userDao.save(nUser);
    }
}
