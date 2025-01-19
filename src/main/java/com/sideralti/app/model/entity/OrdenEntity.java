package com.sideralti.app.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "ordenes")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "orden_producto",
            joinColumns = @JoinColumn(name = "orden_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    private List<ProductoEntity> listaProductos;

    @NotNull(message = "La fecha no puede estar vacía")
    @Column(nullable = false)
    private LocalDate fecha;

    @NotNull(message = "El estado no puede estar vacío")
    @Size(min = 3, max = 20, message = "El estado debe tener entre 3 y 20 caracteres")
    @Column(nullable = false, length = 20)
    private String estado;
}
