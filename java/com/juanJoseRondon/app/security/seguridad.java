package com.juanJoseRondon.app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;




public class seguridad {
	
	@Bean
	SecurityFilterChain seguridadFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity
				.csrf(config -> config.disable())
				.authorizeHttpRequests(auth -> {
					auth.requestMatchers("/").permitAll();
					auth.anyRequest().authenticated();
				})
		.sessionManagement(session -> {
			session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
		})
		.httpBasic()
		.and()
		.build();
		
	}
}
