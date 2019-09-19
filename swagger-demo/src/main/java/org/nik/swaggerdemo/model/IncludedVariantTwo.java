package org.nik.swaggerdemo.model;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class IncludedVariantTwo extends Included{
    private VariantTwo variantTwo;
    private String varyTwo;
}
