package ru.gdim.simple_java_rest_api.service.catalog_parser.adapter;

import org.jetbrains.annotations.NotNull;
import ru.gdim.simple_java_rest_api.application.parsed_catalog.Catalog;
import ru.gdim.simple_java_rest_api.service.catalog_parser.CatalogParser;
import ru.gdim.simple_java_rest_api.service.resource_version.ResourceVersion;
import ru.gdim.simple_java_rest_api.service.resource_version.ResourceVersionService;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.spi.CachingProvider;
import java.net.URL;
import java.util.Objects;

public final class CachedCatalogParser extends CatalogParserAdapter {
    private final static String CACHE_NAME = "resourceVersionCache";

    private final ResourceVersionService resourceVersionService;
    private Cache<ResourceVersion, Catalog> cache;

    public CachedCatalogParser(CatalogParser service, ResourceVersionService resourceVersionService) {
        super(service);

        this.resourceVersionService = resourceVersionService;

        initCache();
    }

    @NotNull
    @Override
    public Catalog parse(@NotNull URL url) {
        ResourceVersion resourceVersion = resourceVersionService.tryToGet(url);

        if (Objects.nonNull(resourceVersion) && cache.containsKey(resourceVersion)) {
            return cache.get(resourceVersion);
        }

        Catalog catalog = super.parse(url);

        if (Objects.nonNull(resourceVersion)) {
            cache.put(resourceVersion, catalog);
        }

        return catalog;
    }

    private void initCache() {
        CachingProvider cachingProvider = Caching.getCachingProvider();

        CacheManager cacheManager = cachingProvider.getCacheManager();

        MutableConfiguration<ResourceVersion, Catalog> config = new MutableConfiguration<>();

        this.cache = cacheManager.createCache(CACHE_NAME, config);
    }
}
