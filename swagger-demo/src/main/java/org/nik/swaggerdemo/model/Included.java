package org.nik.swaggerdemo.model;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel(subTypes = {IncludedVariantOne.class, IncludedVariantTwo.class})
@Getter
@Setter
@NoArgsConstructor
public abstract class Included {

    private String id;
    private String type;
}
