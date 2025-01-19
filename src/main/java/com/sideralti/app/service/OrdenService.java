package com.sideralti.app.service;

import com.sideralti.app.model.entity.OrdenEntity;

import java.util.List;

public interface OrdenService {
    OrdenEntity crearOrden(OrdenEntity orden);
    OrdenEntity obtenerOrdenPorId(Long id);
    List<OrdenEntity> obtenerTodasLasOrdenes();
    OrdenEntity actualizarOrden(Long id, OrdenEntity orden);
    void eliminarOrden(Long id);

    OrdenEntity actualizarEstadoOrden(Long id, String nuevoEstado);
}
