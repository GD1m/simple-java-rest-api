package ru.gdim.simple_java_rest_api.application.parsed_catalog;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@ToString
final class Currency implements Serializable {
    private String id;
    private String rate;
}
