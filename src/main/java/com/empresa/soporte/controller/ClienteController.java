package com.empresa.soporte.controller;

import com.empresa.soporte.model.Cliente;
import com.empresa.soporte.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(
            ClienteService service
    ) {
        this.service = service;
    }

    @GetMapping
    public List<Cliente> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Cliente buscar(
            @PathVariable Long id
    ) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Cliente guardar(
            @Valid @RequestBody Cliente cliente
    ) {
        return service.guardar(cliente);
    }

    @DeleteMapping("/{id}")
    public void eliminar(
            @PathVariable Long id
    ) {
        service.eliminar(id);
    }
}
