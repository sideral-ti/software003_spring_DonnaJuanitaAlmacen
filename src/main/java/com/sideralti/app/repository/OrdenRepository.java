package com.sideralti.app.repository;

import com.sideralti.app.model.entity.OrdenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrdenRepository extends JpaRepository<OrdenEntity, Long> {

    // Consultas personalizadas con @Query

    @Query("SELECT o FROM OrdenEntity o WHERE o.fecha = :fecha")
    List<OrdenEntity> buscarPorFecha(@Param("fecha") LocalDate fecha);

    @Query("SELECT o FROM OrdenEntity o WHERE o.estado = :estado")
    List<OrdenEntity> buscarPorEstado(@Param("estado") String estado);

//    @Query("SELECT o FROM OrdenEntity o WHERE o.listaProductos.size > :cantidad")
//    List<OrdenEntity> buscarOrdenesConProductosMayorA(@Param("cantidad") Integer cantidad);

    @Query("SELECT o FROM OrdenEntity o JOIN o.listaProductos p WHERE p.id = :productoId")
    List<OrdenEntity> buscarOrdenesPorProducto(@Param("productoId") Long productoId);

    @Query("SELECT o FROM OrdenEntity o ORDER BY o.fecha DESC")
    List<OrdenEntity> buscarOrdenesOrdenadasPorFechaDesc();
}