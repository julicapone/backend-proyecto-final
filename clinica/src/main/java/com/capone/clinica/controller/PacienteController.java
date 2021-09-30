package com.capone.clinica.controller;

import com.capone.clinica.model.Paciente;
import com.capone.clinica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/pacientes")
@CrossOrigin("*")
public class PacienteController {
    @Autowired
    PacienteService pacienteService;

    @PostMapping("/")
    public ResponseEntity<?> registrarPaciente(@RequestBody Paciente paciente) {
        pacienteService.registrar(paciente);
        return ResponseEntity.status(HttpStatus.OK).body("Paciente registrado.");
    }

    @GetMapping("/{id}")
    public Optional<Paciente> traerPaciente(@PathVariable Long id) throws Exception {
        return pacienteService.traerPorId(id);
    }

    @GetMapping("/")
    public ResponseEntity<List<Paciente>> traerPacientes(){
        return ResponseEntity.ok(pacienteService.traerTodos());
    }

    @PutMapping("/")
    public ResponseEntity<?> actualizarPaciente(@RequestBody Paciente paciente) throws Exception {
        pacienteService.modificar(paciente);
        return ResponseEntity.status(HttpStatus.OK).body("Paciente actualizado.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Long id) {
        pacienteService.eliminar(id);
        return ResponseEntity.status(HttpStatus.OK).body("Paciente eliminado.");
    }
}
