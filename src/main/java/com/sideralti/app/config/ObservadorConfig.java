package com.sideralti.app.config;

import com.sideralti.app.service.ProductoService;
import com.sideralti.app.observer.impl.ConsoleAlertaServiceImpl;
import com.sideralti.app.observer.impl.EmailAlertaServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ObservadorConfig {

    public ObservadorConfig(ProductoService productoService,
                            ConsoleAlertaServiceImpl consoleAlertaService,
                            EmailAlertaServiceImpl emailAlertaService) {
        productoService.registrarObservador(consoleAlertaService);
        productoService.registrarObservador(emailAlertaService);
    }
}