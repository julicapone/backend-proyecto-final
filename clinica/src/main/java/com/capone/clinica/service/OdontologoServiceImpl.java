package com.capone.clinica.service;

import com.capone.clinica.model.Odontologo;
import com.capone.clinica.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoServiceImpl implements OdontologoService {

    @Autowired
    OdontologoRepository odontologoRepository;

    @Override
    public void registrar(Odontologo odontologo) {
        odontologoRepository.save(odontologo);
    }

    @Override
    public Optional<Odontologo> traerPorId(Long id) throws Exception {
        Optional<Odontologo> odontologoEncontrado = odontologoRepository.findById(id);
        if(odontologoEncontrado.isPresent()) {
            return odontologoEncontrado;
        } else {
            throw new Exception("No existe un odontólogo con ese id.");
        }
    }

    @Override
    public List<Odontologo> traerTodos() {
        return odontologoRepository.findAll();
    }

    @Override
    public void modificar(Odontologo odontologo) {
        odontologoRepository.save(odontologo);
    }

    @Override
    public void eliminar(Long id) {
        odontologoRepository.deleteById(id);
    }
}
