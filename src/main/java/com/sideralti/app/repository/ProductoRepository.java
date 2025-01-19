package com.sideralti.app.repository;

import com.sideralti.app.model.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {

    // Consultas personalizadas con @Query

    @Query("SELECT p FROM ProductoEntity p WHERE p.nombre LIKE %:nombre%")
    List<ProductoEntity> buscarPorNombre(@Param("nombre") String nombre);

    @Query("SELECT p FROM ProductoEntity p WHERE p.precio > :precio")
    List<ProductoEntity> buscarProductosPorPrecioMayorA(@Param("precio") Double precio);

    @Query("SELECT p FROM ProductoEntity p WHERE p.cantidadEnStock < :cantidad")
    List<ProductoEntity> buscarProductosConStockBajo(@Param("cantidad") Integer cantidad);

    @Query("SELECT p FROM ProductoEntity p WHERE p.categoria.id = :categoriaId")
    List<ProductoEntity> buscarPorCategoria(@Param("categoriaId") Long categoriaId);

    @Query("SELECT p FROM ProductoEntity p ORDER BY p.precio DESC")
    List<ProductoEntity> buscarProductosOrdenadosPorPrecioDesc();
}