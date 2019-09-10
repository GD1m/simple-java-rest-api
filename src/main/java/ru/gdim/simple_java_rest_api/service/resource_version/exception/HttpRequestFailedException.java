package ru.gdim.simple_java_rest_api.service.resource_version.exception;

public final class HttpRequestFailedException extends RuntimeException {
    public HttpRequestFailedException(String message) {
        super(message);
    }

    public HttpRequestFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
