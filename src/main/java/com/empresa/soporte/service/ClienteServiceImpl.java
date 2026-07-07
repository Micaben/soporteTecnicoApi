package com.empresa.soporte.service;

import com.empresa.soporte.exception.ResourceNotFoundException;
import com.empresa.soporte.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final Map<Long, Cliente> clientes =
            new HashMap<>();

    @Override
    public List<Cliente> listar() {
        return new ArrayList<>(clientes.values());
    }

    @Override
    public Cliente buscarPorId(Long id) {

        Cliente cliente = clientes.get(id);

        if(cliente == null){
            throw new ResourceNotFoundException(
                    "Cliente no encontrado"
            );
        }

        return cliente;
    }

    @Override
    public Cliente guardar(Cliente cliente) {

        clientes.put(
                cliente.getId(),
                cliente
        );

        return cliente;
    }

    @Override
    public void eliminar(Long id) {

        buscarPorId(id);

        clientes.remove(id);
    }
}
