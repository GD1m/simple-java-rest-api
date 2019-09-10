package ru.gdim.simple_java_rest_api.service.catalog_parser;

import org.jetbrains.annotations.NotNull;
import ru.gdim.simple_java_rest_api.application.parsed_catalog.Catalog;

import java.net.URL;

public interface CatalogParser {
    @NotNull
    Catalog parse(@NotNull URL url);
}
