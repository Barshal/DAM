package com.example.liga_trail_running.controller;

import com.example.liga_trail_running.model.Corredor;
import com.example.liga_trail_running.repository.CorredorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/corredores")
@CrossOrigin(origins = "*") // Para permitir llamadas desde tu front
public class CorredorController {

    private final CorredorRepository repo;

    public CorredorController(CorredorRepository repo) {
        this.repo = repo;
    }

    // Obtener todos los corredores
    @GetMapping
    public List<Corredor> getAll() {
        return repo.findAll();
    }

    // Obtener un corredor por ID
    @GetMapping("/{id}")
    public Corredor getById(@PathVariable Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Corredor no encontrado"));
    }

    // Crear un corredor
    @PostMapping
    public Corredor create(@RequestBody Corredor corredor) {
        return repo.save(corredor);
    }

    // Actualizar un corredor
    @PutMapping("/{id}")
    public Corredor update(@PathVariable Long id, @RequestBody Corredor corredor) {
        Corredor existente = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Corredor no encontrado"));

        existente.setNombre(corredor.getNombre());
        existente.setDni(corredor.getDni());
        existente.setEdad(corredor.getEdad());
        existente.setClub(corredor.getClub());

        return repo.save(existente);
    }

    // Eliminar un corredor
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
