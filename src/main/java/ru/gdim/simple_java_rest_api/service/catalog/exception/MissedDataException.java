package ru.gdim.simple_java_rest_api.service.catalog.exception;

import java.net.URL;

public final class MissedDataException extends RuntimeException {
    public MissedDataException(String message, URL url) {
        super(message + " (requested resource: " + url + ")");
    }
}
