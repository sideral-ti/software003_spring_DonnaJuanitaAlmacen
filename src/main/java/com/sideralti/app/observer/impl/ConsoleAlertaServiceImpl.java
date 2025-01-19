package com.sideralti.app.observer.impl;

import com.sideralti.app.model.entity.ProductoEntity;
import com.sideralti.app.observer.AlertaObserver;
import org.springframework.stereotype.Service;

@Service
public class ConsoleAlertaServiceImpl implements AlertaObserver {

    @Override
    public void notificarBajoStock(ProductoEntity producto) {
        System.out.println("ALERTA: El producto '" + producto.getNombre() + "' tiene un stock bajo (" + producto.getCantidadEnStock() + ").");
    }


}
