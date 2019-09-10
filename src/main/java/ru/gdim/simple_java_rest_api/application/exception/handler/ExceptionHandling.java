package ru.gdim.simple_java_rest_api.application.exception.handler;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.NativeWebRequest;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;
import org.zalando.problem.spring.web.advice.ProblemHandling;
import ru.gdim.simple_java_rest_api.service.catalog.exception.*;
import ru.gdim.simple_java_rest_api.service.resource_version.exception.HttpRequestFailedException;

@SuppressWarnings("unused")
@ControllerAdvice
public final class ExceptionHandling implements ProblemHandling {
    @ExceptionHandler(value = InvalidXmlException.class)
    protected ResponseEntity<Problem> invalidXml(Throwable e, NativeWebRequest request) {
        Problem problem = Problem.valueOf(Status.BAD_REQUEST, "An invalid data format was received." +
                " Failed to parse data as XML. Please verify that the requested resource returns valid XML.");

        return create(e, problem, request);
    }

    @ExceptionHandler(value = MissedDataException.class)
    protected ResponseEntity<Problem> missedData(Throwable e, NativeWebRequest request) {
        Problem problem = Problem.valueOf(Status.CONFLICT, e.getMessage());

        return create(e, problem, request);
    }

    @ExceptionHandler(value = NotFoundException.class)
    protected ResponseEntity<Problem> notFound(Throwable e, NativeWebRequest request) {
        Problem problem = Problem.valueOf(Status.BAD_REQUEST, "Requested resource not found");

        return create(e, problem, request);
    }

    @ExceptionHandler(value = UnexpectedXmlPropertyException.class)
    protected ResponseEntity<Problem> unexpectedXmlProperty(@NotNull Throwable e, NativeWebRequest request) {
        Problem problem = Problem.valueOf(Status.CONFLICT, e.getMessage());

        return create(e, problem, request);
    }

    @ExceptionHandler(value = XmlParsingException.class)
    protected ResponseEntity<Problem> xmlParsingFailed(@NotNull Throwable e, NativeWebRequest request) {
        Problem problem = Problem.valueOf(Status.INTERNAL_SERVER_ERROR, "Something went wrong while parsing XML");

        return create(e, problem, request);
    }

    @ExceptionHandler(value = HttpRequestFailedException.class)
    protected ResponseEntity<Problem> httpRequestFailed(@NotNull Throwable e, NativeWebRequest request) {
        Problem problem = Problem.valueOf(Status.BAD_REQUEST, e.getMessage());

        return create(e, problem, request);
    }
}
