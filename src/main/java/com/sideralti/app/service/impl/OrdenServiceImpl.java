package com.sideralti.app.service.impl;

import com.sideralti.app.model.entity.OrdenEntity;
import com.sideralti.app.repository.OrdenRepository;
import com.sideralti.app.service.OrdenService;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenServiceImpl implements OrdenService {

    private static final Logger logger = LoggerFactory.getLogger(OrdenServiceImpl.class);


    private final OrdenRepository ordenRepository;

    public OrdenServiceImpl(OrdenRepository ordenRepository) {
        this.ordenRepository = ordenRepository;
    }

    @Override
    public OrdenEntity crearOrden(OrdenEntity orden) {
        logger.info("Creando una nueva orden de reposición con fecha: {}", orden.getFecha());
        OrdenEntity nuevaOrden = ordenRepository.save(orden);
        logger.debug("Orden creada exitosamente: {}", nuevaOrden);
        return nuevaOrden;
    }
    @Override
    public OrdenEntity obtenerOrdenPorId(Long id) {
        return ordenRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Orden no encontrada con ID: " + id));
    }

    @Override
    public List<OrdenEntity> obtenerTodasLasOrdenes() {
        return ordenRepository.findAll();
    }

    @Override
    public OrdenEntity actualizarOrden(Long id, OrdenEntity orden) {
        OrdenEntity ordenExistente = obtenerOrdenPorId(id);
        ordenExistente.setListaProductos(orden.getListaProductos());
        ordenExistente.setFecha(orden.getFecha());
        ordenExistente.setEstado(orden.getEstado());
        return ordenRepository.save(ordenExistente);
    }

    @Override
    public void eliminarOrden(Long id) {
        ordenRepository.deleteById(id);
    }

    @Override
    public OrdenEntity actualizarEstadoOrden(Long id, String nuevoEstado) {
        logger.info("Actualizando el estado de la orden con ID: {}", id);
        OrdenEntity ordenExistente = ordenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Orden no encontrada con ID: " + id));
        logger.debug("Orden encontrada: {}", ordenExistente);

        ordenExistente.setEstado(nuevoEstado);
        OrdenEntity ordenActualizada = ordenRepository.save(ordenExistente);
        logger.info("Estado de la orden con ID: {} actualizado a {}", id, nuevoEstado);
        return ordenActualizada;
    }
}
