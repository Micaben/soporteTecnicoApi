package com.empresa.soporte.service;

import com.empresa.soporte.model.Cliente;
import java.util.List;

public interface ClienteService {

    List<Cliente> listar();

    Cliente buscarPorId(Long id);

    Cliente guardar(Cliente cliente);

    void eliminar(Long id);
}
