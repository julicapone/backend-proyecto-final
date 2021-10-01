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
    @SequenceGenerator(name = "turno_sequence", sequenceName = "turno_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turno_sequence")
    private Long id;

    @ManyToOne
    @JoinColumn(name="odontologo_id", referencedColumnName="id", nullable = false)
    private Odontologo odontologo;

    @ManyToOne
    @JoinColumn(name="paciente_id", referencedColumnName="id", nullable = false)
    private Paciente paciente;
    private String fecha;
}
