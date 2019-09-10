package ru.gdim.simple_java_rest_api.service.catalog_parser.exception;

import lombok.Getter;

import java.net.URL;

@Getter
public final class MissedDataException extends RuntimeException {
    private final URL url;

    public MissedDataException(String message, URL url) {
        super(message + " (requested resource: " + url + ")");

        this.url = url;
    }
}
