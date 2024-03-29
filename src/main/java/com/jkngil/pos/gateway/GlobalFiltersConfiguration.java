package com.jkngil.pos.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import reactor.core.publisher.Mono;

@Configuration
public class GlobalFiltersConfiguration {
	final Logger logger = LoggerFactory.getLogger(MyPreFilter.class);
	
	@Bean
	@Order(1)
	public GlobalFilter secondPreFilter() {
		return (exchange, chain) -> {
			logger.info("My second pre-filter is executed...");
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				logger.info("My third post-filter is executed...");
			}));
		};
	}
	
	@Bean
	@Order(2)
	public GlobalFilter thirdPreFilter() {
		return (exchange, chain) -> {
			logger.info("My third pre-filter is executed...");
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				logger.info("My second post-filter is executed...");
			}));
		};
	}
	
	@Bean
	@Order(3)
	public GlobalFilter fourthPreFilter() {
		return (exchange, chain) -> {
			logger.info("My fourth pre-filter is executed...");
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				logger.info("My first post-filter is executed...");
			}));
		};
	}
}
