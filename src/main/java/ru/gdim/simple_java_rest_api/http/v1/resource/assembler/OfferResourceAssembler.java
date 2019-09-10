package ru.gdim.simple_java_rest_api.http.v1.resource.assembler;

import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;
import ru.gdim.simple_java_rest_api.application.parsed_catalog.Offer;
import ru.gdim.simple_java_rest_api.http.v1.resource.OfferResource;

@Component
public final class OfferResourceAssembler implements ResourceAssembler<Offer, OfferResource> {
    @Override
    public OfferResource toResource(Offer offer) {
        return new OfferResource(offer);
    }
}
