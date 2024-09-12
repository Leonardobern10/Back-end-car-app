package org.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Classe de configuração responsável pela configuração global do CORS (Cross-Origin Resource Sharing).
 * Implementa a interface {@link WebMvcConfigurer} para personalizar o comportamento do Spring MVC.
 * <p>
 * Esta configuração permite que o aplicativo aceite solicitações de qualquer origem e define quais métodos
 * HTTP e cabeçalhos são permitidos.
 * </p>
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * Configura as regras de CORS para o aplicativo.
     * <p>
     * Este método define que todas as rotas ("/**") estão disponíveis para solicitações de qualquer origem
     * e permite os métodos HTTP GET, POST, PUT e DELETE. Além disso, permite qualquer cabeçalho.
     * </p>
     *
     * @param registry o objeto {@link CorsRegistry} usado para definir as configurações de CORS
     */
    @Override
    public void addCorsMappings ( CorsRegistry registry ) {
        registry.addMapping( "/**" )
                .allowedOrigins( "*" )
                .allowedMethods( "GET", "POST", "PUT", "DELETE" )
                .allowedHeaders( "*" );
    }
}
