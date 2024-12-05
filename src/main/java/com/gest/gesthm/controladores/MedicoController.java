package com.gest.gesthm.controladores;

import com.gest.gesthm.entity.Medico;
import com.gest.gesthm.servicios.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public List<Medico> getAllMedicos() {
        return medicoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> getMedicoById(@PathVariable Long id) {
        return medicoService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Medico createMedico(@RequestBody Medico medico) {
        return medicoService.save(medico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medico> updateMedico(@PathVariable Long id, @RequestBody Medico medicoDetails) {
        return medicoService.findById(id)
                .map(medico -> {
                    medico.setNombre(medicoDetails.getNombre());
                    medico.setApellido(medicoDetails.getApellido());
                    medico.setEspecialidad(medicoDetails.getEspecialidad());
                    medico.setEmail(medicoDetails.getEmail());
                    medico.setTelefono(medicoDetails.getTelefono());
                    return ResponseEntity.ok(medicoService.save(medico));
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedico(@PathVariable Long id) {
        return medicoService.findById(id)
                .map(medico -> {
                    medicoService.delete(id);
                    return ResponseEntity.ok().<Void>build();
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
