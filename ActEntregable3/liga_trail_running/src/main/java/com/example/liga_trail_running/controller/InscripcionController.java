package com.example.liga_trail_running.controller;

import com.example.liga_trail_running.model.Carrera;
import com.example.liga_trail_running.model.Corredor;
import com.example.liga_trail_running.model.Inscripcion;
import com.example.liga_trail_running.repository.CarreraRepository;
import com.example.liga_trail_running.repository.CorredorRepository;
import com.example.liga_trail_running.repository.InscripcionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/inscripciones")

public class InscripcionController {

    private final InscripcionRepository repo;
    private final CorredorRepository corredorRepo;
    private final CarreraRepository carreraRepo;

    public InscripcionController(InscripcionRepository repo,
                                 CorredorRepository corredorRepo,
                                 CarreraRepository carreraRepo) {
        this.repo = repo;
        this.corredorRepo = corredorRepo;
        this.carreraRepo = carreraRepo;
    }

    @GetMapping
    public List<Inscripcion> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Inscripcion getById(@PathVariable Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Inscripción no encontrada"));
    }

    @PostMapping
    public Inscripcion create(@RequestBody Inscripcion inscripcion) {

        // Validar corredor
        Corredor corredor = corredorRepo.findById(inscripcion.getCorredor().getId())
                .orElseThrow(() -> new RuntimeException("Corredor no encontrado"));

        // Validar carrera
        Carrera carrera = carreraRepo.findById(inscripcion.getCarrera().getId())
                .orElseThrow(() -> new RuntimeException("Carrera no encontrada"));

        inscripcion.setCorredor(corredor);
        inscripcion.setCarrera(carrera);

        return repo.save(inscripcion);
    }

    @PutMapping("/{id}")
    public Inscripcion update(@PathVariable Long id, @RequestBody Inscripcion inscripcion) {

        Inscripcion existente = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Inscripción no encontrada"));

        existente.setDorsal(inscripcion.getDorsal());
        existente.setTiempoOficial(inscripcion.getTiempoOficial());

        // Validar corredor
        Corredor corredor = corredorRepo.findById(inscripcion.getCorredor().getId())
                .orElseThrow(() -> new RuntimeException("Corredor no encontrado"));

        // Validar carrera
        Carrera carrera = carreraRepo.findById(inscripcion.getCarrera().getId())
                .orElseThrow(() -> new RuntimeException("Carrera no encontrada"));

        existente.setCorredor(corredor);
        existente.setCarrera(carrera);

        return repo.save(existente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}

