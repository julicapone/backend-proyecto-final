package com.capone.clinica.service;

import com.capone.clinica.model.Paciente;
import com.capone.clinica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService {
    @Autowired
    PacienteRepository pacienteRepository;

    @Override
    public void registrar(Paciente paciente) {
        pacienteRepository.save(paciente);
    }

    @Override
    public Optional<Paciente> traerPorId(Long id) {
        return pacienteRepository.findById(id);
    }

    @Override
    public List<Paciente> traerTodos() {
        return pacienteRepository.findAll();
    }

    @Override
    public void modificar(Paciente paciente) {
        pacienteRepository.save(paciente);
    }

    @Override
    public void eliminar(Long id) {
        pacienteRepository.deleteById(id);
    }
}
