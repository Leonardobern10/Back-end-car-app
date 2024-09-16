# Car Management API

O projeto **Car Management API** é uma aplicação desenvolvida com Spring Boot que fornece uma API RESTful para gerenciamento de carros. A API permite realizar operações CRUD em registros de carros, além de suportar pesquisa e filtragem por diferentes atributos. O projeto possui sistema de autenticação e é configurado para usar MongoDB e PostgreSQL para armazenamento de dados.

## Funcionalidades

**Gerenciamento de Carros**:
- Recupera todos os carros
- Recupera carros por modelo, ID, valor, ano de produção, fabricante, tipo de motor, velocidade máxima e características
- Cria, atualiza e exclui carros

**Gerenciamento de Usuários**:
- Cria usuários com diferentes roles (ADMIN, USER)
- Recupera usuários por nome de usuário
- Autentica usuários com base em credenciais

**Segurança**:
- Controle de acesso baseado em roles

## Tecnologias Utilizadas

- **Java 21**: Linguagem de programação utilizada para o desenvolvimento da aplicação.
- **Spring Boot 3.3.3**: Framework utilizado para criar e gerenciar a aplicação, facilitando o desenvolvimento de aplicações Java baseadas em Spring.
- **Spring Security**: Framework para fornecer autenticação e autorização, utilizando JWT (JSON Web Tokens) para gerenciar a segurança da API.
- **PostgreSQL**: Banco de dados relacional utilizado para armazenar informações de usuários.
- **Spring Data** JPA: Para interação com o banco de dados.
- **MongoDB**: Banco de dados NoSQL utilizado para armazenar informações de carros e imagens.
- **Maven**: Ferramenta de gerenciamento e construção de projetos Java.
- **JUnit e Mockito**: Frameworks utilizados para criar e executar testes unitários e mocks, garantindo a qualidade e integridade do código.
- **ApplicationEventPublisher**: Para publicação de eventos de aplicação.
- **GitHub**: Plataforma utilizada para controle de versão e hospedagem do código fonte.

## Requisitos

- JDK 17 ou superior
- Maven
- MongoDB
- PostgreSQL

## Instalação

1. **Clone o Repositório:**

   ```bash
   git clone https://github.com/Leonardobern10/Car-management-api.git
   ```

2. **Navegue até o Diretório do Projeto:**

   ```bash
   cd Car-management-api
   ```

3. **Configure o Banco de Dados:**

   - Edite o arquivo `src/main/resources/application.properties` para configurar as conexões com MongoDB e PostgreSQL.
     ```properties
     # MongoDB configuration
     spring.data.mongodb.uri=mongodb://localhost:27017/car_db

     # PostgreSQL configuration
     spring.datasource.url=jdbc:postgresql://localhost:5432/user_db
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     ```

4. **Instale as Dependências:**

   ```bash
   ./mvnw install
   ```

5. **Execute o Projeto:**

   ```bash
   ./mvnw spring-boot:run
   ```

   O servidor será iniciado na porta padrão `8080`.

## Uso

### **Endpoints da API**

#### **Carros**

- **POST /cars**
  
  Cria um novo carro.
  
  **Exemplo de Requisição:**
  ```http
  POST /cars
  Content-Type: application/json

  {
    "model": "Civic",
    "yearProduction": 2022,
    "producedBy": "Honda",
    "imageUrl": "http://example.com/image.jpg",
    "carValue": 20000.00,
    "specifications": {
      "engineType": "V6",
      "engineCapacity": "3.0L",
      "range": "400 miles",
      "acceleration": "6.5s",
      "topSpeed": "150 mph"
    },
    "features": ["Leather seats", "Bluetooth"],
    "dimensions": {
      "length": "4.5m",
      "width": "1.8m",
      "height": "1.4m",
      "wheelBase": "2.7m"
    }
  }
  ```

  **Resposta:**
  ```json
  {
    "id": "abc123",
    "model": "Civic",
    "yearProduction": 2022,
    "producedBy": "Honda",
    "imageUrl": "http://example.com/image.jpg",
    "carValue": 20000.00,
    "specifications": {
      "engineType": "V6",
      "engineCapacity": "3.0L",
      "range": "400 miles",
      "acceleration": "6.5s",
      "topSpeed": "150 mph"
    },
    "features": ["Leather seats", "Bluetooth"],
    "dimensions": {
      "length": "4.5m",
      "width": "1.8m",
      "height": "1.4m",
      "wheelBase": "2.7m"
    }
  }
  ```

- **GET /cars**
  
  Obtém todos os carros.

  **Resposta:**
  ```json
  [
    {
      "id": "abc123",
      "model": "Civic",
      "yearProduction": 2022,
      "producedBy": "Honda",
      "imageUrl": "http://example.com/image.jpg",
      "carValue": 20000.00,
      "specifications": {
        "engineType": "V6",
        "engineCapacity": "3.0L",
        "range": "400 miles",
        "acceleration": "6.5s",
        "topSpeed": "150 mph"
      },
      "features": ["Leather seats", "Bluetooth"],
      "dimensions": {
        "length": "4.5m",
        "width": "1.8m",
        "height": "1.4m",
        "wheelBase": "2.7m"
      }
    }
  ]
  ```

- **GET /cars/{id}**
  
  Obtém um carro pelo ID.
  
  **Exemplo de Requisição:**
  ```http
  GET /cars/abc123
  ```

  **Resposta:**
  ```json
  {
    "id": "abc123",
    "model": "Civic",
    "yearProduction": 2022,
    "producedBy": "Honda",
    "imageUrl": "http://example.com/image.jpg",
    "carValue": 20000.00,
    "specifications": {
      "engineType": "V6",
      "engineCapacity": "3.0L",
      "range": "400 miles",
      "acceleration": "6.5s",
      "topSpeed": "150 mph"
    },
    "features": ["Leather seats", "Bluetooth"],
    "dimensions": {
      "length": "4.5m",
      "width": "1.8m",
      "height": "1.4m",
      "wheelBase": "2.7m"
    }
  }
  ```

- **PUT /cars/{id}**
  
  Atualiza um carro existente.
  
  **Exemplo de Requisição:**
  ```http
  PUT /cars/abc123
  Content-Type: application/json

  {
    "model": "Civic",
    "yearProduction": 2023,
    "producedBy": "Honda",
    "imageUrl": "http://example.com/image_updated.jpg",
    "carValue": 21000.00,
    "specifications": {
      "engineType": "V6",
      "engineCapacity": "3.0L",
      "range": "420 miles",
      "acceleration": "6.3s",
      "topSpeed": "155 mph"
    },
    "features": ["Leather seats", "Bluetooth", "Sunroof"],
    "dimensions": {
      "length": "4.6m",
      "width": "1.8m",
      "height": "1.4m",
      "wheelBase": "2.8m"
    }
  }
  ```

  **Resposta:**
  ```json
  {
    "id": "abc123",
    "model": "Civic",
    "yearProduction": 2023,
    "producedBy": "Honda",
    "imageUrl": "http://example.com/image_updated.jpg",
    "carValue": 21000.00,
    "specifications": {
      "engineType": "V6",
      "engineCapacity": "3.0L",
      "range": "420 miles",
      "acceleration": "6.3s",
      "topSpeed": "155 mph"
    },
    "features": ["Leather seats", "Bluetooth", "Sunroof"],
    "dimensions": {
      "length": "4.6m",
      "width": "1.8m",
      "height": "1.4m",
      "wheelBase": "2.8m"
    }
  }
  ```

- **DELETE /cars/{id}**
  
  Remove um carro pelo ID.
  
  **Exemplo de Requisição:**
  ```http
  DELETE /cars/abc123
  ```

  **Resposta:**
  ```http
  Status: 204 No Content
  ```

#### **Usuários**

- **POST /users/create**

  Cria um novo usuário com autenticação e autorização.
  
  **Exemplo de Requisição:**
  ```http
  POST /users/create
  Content-Type: application/json

  {
    "username": "john_doe",
    "password": "securepassword",
    "role": "USER"
  }
  ```

  **Resposta:**
  ```json
  {
    "message": "USER CREATED SUCCESSFULLY"
  }
  ```

## Testes

Os testes podem ser executados usando Maven:

```bash
./mvnw test
```

## Contribuição

Contribuições são bem-vindas! Se você encontrar um problema ou tiver uma sugestão para melhorias, sinta-se à vontade para abrir uma issue ou enviar um pull request. Siga as diretrizes de contribuição para garantir que seu código esteja alinhado com os padrões do projeto.

## Licença

Este projeto é licenciado sob a [Licença MIT](LICENSE).

## Contato

Para perguntas ou mais informações, entre em contato com:

- **Autor:** Leonardo Bernardo
- **Email:** [leonardo.bernardo2658@gmail.com](mailto:leonardo.bernardo2658@gmail.com)
- **LinkedIn:** [Leonardobern](https://www.linkedin.com/in/leonardo-bern/)
