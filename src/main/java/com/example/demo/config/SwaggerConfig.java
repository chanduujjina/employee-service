package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public OpenAPI customOpenAI() {
		return new OpenAPI().info(new Info().title("Employee Application")
				.description("This Service Will deal with all the Employee data").version("1.0.0"));

	}

}
