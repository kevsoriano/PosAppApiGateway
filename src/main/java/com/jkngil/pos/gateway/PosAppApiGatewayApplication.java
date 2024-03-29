package com.jkngil.pos.gateway;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@SpringBootApplication
public class PosAppApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PosAppApiGatewayApplication.class, args);
	}
	@Bean
	public CorsWebFilter corsWebFilter() {
	    CorsConfiguration corsConfig = new CorsConfiguration();
	    corsConfig.addAllowedOrigin("*");
	    corsConfig.addAllowedMethod("*");
	    corsConfig.addAllowedHeader("*");
	    corsConfig.addExposedHeader("token");
	    corsConfig.addExposedHeader("userId");
//	    corsConfig.setAllowCredentials(true);

	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", corsConfig);

	    return new CorsWebFilter(source);
	}
}
