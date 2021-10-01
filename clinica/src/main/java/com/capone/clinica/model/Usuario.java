package com.capone.clinica.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Usuarios")
@Setter
@Getter
public class Usuario {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String contrasenia;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="UsuariosRoles",
            joinColumns = @JoinColumn(name="usuario_id"),
            inverseJoinColumns = @JoinColumn(name="rol_id")
    )
    private Set<Rol> roles;
}
