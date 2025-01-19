package com.sideralti.app.observer.impl;

import com.sideralti.app.model.entity.ProductoEntity;
import com.sideralti.app.observer.AlertaObserver;
import org.springframework.stereotype.Service;

@Service
public class EmailAlertaServiceImpl implements AlertaObserver {

    @Override
    public void notificarBajoStock(ProductoEntity producto) {
        System.out.println("ALERTA: El producto '" + producto.getNombre() + "' está bajo en stock. Se ha enviado un correo electrónico.");
    }
}
