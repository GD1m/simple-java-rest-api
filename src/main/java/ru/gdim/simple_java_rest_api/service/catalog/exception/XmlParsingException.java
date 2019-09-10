package ru.gdim.simple_java_rest_api.service.catalog.exception;

import java.net.URL;

public final class XmlParsingException extends RuntimeException {
    public XmlParsingException(URL url, Throwable cause) {
        super("Failed to parse XML from url: " + url, cause);
    }
}
