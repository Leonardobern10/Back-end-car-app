# Back-end Car App

## Funcionalidades

- **Gerenciamento de Veículos:** Adicione, visualize, atualize e exclua veículos.
- **Autenticação e Autorização:** Proteja endpoints com roles `USER` e `ADMIN`.
- **Consultas Avançadas:** Filtre e busque veículos com base em critérios específicos.
- **Validação:** Valide dados de entrada para garantir a integridade.

## Habilidades Abordadas

- **Desenvolvimento com Spring Boot:** Criação de APIs RESTful.
- **Segurança com Spring Security:** Implementação de autenticação e autorização.
- **Gerenciamento de Banco de Dados:** Utilização de JPA/Hibernate para persistência de dados.
- **Boas Práticas de Programação:** Organização de código, refatoração e testes.

## Instalação

1. **Clone o Repositório:**
    ```bash
    git clone https://github.com/Leonardobern10/Back-end-car-app.git
    ```

2. **Navegue até o Diretório do Projeto:**
    ```bash
    cd Back-end-car-app
    ```

3. **Configure o Banco de Dados:**
   - Crie um banco de dados conforme especificado em `src/main/resources/application.properties`.
   - Ajuste as credenciais e URL de conexão conforme necessário.

4. **Instale as Dependências:**
    ```bash
    ./mvnw install
    ```

5. **Execute o Projeto:**
    ```bash
    ./mvnw spring-boot:run
    ```

6. **Acesse a API:**
   - A API estará disponível em `http://localhost:8080`.

## Uso

- **Endpoints:**
    - **GET /vehicles** - Retorna a lista de todos os veículos.
    - **POST /vehicles** - Adiciona um novo veículo.
    - **PUT /vehicles/{id}** - Atualiza um veículo existente.
    - **DELETE /vehicles/{id}** - Exclui um veículo.

- **Autenticação:**
    - **Usuário:** `user` / Senha: `password`
    - **Administrador:** `admin` / Senha: `admin`

## Estrutura do Projeto

- **`src/main/java/com/example/carapp`** - Código fonte da aplicação.
  - **`controller`** - Contém os controladores REST.
  - **`service`** - Contém a lógica de negócios.
  - **`repository`** - Contém as interfaces de repositório.
  - **`model`** - Contém as entidades JPA.
- **`src/main/resources`** - Arquivos de configuração e recursos.
  - **`application.properties`** - Configurações do Spring Boot.
- **`src/test/java/com/example/carapp`** - Testes da aplicação.

## Contribuição

1. **Faça um Fork do Repositório.**
2. **Crie uma Branch para sua Feature:**
    ```bash
    git checkout -b minha-feature
    ```
3. **Commit suas Mudanças:**
    ```bash
    git commit -am 'Adiciona nova feature'
    ```
4. **Push para a Branch:**
    ```bash
    git push origin minha-feature
    ```
5. **Abra um Pull Request.**

## Licença

Distribuído sob a Licença MIT. Veja `LICENSE` para mais informações.

## Contato

- **Autor:** Leonardo Bernardo
- **E-mail:** [leonardo.bernardo2658@gmail.com](mailto:leonardo.bernardo2658@gmail.com)
- **GitHub:** [Leonardobern10](https://github.com/Leonardobern10)
