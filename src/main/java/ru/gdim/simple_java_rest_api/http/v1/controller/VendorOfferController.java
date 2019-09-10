package ru.gdim.simple_java_rest_api.http.v1.controller;

import org.jetbrains.annotations.NotNull;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gdim.simple_java_rest_api.application.parsed_catalog.Catalog;
import ru.gdim.simple_java_rest_api.application.parsed_catalog.Offer;
import ru.gdim.simple_java_rest_api.application.repository.CatalogRepository;
import ru.gdim.simple_java_rest_api.http.v1.request.GetVendorOffersRequest;
import ru.gdim.simple_java_rest_api.http.v1.resource.OfferResource;
import ru.gdim.simple_java_rest_api.http.v1.resource.assembler.OfferResourcesAssembler;
import ru.gdim.simple_java_rest_api.service.offer.OfferService;

import javax.validation.Valid;
import java.net.URL;
import java.util.List;

@RestController
@RequestMapping(path = "/v1/vendor-offers")
public class VendorOfferController {
    private final CatalogRepository catalogRepository;
    private final OfferService offerService;
    private final OfferResourcesAssembler offerResourcesAssembler;

    public VendorOfferController(
            CatalogRepository catalogRepository,
            OfferService offerService,
            OfferResourcesAssembler offerResourcesAssembler
    ) {
        this.catalogRepository = catalogRepository;
        this.offerService = offerService;
        this.offerResourcesAssembler = offerResourcesAssembler;
    }

    @PostMapping
    public ResponseEntity<Resources<OfferResource>> index(@Valid @RequestBody GetVendorOffersRequest request) {
        URL url = getUrlParam(request.getUrl());

        Catalog catalog = catalogRepository.findByUrl(url);

        List<Offer> vendorOffers = offerService.findByVendorName(
                catalog.getShop().getOffers(), request.getVendor());

        return ResponseEntity.ok(
                offerResourcesAssembler.toResource(vendorOffers));
    }

    @NotNull
    private URL getUrlParam(String url) {
        try {
            return new URL(url);
        } catch (Throwable e) {
            throw new RuntimeException("Failed to create URL from given string: " + url);
        }
    }
}
