package com.capone.clinica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Odontologos")
@Getter
@Setter
public class Odontologo {
    @Id
    @GeneratedValue
    private Long id;
    private String apellido;
    private String nombre;
    private String matricula;

    @JsonIgnore
    @OneToMany(mappedBy = "odontologo")
    private Set<Turno> turnos;
}
