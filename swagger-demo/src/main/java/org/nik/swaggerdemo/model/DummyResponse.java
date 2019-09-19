package org.nik.swaggerdemo.model;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@ApiModel(value = "dummyResponse")
@Getter
@Setter
@NoArgsConstructor
public class DummyResponse {

    private Set<Included> includeds;
    private String id;
    private String type = this.getClass().getName();
}
