package com.gest.gesthm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;

@Configuration
@EnableWebMvc
@OpenAPIDefinition(info = @Info(title = "GESTHM API", version = "v1", description = "Documentation of GESTHM API"))
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new io.swagger.v3.oas.models.info.Info()
            .title("GESTHM API")
            .version("0.0.1-SNAPSHOT")
            .description("This is a sample server created using springdocs - a library for OpenAPI 3 with spring boot.")
            .termsOfService("http://swagger.io/terms/")
            .contact(new Contact()
                .name("Example Team")
                .url("http://www.example.com")
                .email("info@example.com"))
            .license(new License()
                .name("Apache 2.0")
                .url("http://springdoc.org")));
    }
}
