package org.nik.moviecatalog;

import org.nik.moviecatalog.config.Swagger2Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Import(value = Swagger2Config.class)
@EnableSwagger2
public class MovieCatalogApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieCatalogApplication.class, args);
    }

}
