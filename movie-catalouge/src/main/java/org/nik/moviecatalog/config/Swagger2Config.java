package org.nik.moviecatalog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket getMovieDocket(){

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.nik.moviecatalog"))
                .paths(regex("/movies.*"))
                .build()
                .apiInfo(createApiInfo());
    }

    public Swagger2Config() {

    }

    private ApiInfo createApiInfo(){

        return new ApiInfo(
              "Movie catalouge API",
                "Add, retrieve, update movie details in the movie catalouge",
                "v1.0",
                "Restricted Use, All rights reserved @ nik.javaworld.org",
                new Contact("Nikhlanshu K Jena", "nik.javaworld.org", "nikhlanshu@gmail.com"),
                "nik.javaworld.org",
                "nik.javaworld.org/license",
                createVendorExtn()
        );
    }
    private List<VendorExtension> createVendorExtn(){

        List<VendorExtension> vendorExtensions = new ArrayList<>();
        vendorExtensions.add(new VendorExtension() {
            @Override
            public String getName() {
                return "MovieName";
            }

            @Override
            public Object getValue() {
                return "MovieValues";
            }
        });
        return vendorExtensions;
    }

}
