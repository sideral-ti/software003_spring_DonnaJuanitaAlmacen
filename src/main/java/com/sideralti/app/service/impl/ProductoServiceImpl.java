package com.sideralti.app.service.impl;

import com.sideralti.app.exceptions.ProductoNoEncontradoException;
import com.sideralti.app.exceptions.StockInsuficienteException;
import com.sideralti.app.model.entity.ProductoEntity;
import com.sideralti.app.repository.ProductoRepository;
import com.sideralti.app.observer.AlertaObserver;
import com.sideralti.app.service.ProductoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    private static final Logger logger = LoggerFactory.getLogger(ProductoServiceImpl.class);


    private final ProductoRepository productoRepository;
    private final List<AlertaObserver> observers = new ArrayList<>();

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public ProductoEntity crearProducto(ProductoEntity producto) {
        logger.info("Creando un nuevo producto: {}", producto.getNombre());
        ProductoEntity nuevoProducto = productoRepository.save(producto);
        logger.debug("Producto creado exitosamente: {}", nuevoProducto);
        return nuevoProducto;
    }

    @Override
    public ProductoEntity obtenerProductoPorId(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new ProductoNoEncontradoException("Producto no encontrado con ID: " + id));
    }

    @Override
    public List<ProductoEntity> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }

    @Override
    public ProductoEntity actualizarProducto(Long id, ProductoEntity producto) {
        logger.info("Actualizando producto con ID: {}", id);
        ProductoEntity productoExistente = productoRepository.findById(id)
                .orElseThrow(() -> new ProductoNoEncontradoException("Producto no encontrado con ID: " + id));
        logger.debug("Producto encontrado: {}", productoExistente);

        productoExistente.setNombre(producto.getNombre());
        productoExistente.setPrecio(producto.getPrecio());
        productoExistente.setCantidadEnStock(producto.getCantidadEnStock());
        productoExistente.setCategoria(producto.getCategoria());

        ProductoEntity productoActualizado = productoRepository.save(productoExistente);
        logger.info("Producto actualizado exitosamente: {}", productoActualizado);
        return productoActualizado;
    }

    @Override
    public void eliminarProducto(Long id) {
        logger.info("Eliminando producto con ID: {}", id);
        productoRepository.deleteById(id);
        logger.info("Producto con ID: {} eliminado exitosamente", id);
    }

    @Override
    public void registrarObservador(AlertaObserver observer) {
        observers.add(observer);
    }

    @Override
    public void notificarObservadores(ProductoEntity producto) {
        for (AlertaObserver observer : observers) {
            observer.notificarBajoStock(producto);
        }
    }

    public void validarStock(ProductoEntity producto, int cantidadSolicitada) {
        if (producto.getCantidadEnStock() < cantidadSolicitada) {
            throw new StockInsuficienteException("Stock insuficiente para el producto: " + producto.getNombre());
        }
    }

}
