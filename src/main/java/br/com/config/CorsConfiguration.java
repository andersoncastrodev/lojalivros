package br.com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {

	//Permitindo o Front-End LocalHost com Angular 10
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200/");
			}
		};
		
	}
	
	/*
	 * Se o .allowedOrigins("*") Vai permitir TUDO. Mas não é indicado 
	 */
}
