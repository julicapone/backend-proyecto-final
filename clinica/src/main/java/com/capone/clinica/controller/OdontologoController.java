package com.capone.clinica.controller;

import com.capone.clinica.model.Odontologo;
import com.capone.clinica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/odontologos")
@CrossOrigin("*")
public class OdontologoController {
    @Autowired
    OdontologoService odontologoService;

    @PostMapping("/")
    public ResponseEntity<?> registrarOdontologo(@RequestBody Odontologo odontologo) {
        odontologoService.registrar(odontologo);
        return ResponseEntity.status(HttpStatus.OK).body("Odontólogo registrado.");
    }

    @GetMapping("/{id}")
    public Optional<Odontologo> traerOdontologo(@PathVariable Long id) throws Exception {
        return odontologoService.traerPorId(id);
    }

    @GetMapping("/")
    public ResponseEntity<List<Odontologo>> traerOdontologos(){
        return ResponseEntity.ok(odontologoService.traerTodos());
    }

    @PutMapping("/")
    public ResponseEntity<?> actualizarOdontologo(@RequestBody Odontologo odontologo) throws Exception {
        odontologoService.modificar(odontologo);
        return ResponseEntity.status(HttpStatus.OK).body("Odontólogo actualizado.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable Long id) {
        odontologoService.eliminar(id);
        return ResponseEntity.status(HttpStatus.OK).body("Odontólogo eliminado.");
    }
}
