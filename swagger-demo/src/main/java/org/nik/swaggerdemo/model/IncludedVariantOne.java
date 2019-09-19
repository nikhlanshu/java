package org.nik.swaggerdemo.model;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class IncludedVariantOne extends Included{
    private VariantOne variantOne;
    private String varyOne;
}
