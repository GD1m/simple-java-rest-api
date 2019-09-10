package ru.gdim.simple_java_rest_api.service.catalog.exception;

import java.net.URL;

public final class NotFoundException extends RuntimeException {
    public NotFoundException(URL url) {
        super("Requested resource not found: " + url);
    }

    public NotFoundException(URL url, Throwable cause) {
        super("Requested resource not found: " + url, cause);
    }
}
