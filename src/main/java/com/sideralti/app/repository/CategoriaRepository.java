package com.sideralti.app.repository;

import com.sideralti.app.model.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {

    // Consultas personalizadas con @Query

    @Query("SELECT c FROM CategoriaEntity c WHERE c.nombre LIKE %:nombre%")
    List<CategoriaEntity> buscarPorNombre(@Param("nombre") String nombre);

    @Query("SELECT c FROM CategoriaEntity c WHERE c.descripcion LIKE %:descripcion%")
    List<CategoriaEntity> buscarPorDescripcion(@Param("descripcion") String descripcion);

//    @Query("SELECT c FROM CategoriaEntity c WHERE c.productos.size > :cantidad")
//    List<CategoriaEntity> buscarCategoriasConProductosMayorA(@Param("cantidad") Integer cantidad);

    @Query("SELECT c FROM CategoriaEntity c ORDER BY c.nombre ASC")
    List<CategoriaEntity> buscarCategoriasOrdenadasPorNombre();

    @Query("SELECT c FROM CategoriaEntity c WHERE c.id = :id")
    CategoriaEntity buscarCategoriaPorId(@Param("id") Long id);
}