package com.sideralti.app.controller_rest;

import com.sideralti.app.service.ProductoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/productos")
@RequiredArgsConstructor
@Slf4j
public class ProductosRestController {

    private final ProductoService productoService;
}
