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
					auth.requestMatchers("/","/index","/quienesSomos","/contacto","/foroAcademico","/Css","/js","/img","/login","/loginDocentes","/loginEstudiantes","/loginAcudientes").permitAll();
					auth.anyRequest().authenticated();
				})
		.sessionManagement(session -> {
			session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
		})
		.formLogin()
		.loginPage("/login")
                .failureUrl("/login")
                .permitAll()
                .and()
		.httpBasic()
		.and()
		.build();
		
	}
}
