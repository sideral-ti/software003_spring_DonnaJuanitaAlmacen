package com.sideralti.app.service;

import com.sideralti.app.model.entity.CategoriaEntity;

import java.util.List;

public interface CategoriaService {
    CategoriaEntity crearCategoria(CategoriaEntity categoria);
    CategoriaEntity obtenerCategoriaPorId(Long id);
    List<CategoriaEntity> obtenerTodasLasCategorias();
    CategoriaEntity actualizarCategoria(Long id, CategoriaEntity categoria);
    void eliminarCategoria(Long id);
}
