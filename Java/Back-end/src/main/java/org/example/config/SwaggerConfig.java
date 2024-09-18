package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Configuração do Swagger para a documentação da API.
 * <p>
 * Esta classe configura o Swagger para gerar documentação para a API. O Swagger é uma ferramenta
 * que ajuda a visualizar e interagir com a API, fornecendo uma interface web para explorar os
 * endpoints disponíveis e os modelos de dados utilizados.
 * </p>
 */
@Configuration
public class SwaggerConfig {

    /**
     * Configura o Docket do Swagger para a documentação da API.
     * <p>
     * O método {@link #api()} cria uma instância de {@link Docket} configurada para utilizar o
     * Swagger 2 e especifica que a documentação deve incluir todos os endpoints localizados no
     * pacote base "org.example.controller". O {@link Docket} também está configurado para documentar
     * todos os caminhos disponíveis.
     * </p>
     *
     * @return uma instância configurada de {@link Docket} para o Swagger
     */
    @Bean
    public Docket api () {
        return new Docket( DocumentationType.SWAGGER_2 )
                .select()
                .apis( RequestHandlerSelectors.basePackage( "org.example.controller" ) ) // ajuste o pacote conforme necessário
                .paths( PathSelectors.any() )
                .build();
    }
}
