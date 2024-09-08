# Car Management API

Este projeto é uma API para gerenciamento de carros, desenvolvida utilizando Spring Boot com Java. A aplicação permite criar, ler, atualizar e excluir informações sobre carros, com validações de entrada e tratamento de exceções. É uma solução ideal para demonstrar habilidades em desenvolvimento back-end e gerenciamento de dados.

## Funcionalidades

- **GET /cars**: Retorna todos os carros cadastrados.
- **GET /cars/{id}**: Retorna um carro específico com base no ID.
- **POST /cars**: Cria um novo carro.
- **PUT /cars/{id}**: Atualiza as informações de um carro existente com base no ID.
- **DELETE /cars/{id}**: Remove um carro com base no ID.

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- JPA (Hibernate)
- H2 Database (para testes)
- Mockito (para testes)
- JUnit 5 (para testes)

## Instalação

Para rodar este projeto localmente, siga os passos abaixo:

1. **Clone o repositório**

   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   ```

2. **Navegue até o diretório do projeto**

   ```bash
   cd seu-repositorio
   ```

3. **Compile e execute o projeto**

   Com o Maven:

   ```bash
   ./mvnw spring-boot:run
   ```

   Com o Gradle:

   ```bash
   ./gradlew bootRun
   ```

4. **Acesse a API**

   A API estará disponível em [http://localhost:8080/cars](http://localhost:8080/cars).

## Uso

Você pode testar a API utilizando ferramentas como Postman ou curl. Abaixo estão exemplos de requisições:

- **GET todos os carros**

   ```bash
   curl -X GET http://localhost:8080/cars
   ```

- **GET um carro por ID**

   ```bash
   curl -X GET http://localhost:8080/cars/1
   ```

- **POST criar um novo carro**

   ```bash
   curl -X POST http://localhost:8080/cars -H "Content-Type: application/json" -d '{"model": "Model S", "url": "http://example.com/model-s", "carValue": 75000.0}'
   ```

- **PUT atualizar um carro existente**

   ```bash
   curl -X PUT http://localhost:8080/cars/1 -H "Content-Type: application/json" -d '{"model": "Model S", "url": "http://example.com/model-s", "carValue": 80000.0}'
   ```

- **DELETE um carro**

   ```bash
   curl -X DELETE http://localhost:8080/cars/1
   ```

## Estrutura do Projeto

- **config**: Configurações da aplicação, como CORS.
- **controller**: Controladores REST para gerenciar as requisições HTTP.
- **exceptions**: Classes para tratamento de exceções personalizadas.
- **model**: Entidades do banco de dados.
- **repository**: Repositórios JPA para operações de banco de dados.
- **service**: Serviços de lógica de negócio e validação.
- **validations**: Validações de dados para as entidades.
- **Handler**: Classe para tratamento global de exceções.
- **Main**: Classe principal para inicialização da aplicação.

## Contribuição

Sinta-se à vontade para contribuir com este projeto. Se você encontrar algum bug ou tiver sugestões de melhorias, por favor, abra uma issue ou um pull request.

## Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE).

## Contato

Para mais informações, entre em contato com [seu-email@example.com](mailto:seu-email@example.com).
Também estou disponível no LinkedIn: [LinkedIn](https://www.linkedin.com/in/leonardo-bern/).
