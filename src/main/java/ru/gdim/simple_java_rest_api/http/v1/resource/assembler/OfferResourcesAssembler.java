package ru.gdim.simple_java_rest_api.http.v1.resource.assembler;

import org.springframework.hateoas.ResourceAssembler;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Component;
import ru.gdim.simple_java_rest_api.application.parsed_catalog.Offer;
import ru.gdim.simple_java_rest_api.http.v1.resource.OfferResource;

import java.util.List;
import java.util.stream.Collectors;

@Component
public final class OfferResourcesAssembler
        implements ResourceAssembler<List<Offer>, Resources<OfferResource>> {
    private final OfferResourceAssembler offerResourceAssembler;

    public OfferResourcesAssembler(OfferResourceAssembler offerResourceAssembler) {
        this.offerResourceAssembler = offerResourceAssembler;
    }

    @Override
    public Resources<OfferResource> toResource(List<Offer> entities) {
        List<OfferResource> vendorOffersResources = entities
                .stream()
                .map(offerResourceAssembler::toResource)
                .collect(Collectors.toList());

        return new Resources<>(vendorOffersResources);
    }
}
