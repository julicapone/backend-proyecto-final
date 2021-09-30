package com.capone.clinica.service;

import com.capone.clinica.model.Turno;

import java.util.List;
import java.util.Optional;

public interface TurnoService {
    void registrar(Turno turno);
    Optional<Turno> traerPorId(Long id);
    List<Turno> traerTodos();
    void modificar(Turno turno);
    void eliminar(Long id);
}
