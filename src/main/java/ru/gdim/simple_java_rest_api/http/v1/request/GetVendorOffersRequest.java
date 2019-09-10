package ru.gdim.simple_java_rest_api.http.v1.request;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public final class GetVendorOffersRequest {
    @NotNull
    @URL
    private String url;

    @NotNull
    private String vendor;
}
