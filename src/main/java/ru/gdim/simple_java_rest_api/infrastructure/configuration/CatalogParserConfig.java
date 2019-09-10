package ru.gdim.simple_java_rest_api.infrastructure.configuration;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@EqualsAndHashCode
@ToString
public class CatalogParserConfig {
    @Value("${catalog_parser.cache_enabled}")
    private Boolean cacheEnabled;

    public Boolean isCacheEnabled() {
        return cacheEnabled;
    }
}
