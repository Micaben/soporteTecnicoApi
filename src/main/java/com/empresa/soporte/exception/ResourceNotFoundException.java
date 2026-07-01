package com.empresa.soporte.exception;

public class ResourceNotFoundException
        extends RuntimeException {

    public ResourceNotFoundException(String mensaje) {
        super(mensaje);
    }
}