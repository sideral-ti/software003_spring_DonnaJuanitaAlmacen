package com.sideralti.app.controller_rest;

import com.sideralti.app.model.entity.CategoriaEntity;
import com.sideralti.app.service.CategoriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/categorias")
@RequiredArgsConstructor
@Slf4j
public class CategoriasRestController {

    private final CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaEntity>> findAll() {
        log.info("REST request para obtener todos los combos");
        return ResponseEntity.ok(categoriaService.obtenerTodasLasCategorias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaEntity> findById(@PathVariable Long id) {
        log.info("REST request para obtener combo por ID: {}", id);
        return ResponseEntity.ok(categoriaService.obtenerCategoriaPorId(id));
    }

    @PostMapping
    public ResponseEntity<CategoriaEntity> save(@Valid @RequestBody CategoriaEntity comboDTO) {
        log.info("REST request para crear nuevo combo");
        CategoriaEntity result = categoriaService.crearCategoria(comboDTO);
        return ResponseEntity
                .created(URI.create("/rest/combos/" + result.getId()))
                .body(result);
    }

//    @PostMapping("/bulk")
//    public ResponseEntity<List<CategoriaEntity>> saveAll(@Valid @RequestBody List<CategoriaEntity> combosDTO) {
//        log.info("REST request para crear múltiples combos");
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(categoriaService.saveAll(combosDTO));
//    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaEntity> update(
            @PathVariable Long id,
            @Valid @RequestBody CategoriaEntity comboDTO) {
        log.info("REST request para actualizar combo por ID: {}", id);
        return ResponseEntity.ok(categoriaService.actualizarCategoria(id, comboDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        log.info("REST request para eliminar combo por ID: {}", id);
        categoriaService.eliminarCategoria(id);
        return ResponseEntity.noContent().build();
    }
}
