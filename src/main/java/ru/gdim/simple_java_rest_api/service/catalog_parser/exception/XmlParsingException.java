package ru.gdim.simple_java_rest_api.service.catalog_parser.exception;

import lombok.Getter;

import java.net.URL;

@Getter
public final class XmlParsingException extends RuntimeException {
    private final URL url;

    public XmlParsingException(URL url, Throwable cause) {
        super("Failed to parse XML from url: " + url, cause);

        this.url = url;
    }
}
