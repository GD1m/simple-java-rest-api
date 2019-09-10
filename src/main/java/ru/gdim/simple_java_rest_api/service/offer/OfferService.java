package ru.gdim.simple_java_rest_api.service.offer;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import ru.gdim.simple_java_rest_api.application.parsed_catalog.Offer;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public final class OfferService {
    @NotNull
    public List<Offer> findByVendorName(@NotNull List<Offer> offers, @NotNull String vendor) {
        return offers
                .stream()
                .filter(offer -> Objects.equals(offer.getVendor(), vendor))
                .collect(Collectors.toList());
    }
}
