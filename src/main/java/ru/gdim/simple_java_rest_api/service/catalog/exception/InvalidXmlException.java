package ru.gdim.simple_java_rest_api.service.catalog.exception;

import java.net.URL;

public final class InvalidXmlException extends RuntimeException {
    public InvalidXmlException(URL url, Throwable cause) {
        super("Invalid XML got by url: " + url, cause);
    }
}
