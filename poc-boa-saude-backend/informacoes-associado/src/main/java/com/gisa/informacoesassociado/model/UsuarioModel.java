package com.gisa.informacoesassociado.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="TB_USUARIO")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String nomeUsuario;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;

    @Column(length = 20)
    private String perfil;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "TB_USUARIO_ROLES",
            joinColumns = {
                    @JoinColumn(name = "USUARIO_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID") })
    private Set<RoleModel> roles;
}
