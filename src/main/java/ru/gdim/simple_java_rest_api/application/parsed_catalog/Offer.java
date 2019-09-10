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
public final class Offer implements Serializable {
    private String id;
    private Boolean available;
    private String url;
    private Float price;
    @JacksonXmlProperty(localName = "oldprice")
    private Float oldPrice;
    private String currencyId;
    private Integer categoryId;
    @JacksonXmlProperty(localName = "market_category")
    private String marketCategory;
    private String picture;
    private Param param;
    private Float weight;
    private String vendor;
    private String vendorCode;
    private String name;
    private String description;
    @JacksonXmlProperty(localName = "sales_notes")
    private String salesNotes;
    @JacksonXmlProperty(localName = "country_of_origin")
    private String countryOfOrigin;
    private Boolean downloadable;
}
