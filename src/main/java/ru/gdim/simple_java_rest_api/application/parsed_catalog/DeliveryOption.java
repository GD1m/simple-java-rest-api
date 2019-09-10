package ru.gdim.simple_java_rest_api.application.parsed_catalog;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@ToString
final class DeliveryOption implements Serializable {
    private Integer cost;
    private Integer days;
    @JacksonXmlProperty(localName = "order-before")
    private Integer orderBefore;
}
