package com.sideralti.app.exceptions;

public class CategoriaNoEncontradaException extends RuntimeException {
    public CategoriaNoEncontradaException(String mensaje) {
        super(mensaje);
    }
}
