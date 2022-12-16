package com.confident.silverconnect.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        License license = new License().name("Copyright(C) CWY Corporation All rights reserved.");
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Silver Connect - Data server  API")
                        .description("데이터 서버 API")
                        .version("v0.0.1"));
    }
}
