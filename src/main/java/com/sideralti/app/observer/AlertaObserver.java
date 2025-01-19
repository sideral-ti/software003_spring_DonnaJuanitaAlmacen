package com.sideralti.app.observer;

import com.sideralti.app.model.entity.ProductoEntity;

public interface AlertaObserver {
    void notificarBajoStock(ProductoEntity producto);
}
