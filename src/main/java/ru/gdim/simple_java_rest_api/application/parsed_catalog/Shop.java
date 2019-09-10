package ru.gdim.simple_java_rest_api.application.parsed_catalog;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public final class Shop implements Serializable {
    private String name;
    private String company;
    private String url;
    private List<Currency> currencies;
    private List<Category> categories;
    @JacksonXmlProperty(localName = "delivery-options")
    private List<DeliveryOption> deliveryOptions;
    private List<Offer> offers;
}
