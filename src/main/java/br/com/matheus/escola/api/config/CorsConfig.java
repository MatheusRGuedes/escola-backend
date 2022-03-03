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
		registry.addMapping("/**")
			.allowedOrigins("http://localhost:3000", 
							"http://localhost:5000",
						 	"https://escolabackend.herokuapp.com")
			.allowedMethods("GET", "POST", "PUT", "DELETE");
	}
}
