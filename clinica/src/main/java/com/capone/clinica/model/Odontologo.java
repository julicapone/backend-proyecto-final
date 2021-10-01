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
    @SequenceGenerator(name = "odontologo_sequence", sequenceName = "odontologo_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "odontologo_sequence")
    private Long id;
    private String apellido;
    private String nombre;
    private String matricula;

    @JsonIgnore
    @OneToMany(mappedBy = "odontologo", cascade = CascadeType.ALL)
    private Set<Turno> turnos;
}
