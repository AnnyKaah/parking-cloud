package one.digitalinnovation.parkingcloud.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder().group("Parking").pathsToMatch("/**").build();
    }

    @Bean
    public OpenAPI ParkingOpenApi() {
        return new OpenAPI().info(new Info().title("Parking Cloud").description("Projeto Parking Cloud REST API").version("v0.0.1")
                .license(new License().name("Apache 2.0").url("http://springdoc.org")));


    }
}
