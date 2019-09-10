package ru.gdim.simple_java_rest_api.application.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import ru.gdim.simple_java_rest_api.application.parsed_catalog.Catalog;
import ru.gdim.simple_java_rest_api.service.catalog.CatalogParser;

import java.net.URL;

@Component
public final class CatalogRepository implements Repository {
    private final CatalogParser catalogParser;

    public CatalogRepository(CatalogParser catalogParser) {
        this.catalogParser = catalogParser;
    }

    @NotNull
    public Catalog findByUrl(@NotNull URL url) {
        return catalogParser.parse(url);
    }
}
