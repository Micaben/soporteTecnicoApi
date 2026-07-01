package com.empresa.soporte.service;

import com.empresa.soporte.exception.ResourceNotFoundException;
import com.empresa.soporte.model.Solicitud;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SolicitudServiceImpl implements SolicitudService {

    private final Map<Long, Solicitud> solicitudes = new HashMap<>();

    private Long contador = 1L;

    @Override
    public List<Solicitud> listar() {
        return new ArrayList<>(solicitudes.values());
    }

    @Override
    public Solicitud buscarPorId(Long id) {
        Solicitud solicitud = solicitudes.get(id);

        if (solicitud == null) {
            throw new ResourceNotFoundException(
                    "Solicitud no encontrada con id " + id
            );
        }

        return solicitud;
    }

    @Override
    public Solicitud guardar(Solicitud solicitud) {

        solicitud.setId(contador++);
        solicitud.setEstado("Pendiente");

        solicitudes.put(
                solicitud.getId(),
                solicitud
        );

        return solicitud;
    }

    @Override
    public Solicitud actualizar(Long id, Solicitud solicitud) {

        buscarPorId(id);

        solicitud.setId(id);

        solicitudes.put(id, solicitud);

        return solicitud;
    }

    @Override
    public void eliminar(Long id) {

        buscarPorId(id);

        solicitudes.remove(id);
    }
}