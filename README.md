# Car Management API

Car Management API é um projeto que fornece uma API RESTful para gerenciar informações sobre carros e usuários. Ele inclui funcionalidades como cadastro, consulta, atualização e remoção de carros, bem como autenticação de usuários com diferentes níveis de permissão.

## Funcionalidades

- **Cadastro de Carros**: Permite cadastrar carros com informações detalhadas.
- **Consulta de Carros**: Possibilita buscar carros cadastrados com filtros específicos.
- **Atualização de Carros**: Atualiza informações de carros existentes.
- **Remoção de Carros**: Remove carros do sistema.
- **Gerenciamento de Usuários**: Cadastro, autenticação e gerenciamento de usuários.
- **Criptografia**: Os dados são criptografados antes de serem armazenados no banco de dados.
- **Autenticação**: Uso de autenticação para proteger as operações da API.
- **Controle de Acesso**: Diferencia permissões entre usuários comuns e administradores.
- **Paginação e limitação de registros exibidos**: Para o método que lista todos os carros é realizado uma limitação da quantidade de dados exibidos.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.3.3**
- **Spring Security** para autenticação e autorização
- **JPA/Hibernate** para persistência de dados
- **PostgreSQL** como banco de dados
- **MongoDB** para armazenar imagens e informações relacionadas
- **Maven** como gerenciador de dependências
- **JUnit e Mockito** para testes automatizados
- **Swagger** para documentação da API

## Requisitos

- **Java 17** ou superior
- **Maven** instalado
- **PostgreSQL** e **MongoDB** em execução
- **Git** para clonar o repositório

## Instalação

1. Clone o repositório:
   ```bash
   git clone https://github.com/Leonardobern10/Car-management-api.git
   ```

2. Navegue até o diretório do projeto:
   ```bash
   cd Car-management-api
   ```

3. Configure o banco de dados PostgreSQL:
   - Crie um banco de dados chamado `car_management`.
   - Atualize as configurações em `src/main/resources/application.properties` com as credenciais do seu banco de dados.

4. Configure o MongoDB:
   - Certifique-se de que o MongoDB esteja em execução.
   - Atualize as configurações do MongoDB em `application.properties` se necessário.

5. Compile e instale as dependências do projeto com Maven:
   ```bash
   mvn clean install
   ```

6. Execute o projeto:
   ```bash
   mvn spring-boot:run
   ```

## Uso

- A documentação da API está disponível através do Swagger em:
  ```
  http://localhost:8080/swagger-ui.html
  ```

- **Endpoints**:
  - **Carros**:
    - `GET /cars`: Lista todos os carros.
    - `POST /cars`: Cadastra um novo carro (apenas administradores).
    - `PUT /cars/{id}`: Atualiza um carro existente (apenas administradores).
    - `DELETE /cars/{id}`: Remove um carro (apenas administradores).
  - **Usuários**:
    - `POST /users/create`: Cria um novo usuário.
    - `POST /auth/login`: Autentica um usuário e retorna um token JWT.

## Contribuição

Contribuições são bem-vindas! Para contribuir com este projeto, siga os passos abaixo:

1. Faça um fork do projeto.
2. Crie uma nova branch para a sua feature:
   ```bash
   git checkout -b minha-feature
   ```
3. Faça commit das suas alterações:
   ```bash
   git commit -m 'Adicionando nova feature'
   ```
4. Envie para o repositório remoto:
   ```bash
   git push origin minha-feature
   ```
5. Abra um Pull Request.

## Licença

Este projeto está licenciado sob a [MIT License](https://opensource.org/licenses/MIT) - veja o arquivo `LICENSE` para mais detalhes.

## Contatos

- **Nome**: Leonardo Bernardo
- **LinkedIn**: [linkedin.com/in/leonardobern10](https://linkedin.com/in/leonardobern10)
- **Email**: leonardobern10@example.com
