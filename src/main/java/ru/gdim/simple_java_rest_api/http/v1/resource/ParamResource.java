package ru.gdim.simple_java_rest_api.http.v1.resource;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.hateoas.ResourceSupport;
import ru.gdim.simple_java_rest_api.application.parsed_catalog.Param;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString
final class ParamResource extends ResourceSupport {
    private String name;
    private String unit;
    private String value;

    ParamResource(Param param) {
        this.name = param.getName();
        this.unit = param.getUnit();
        this.value = param.getValue();
    }
}
