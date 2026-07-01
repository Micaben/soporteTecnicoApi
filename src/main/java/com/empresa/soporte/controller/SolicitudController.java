package com.empresa.soporte.controller;

import com.empresa.soporte.model.Solicitud;
import com.empresa.soporte.service.SolicitudService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudController {

    private final SolicitudService service;

    public SolicitudController(
            SolicitudService service
    ) {
        this.service = service;
    }

    @GetMapping
    public List<Solicitud> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Solicitud buscar(
            @PathVariable Long id
    ) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Solicitud guardar(
            @Valid @RequestBody Solicitud solicitud
    ) {
        return service.guardar(solicitud);
    }

    @PutMapping("/{id}")
    public Solicitud actualizar(
            @PathVariable Long id,
            @Valid @RequestBody Solicitud solicitud
    ) {
        return service.actualizar(id, solicitud);
    }

    @DeleteMapping("/{id}")
    public void eliminar(
            @PathVariable Long id
    ) {
        service.eliminar(id);
    }
}