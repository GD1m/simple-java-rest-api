package ru.gdim.simple_java_rest_api.service.catalog_parser;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.jetbrains.annotations.NotNull;
import ru.gdim.simple_java_rest_api.application.parsed_catalog.Catalog;
import ru.gdim.simple_java_rest_api.service.catalog_parser.exception.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public final class CatalogParserImpl implements CatalogParser {
    @NotNull
    public Catalog parse(@NotNull URL url) {
        Catalog catalog = parseXmlCatalog(url);

        validateParsedCatalog(catalog, url);

        return catalog;
    }

    @NotNull
    private Catalog parseXmlCatalog(@NotNull URL url) {
        try {
            return (new XmlMapper()).readValue(url, Catalog.class);
        } catch (FileNotFoundException e) {
            throw new NotFoundException(url, e);
        } catch (JsonParseException e) {
            throw new InvalidXmlException(url, e);
        } catch (UnrecognizedPropertyException e) {
            throw new UnexpectedXmlPropertyException(url, e);
        } catch (IOException e) {
            throw new XmlParsingException(url, e);
        }
    }

    private void validateParsedCatalog(@NotNull Catalog catalog, @NotNull URL url) {
        if (Objects.isNull(catalog.getShop())) {
            throw new MissedDataException("XML element `yml_catalog.shop` can not be null", url);
        }

        if (Objects.isNull(catalog.getShop().getOffers()) || catalog.getShop().getOffers().isEmpty()) {
            throw new MissedDataException("XML element `yml_catalog.shop.offers` can not be null or empty", url);
        }
    }
}
