package com.capone.clinica.service;

import com.capone.clinica.model.Odontologo;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface OdontologoService {
    void registrar(Odontologo odontologo);
    Optional<Odontologo> traerPorId(Long id) throws Exception;
    List<Odontologo> traerTodos();
    void modificar(Odontologo odontologo);
    void eliminar(Long id);
    public List<Odontologo> traerPorApellido(String apellido);
}
