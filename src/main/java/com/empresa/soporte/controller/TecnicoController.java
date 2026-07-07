package com.empresa.soporte.controller;

import com.empresa.soporte.model.Tecnico;
import com.empresa.soporte.service.TecnicoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tecnicos")
public class TecnicoController {

    private final TecnicoService service;

    public TecnicoController(
            TecnicoService service
    ) {
        this.service = service;
    }

    @GetMapping
    public List<Tecnico> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Tecnico buscar(
            @PathVariable Long id
    ) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Tecnico guardar(
            @Valid @RequestBody Tecnico tecnico
    ) {
        return service.guardar(tecnico);
    }

    @DeleteMapping("/{id}")
    public void eliminar(
            @PathVariable Long id
    ) {
        service.eliminar(id);
    }
}
