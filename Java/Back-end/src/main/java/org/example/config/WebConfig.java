package org.example.config;

import org.example.routes.Routes;
import org.example.utils.HttpInfo;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * Configuração do aplicativo para permitir acesso a partir de diferentes endereços da web.
 * <p>
 * Esta configuração é útil para permitir que outros sites ou aplicativos acessem os recursos da aplicação,
 * como uma API, mesmo que estejam em domínios diferentes.
 * </p>
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * Configura as regras de acesso Cross-Origin (CORS) para o aplicativo.
     * <p>
     * Este método permite que qualquer site ou aplicativo envie solicitações para o aplicativo,
     * com suporte para operações como "buscar informações" (GET), "enviar dados" (POST), "atualizar informações" (PUT)
     * e "remover dados" (DELETE). Também aceita todos os tipos de cabeçalhos nas solicitações.
     * </p>
     *
     * @param registry o objeto usado para definir as permissões de CORS.
     */
    @Override
    public void addCorsMappings ( CorsRegistry registry ) {
        registry.addMapping( Routes.ALL_ROUTES )
                .allowedOrigins( HttpInfo.ALLOWED_ORIGINS )
                .allowedMethods( HttpInfo.HTTP_GET, HttpInfo.HTTP_POST, HttpInfo.HTTP_PUT, HttpInfo.HTTP_DELETE )
                .allowedHeaders( HttpInfo.ALLOWED_HEADERS );
    }
}
