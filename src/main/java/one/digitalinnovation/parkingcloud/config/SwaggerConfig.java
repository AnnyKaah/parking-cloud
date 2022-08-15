package one.digitalinnovation.parkingcloud.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

;import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ComponentScan
@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket getDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("one.digitalinnovation.parkingcloud"))
                .build()
                .apiInfo(metaData()).securityContexts(Arrays.asList(actuatorSecurityContext()))
                .securitySchemes(Arrays.asList(basicAuthScheme()));
    }

    private SecurityContext actuatorSecurityContext() {
        return SecurityContext.builder()
                .securityReferences(Arrays.asList(basicAuthReference()))
                .build();
    }

    private SecurityScheme basicAuthScheme() {
        return new BasicAuth("basicAuth");
    }

    private SecurityReference basicAuthReference() {
        return new SecurityReference("basicAuth", new AuthorizationScope[0]);
    }

    private List<SecurityScheme> basicScheme() {
        List<SecurityScheme> schemeList = new ArrayList<>();
        schemeList.add(new BasicAuth("basicAuth"));
        return schemeList;
    }

    private ApiKey apiKey() {
        return new ApiKey("apiKey", "Authorization", "header");
    }


    private ApiInfo metaData() {

         return new ApiInfoBuilder()
                .title("Parking Cloud")
                .description("Parking REST API")
                .version("v0.0.1")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .build();

}


}


