package br.com.matheus.escola.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
 * @Configuration --> Define que a classe terá metodos que serão processados pelo Spring Container
 * */

@Configuration
public class CorsConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		
		String[] origins = new String[] {
			"http://localhost:4200", "http://localhost:5000", "https://angular-escola.herokuapp.com"
		};
		
		registry.addMapping("/**")
			.allowedOrigins(origins)
			.allowedMethods("GET", "POST", "PUT", "DELETE");
	}
}
