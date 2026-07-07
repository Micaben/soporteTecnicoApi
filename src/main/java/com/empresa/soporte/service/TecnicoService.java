package com.empresa.soporte.service;

import com.empresa.soporte.model.Tecnico;
import java.util.List;

public interface TecnicoService {

    List<Tecnico> listar();

    Tecnico buscarPorId(Long id);

    Tecnico guardar(Tecnico tecnico);

    void eliminar(Long id);
}
