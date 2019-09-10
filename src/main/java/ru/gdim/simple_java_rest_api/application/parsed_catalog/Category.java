package ru.gdim.simple_java_rest_api.application.parsed_catalog;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@ToString
final class Category implements Serializable {
    private Integer id;
    private Integer parentId;
    @JacksonXmlText
    private String name;
}
