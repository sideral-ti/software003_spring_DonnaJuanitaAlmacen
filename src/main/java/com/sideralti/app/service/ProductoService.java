package com.sideralti.app.service;

import com.sideralti.app.model.entity.ProductoEntity;
import com.sideralti.app.observer.AlertaObserver;

import java.util.List;

public interface ProductoService {
    ProductoEntity crearProducto(ProductoEntity producto);
    ProductoEntity obtenerProductoPorId(Long id);
    List<ProductoEntity> obtenerTodosLosProductos();
    ProductoEntity actualizarProducto(Long id, ProductoEntity producto);
    void eliminarProducto(Long id);

    void registrarObservador(AlertaObserver observer);
    void notificarObservadores(ProductoEntity producto);
}
