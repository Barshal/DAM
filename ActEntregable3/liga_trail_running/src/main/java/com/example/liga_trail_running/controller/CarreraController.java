package com.example.liga_trail_running.controller;

import com.example.liga_trail_running.model.Carrera;
import com.example.liga_trail_running.repository.CarreraRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/carreras")
public class CarreraController {

    private final CarreraRepository repo;

    public CarreraController(CarreraRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Carrera> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Carrera getById(@PathVariable Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrera no encontrada"));
    }

    @PostMapping
    public Carrera create(@RequestBody Carrera carrera) {
        return repo.save(carrera);
    }

    @PutMapping("/{id}")
    public Carrera update(@PathVariable Long id, @RequestBody Carrera carrera) {
        Carrera existente = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrera no encontrada"));

        existente.setNombre(carrera.getNombre());
        existente.setUbicacion(carrera.getUbicacion());
        existente.setDistanciaKm(carrera.getDistanciaKm());
        existente.setFecha(carrera.getFecha());

        return repo.save(existente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
