package org.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Classe de configuração responsável pela configuração global do CORS (Cross-Origin Resource Sharing).
 * Implementa a interface {@link WebMvcConfigurer} para personalizar o comportamento do Spring MVC.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * Configura as regras de CORS para o aplicativo.
     * Permite solicitações de qualquer origem, e define os métodos HTTP permitidos e cabeçalhos permitidos.
     *
     * @param registry o objeto {@link CorsRegistry} usado para definir as configurações de CORS
     */
    @Override
    public void addCorsMappings (CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");
    }
}
