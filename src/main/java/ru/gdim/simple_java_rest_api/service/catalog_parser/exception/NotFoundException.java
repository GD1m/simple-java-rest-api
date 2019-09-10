package ru.gdim.simple_java_rest_api.service.catalog_parser.exception;

import lombok.Getter;

import java.net.URL;

@Getter
public final class NotFoundException extends RuntimeException {
    private final URL url;

    public NotFoundException(URL url) {
        super("Requested resource not found: " + url);

        this.url = url;
    }

    public NotFoundException(URL url, Throwable cause) {
        super("Requested resource not found: " + url, cause);

        this.url = url;
    }
}
