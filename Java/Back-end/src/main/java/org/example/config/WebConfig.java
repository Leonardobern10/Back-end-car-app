package org.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * Configuração que permite o acesso ao aplicativo de diferentes endereços da web.
 * <p>
 * Isso é útil para permitir que outros sites ou aplicativos acessem os recursos da sua aplicação,
 * como uma API, mesmo estando em domínios diferentes.
 * </p>
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * Configura as regras de acesso ao aplicativo.
     * <p>
     * Este método permite que qualquer site ou aplicativo envie solicitações para o aplicativo.
     * Permite que as operações como "buscar informações" (GET), "enviar dados" (POST), "atualizar informações" (PUT)
     * e "remover dados" (DELETE) sejam feitas, e aceita todos os tipos de cabeçalhos nas solicitações.
     * </p>
     *
     * @param registry objeto usado para definir como essas permissões serão configuradas.
     */
    @Override
    public void addCorsMappings ( CorsRegistry registry ) {
        registry.addMapping( "/**" )
                .allowedOrigins( "*" )
                .allowedMethods( "GET", "POST", "PUT", "DELETE" )
                .allowedHeaders( "*" );
    }
}
