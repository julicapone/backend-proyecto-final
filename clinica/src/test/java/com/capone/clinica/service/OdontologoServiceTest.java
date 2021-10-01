package com.capone.clinica.service;

import com.capone.clinica.model.Odontologo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OdontologoServiceTest {

    @Autowired
    OdontologoService odontologoService;

    @Test
    void registrar() {
        Odontologo odontologo = new Odontologo();
        odontologo.setApellido("Sieiro");
        odontologo.setNombre("Nicolás");
        odontologo.setMatricula("A45");

        odontologoService.registrar(odontologo);

        List<Odontologo> odontologosApellido = odontologoService.traerPorApellido("Sieiro");
        boolean rta = odontologosApellido.size() > 0;
        assertTrue(rta);
    }

    @Test
    void traerPorId() {
    }
}