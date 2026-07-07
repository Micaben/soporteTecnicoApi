package com.empresa.soporte.service;

import com.empresa.soporte.exception.ResourceNotFoundException;
import com.empresa.soporte.model.Tecnico;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TecnicoServiceImpl implements TecnicoService {

    private final Map<Long, Tecnico> tecnicos =
            new HashMap<>();

    @Override
    public List<Tecnico> listar() {
        return new ArrayList<>(tecnicos.values());
    }

    @Override
    public Tecnico buscarPorId(Long id) {

        Tecnico tecnico = tecnicos.get(id);

        if(tecnico == null){
            throw new ResourceNotFoundException(
                    "Tecnico no encontrado"
            );
        }

        return tecnico;
    }

    @Override
    public Tecnico guardar(Tecnico tecnico) {

        tecnicos.put(
                tecnico.getId(),
                tecnico
        );

        return tecnico;
    }

    @Override
    public void eliminar(Long id) {

        buscarPorId(id);

        tecnicos.remove(id);
    }
}