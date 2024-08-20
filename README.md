# Projeto de Aplicação de Carros com Frontend e Backend

Este projeto consiste em uma aplicação completa para gestão de carros, composta por um backend desenvolvido em Spring Boot com JPA e um frontend construído com React. A aplicação permite a criação, leitura, atualização e exclusão de informações sobre carros, e é ideal para entender a integração entre um backend e um frontend.

## Funcionalidades

### Backend

- **CRUD de Carros**: Operações básicas para gerenciar carros no banco de dados.
- **Persistência**: Utiliza PostgreSQL para armazenamento de dados.
- **Endpoints**:
  - **GET /cars**: Lista todos os carros.
  - **GET /cars/{id}**: Recupera um carro específico pelo ID.
  - **POST /cars**: Adiciona um novo carro.
  - **PUT /cars/{id}**: Atualiza um carro existente.
  - **DELETE /cars/{id}**: Remove um carro pelo ID.

### Frontend

- **Interface de Usuário**: Aplicação React que consome a API do backend.
- **Funcionalidades**:
  - **Listagem de Carros**: Exibe todos os carros em uma tabela.
  - **Detalhes do Carro**: Visualiza informações detalhadas de um carro.
  - **Formulário de Adição/Atualização**: Permite adicionar ou atualizar carros.
  - **Exclusão de Carro**: Remove um carro da lista.

## Tecnologias Utilizadas

### Backend

- **Java**: Linguagem de programação principal.
- **Spring Boot**: Framework para desenvolvimento de aplicações Java.
- **JPA (Jakarta Persistence API)**: Para gerenciamento de dados.
- **PostgreSQL**: Banco de dados relacional.
- **Spring Security**: Para autenticação e autorização (opcional).
- **JUnit**: Framework para testes unitários e de integração.

### Frontend

- **JavaScript (ES6+)**: Linguagem de programação principal.
- **React**: Biblioteca para construção de interfaces de usuário.
- **React Router**: Gerenciamento de navegação e rotas.
- **Axios**: Biblioteca para realizar requisições HTTP.
- **Bootstrap**: Framework para estilização e design responsivo.

## Configuração do Projeto

### Backend

#### Requisitos

- **Java JDK 17 ou superior**
- **Maven 3.8 ou superior**
- **PostgreSQL**

#### Configuração do Banco de Dados

1. **Crie um banco de dados PostgreSQL**:

   ```sql
   CREATE DATABASE nome_do_banco;
   ```

2. **Configure as credenciais do banco de dados no arquivo `src/main/resources/application.properties`**:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_banco
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   ```

3. **Execute a aplicação**:

   ```bash
   mvn spring-boot:run
   ```

   A aplicação será iniciada na porta padrão `8080`.

### Frontend

#### Requisitos

- **Node.js**: Inclui npm (ou yarn) para gerenciamento de pacotes.
- **npm ou yarn**: Gerenciador de pacotes.

#### Configuração do Frontend

1. **Navegue até o diretório do frontend**:

   ```bash
   cd frontend
   ```

2. **Instale as dependências**:

   ```bash
   npm install
   # ou
   yarn install
   ```

3. **Configure o endpoint da API** no arquivo `src/api/Api.js`:

   ```javascript
   const API_BASE_URL = 'http://localhost:8080';
   ```

4. **Execute a aplicação**:

   ```bash
   npm start
   # ou
   yarn start
   ```

   A aplicação será iniciada na porta padrão `3000`.

## Estrutura do Projeto

### Backend

- **src/main/java/com/seuprojeto/controller**: Controladores da API.
- **src/main/java/com/seuprojeto/model**: Entidades JPA.
- **src/main/java/com/seuprojeto/repository**: Repositórios JPA.
- **src/main/java/com/seuprojeto/service**: Serviços da aplicação.
- **src/main/java/com/seuprojeto/config**: Configurações do Spring Boot.

### Frontend

- **src/components**: Componentes React.
- **src/pages**: Páginas principais da aplicação.
- **src/api**: Funções para interação com a API backend.
- **src/styles**: Arquivos de estilo.

## Executando os Testes

### Backend

Para executar os testes unitários e de integração:

```bash
mvn test
```

### Frontend

Para executar os testes:

```bash
npm test
# ou
yarn test
```

## Contribuindo

Se desejar contribuir para o projeto, por favor, siga estas etapas:

1. Faça um fork do repositório.
2. Crie uma branch para a sua feature (`git checkout -b minha-feature`).
3. Faça commit das suas alterações (`git commit -am 'Adiciona nova feature'`).
4. Envie a branch para o repositório remoto (`git push origin minha-feature`).
5. Abra um Pull Request.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

## Contato

Para mais informações, entre em contato com [leonardo.bernardo2658@gmail.com](mailto:leonardo.bernardo2658@gmail.com).
<br />
Pode me encontrar também no [LinkedIn](https://www.linkedin.com/in/leonardo-bern/).
