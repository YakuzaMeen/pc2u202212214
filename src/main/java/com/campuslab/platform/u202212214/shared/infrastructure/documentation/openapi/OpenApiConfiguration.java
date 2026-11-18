package com.campuslab.platform.u202212214.shared.infrastructure.documentation.openapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Oskar Sosa
 */
@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI campusLabOpenApi() {
        return new OpenAPI().info(new Info()
                .title("CampusLab Equipment Reservations API")
                .description("RESTful API to register equipment reservations in university laboratories")
                .version("1.0.0")
                .contact(new Contact().name("Oskar Sosa")));
    }
}
