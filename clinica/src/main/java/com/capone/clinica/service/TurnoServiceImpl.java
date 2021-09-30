package com.capone.clinica.service;

import com.capone.clinica.model.Turno;
import com.capone.clinica.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoServiceImpl implements TurnoService {
    @Autowired
    TurnoRepository turnoRepository;

    @Override
    public void registrar(Turno turno) {
        turnoRepository.save(turno);
    }

    @Override
    public Optional<Turno> traerPorId(Long id) {
        return turnoRepository.findById(id);
    }

    @Override
    public List<Turno> traerTodos() {
        return turnoRepository.findAll();
    }

    @Override
    public void modificar(Turno turno) {
        turnoRepository.save(turno);
    }

    @Override
    public void eliminar(Long id) {
        turnoRepository.deleteById(id);
    }
}
