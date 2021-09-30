package com.capone.clinica.controller;

import com.capone.clinica.model.Turno;
import com.capone.clinica.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/turnos")
@CrossOrigin("*")
public class TurnoController {
    @Autowired
    TurnoService turnoService;

    @PostMapping("/")
    public ResponseEntity<?> registrarTurno(@RequestBody Turno turno) {
        turnoService.registrar(turno);
        return ResponseEntity.status(HttpStatus.OK).body("Turno registrado.");
    }

    @GetMapping("/{id}")
    public Optional<Turno> traerTurno(@PathVariable Long id) throws Exception {
        return turnoService.traerPorId(id);
    }

    @GetMapping("/")
    public ResponseEntity<List<Turno>> traerTurnos(){
        return ResponseEntity.ok(turnoService.traerTodos());
    }

    @PutMapping("/")
    public ResponseEntity<?> actualizarTurno(@RequestBody Turno turno) throws Exception {
        turnoService.modificar(turno);
        return ResponseEntity.status(HttpStatus.OK).body("Turno actualizado.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTurno(@PathVariable Long id) {
        turnoService.eliminar(id);
        return ResponseEntity.status(HttpStatus.OK).body("Turno eliminado.");
    }
}
