package com.capone.clinica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Pacientes")
@Getter
@Setter
public class Paciente {
    @Id
    @GeneratedValue
    private Long id;
    private String apellido;
    private String nombre;
    private String dni;
    private String domicilio;
    private String fechaIngreso;

    @JsonIgnore
    @OneToMany(mappedBy = "paciente")
    private Set<Turno> turnos;
}
