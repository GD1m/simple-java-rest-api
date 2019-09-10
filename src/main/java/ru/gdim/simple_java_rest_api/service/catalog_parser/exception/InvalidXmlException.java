package ru.gdim.simple_java_rest_api.service.catalog_parser.exception;

import lombok.Getter;

import java.net.URL;

@Getter
public final class InvalidXmlException extends RuntimeException {
    private final URL url;

    public InvalidXmlException(URL url, Throwable cause) {
        super("Invalid XML got by url: " + url, cause);

        this.url = url;
    }
}
