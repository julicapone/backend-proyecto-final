package com.capone.clinica.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Turnos")
@Getter
@Setter
public class Turno {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name="odontologo_id", referencedColumnName="id", nullable = false)
    private Odontologo odontologo;

    @ManyToOne
    @JoinColumn(name="paciente_id", referencedColumnName="id", nullable = false)
    private Paciente paciente;
    private String fecha;
}
