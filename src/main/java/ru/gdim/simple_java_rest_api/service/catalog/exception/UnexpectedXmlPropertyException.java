package ru.gdim.simple_java_rest_api.service.catalog.exception;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;

import java.net.URL;

public final class UnexpectedXmlPropertyException extends RuntimeException {
    public UnexpectedXmlPropertyException(URL url, UnrecognizedPropertyException cause) {
        super("Error occurred while parsing XML from url " + url + " : " + cause.getMessage(), cause);
    }
}
