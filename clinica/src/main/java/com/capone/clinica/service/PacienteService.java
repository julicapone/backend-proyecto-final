package com.capone.clinica.service;

import com.capone.clinica.model.Paciente;

import java.util.List;
import java.util.Optional;

public interface PacienteService {
    void registrar(Paciente paciente);
    Optional<Paciente> traerPorId(Long id);
    List<Paciente> traerTodos();
    void modificar(Paciente paciente);
    void eliminar(Long id);
}
