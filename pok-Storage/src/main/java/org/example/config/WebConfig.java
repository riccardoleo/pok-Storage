package org.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Permetti tutte le rotte
                .allowedOrigins("http://localhost") // Permetti richieste da questo dominio
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Permetti questi metodi HTTP
                .allowedHeaders("*") // Permetti tutte le intestazioni
                .allowCredentials(true); // Permetti l'invio di credenziali (cookie, token, ecc.)
    }
}
