package ru.gdim.simple_java_rest_api.service.catalog_parser.exception;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import lombok.Getter;

import java.net.URL;

@Getter
public final class UnexpectedXmlPropertyException extends RuntimeException {
    private final URL url;

    public UnexpectedXmlPropertyException(URL url, UnrecognizedPropertyException cause) {
        super("Error occurred while parsing XML from url " + url + " : " + cause.getMessage(), cause);

        this.url = url;
    }
}
