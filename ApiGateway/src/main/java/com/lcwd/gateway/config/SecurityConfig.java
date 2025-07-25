package com.lcwd.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http)
	{
		http
        .authorizeExchange(exchange -> exchange
            .anyExchange().authenticated()
        )
        .oauth2Client(ServerHttpSecurity.OAuth2ClientSpec::and)
        .oauth2ResourceServer(ServerHttpSecurity.OAuth2ResourceServerSpec::jwt);

    return http.build();	}
}
