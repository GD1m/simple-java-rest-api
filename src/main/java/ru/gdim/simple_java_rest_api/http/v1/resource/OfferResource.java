package ru.gdim.simple_java_rest_api.http.v1.resource;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.hateoas.ResourceSupport;
import ru.gdim.simple_java_rest_api.application.parsed_catalog.Offer;

import java.util.Objects;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString
public final class OfferResource extends ResourceSupport {
    private String entityId;
    private Boolean available;
    private String url;
    private Float price;
    private Float oldPrice;
    private String currencyId;
    private Integer categoryId;
    private String marketCategory;
    private String picture;
    private ParamResource param;
    private Float weight;
    private String vendor;
    private String vendorCode;
    private String name;
    private String description;
    private String salesNotes;
    private String countryOfOrigin;
    private Boolean downloadable;

    public OfferResource(Offer offer) {
        this.entityId = offer.getId();
        this.available = offer.getAvailable();
        this.url = offer.getUrl();
        this.price = offer.getPrice();
        this.oldPrice = offer.getOldPrice();
        this.currencyId = offer.getCurrencyId();
        this.categoryId = offer.getCategoryId();
        this.marketCategory = offer.getMarketCategory();
        this.picture = offer.getPicture();
        this.weight = offer.getWeight();
        this.vendor = offer.getVendor();
        this.vendorCode = offer.getVendorCode();
        this.name = offer.getName();
        this.description = offer.getDescription();
        this.salesNotes = offer.getSalesNotes();
        this.countryOfOrigin = offer.getCountryOfOrigin();
        this.downloadable = offer.getDownloadable();

        if (Objects.nonNull(offer.getParam())) {
            this.param = new ParamResource(offer.getParam());
        }
    }
}
