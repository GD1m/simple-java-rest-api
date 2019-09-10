package ru.gdim.simple_java_rest_api.application.parsed_catalog;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@JacksonXmlRootElement(localName = "yml_catalog")
public final class Catalog implements Serializable {
    private String date;
    @JacksonXmlProperty(localName = "shop")
    private Shop shop;
}
