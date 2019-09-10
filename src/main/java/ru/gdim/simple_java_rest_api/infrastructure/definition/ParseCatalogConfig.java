package ru.gdim.simple_java_rest_api.infrastructure.definition;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.gdim.simple_java_rest_api.infrastructure.configuration.CatalogParserConfig;
import ru.gdim.simple_java_rest_api.service.catalog.CatalogParser;
import ru.gdim.simple_java_rest_api.service.catalog.CatalogParserImpl;
import ru.gdim.simple_java_rest_api.service.catalog.adapter.CachedCatalogParser;
import ru.gdim.simple_java_rest_api.service.resource_version.ResourceVersionService;

@Component
public class ParseCatalogConfig {
    private final ResourceVersionService resourceVersionService;
    private final CatalogParserConfig catalogParserConfig;

    public ParseCatalogConfig(ResourceVersionService resourceVersionService, CatalogParserConfig catalogParserConfig) {
        this.resourceVersionService = resourceVersionService;
        this.catalogParserConfig = catalogParserConfig;
    }

    @Bean
    CatalogParser getCatalogParser() {
        CatalogParser catalogParser = new CatalogParserImpl();

        if (catalogParserConfig.isCacheEnabled()) {
            return new CachedCatalogParser(catalogParser, resourceVersionService);
        }

        return catalogParser;
    }
}
