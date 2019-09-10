package ru.gdim.simple_java_rest_api.service.catalog.adapter;

import org.jetbrains.annotations.NotNull;
import ru.gdim.simple_java_rest_api.application.parsed_catalog.Catalog;
import ru.gdim.simple_java_rest_api.service.catalog.CatalogParser;

import java.net.URL;

abstract public class CatalogParserAdapter implements CatalogParser {
    private final CatalogParser catalogParser;

    CatalogParserAdapter(CatalogParser catalogParser) {
        this.catalogParser = catalogParser;
    }

    @NotNull
    @Override
    public Catalog parse(@NotNull URL url) {
        return catalogParser.parse(url);
    }
}
