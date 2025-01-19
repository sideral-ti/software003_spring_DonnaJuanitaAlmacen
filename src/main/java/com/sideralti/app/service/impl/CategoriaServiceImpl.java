package com.sideralti.app.service.impl;

import com.sideralti.app.model.entity.CategoriaEntity;
import com.sideralti.app.repository.CategoriaRepository;
import com.sideralti.app.service.CategoriaService;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private static final Logger logger = LoggerFactory.getLogger(CategoriaServiceImpl.class);

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public CategoriaEntity crearCategoria(CategoriaEntity categoria) {
        logger.info("Creando una nueva categoría: {}", categoria.getNombre());
        CategoriaEntity nuevaCategoria = categoriaRepository.save(categoria);
        logger.debug("Categoría creada exitosamente: {}", nuevaCategoria);
        return nuevaCategoria;
    }
    @Override
    public CategoriaEntity obtenerCategoriaPorId(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Categoría no encontrada con ID: " + id));
    }

    @Override
    public List<CategoriaEntity> obtenerTodasLasCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public CategoriaEntity actualizarCategoria(Long id, CategoriaEntity categoria) {
        CategoriaEntity categoriaExistente = obtenerCategoriaPorId(id);
        categoriaExistente.setNombre(categoria.getNombre());
        categoriaExistente.setDescripcion(categoria.getDescripcion());
        return categoriaRepository.save(categoriaExistente);
    }

    @Override
    public void eliminarCategoria(Long id) {
        logger.info("Eliminando categoría con ID: {}", id);
        categoriaRepository.deleteById(id);
        logger.info("Categoría con ID: {} eliminada exitosamente", id);
    }
}
