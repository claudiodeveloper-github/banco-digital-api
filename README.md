#  Banco Digital API

<div align="center">
  <img src="banner-banco-digital-api.png" alt="Banner Banco Digital API" width="100%"/>
</div>

<br/>

<div align="center">

  ![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
  ![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
  ![MySQL](https://img.shields.io/badge/MySQL-8.x-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
  ![Maven](https://img.shields.io/badge/Maven-3.x-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
  ![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)

</div>

<br/>

> **API RESTful** robusta, segura e escalável para uma plataforma bancária completa. Construída com Spring Boot 3.x e Java 21, seguindo boas práticas, princípios SOLID e Clean Code.

---

##  Índice

- [Sobre o Projeto](#-sobre-o-projeto)
- [Tecnologias Utilizadas](#-tecnologias-utilizadas)
- [Estrutura do Projeto](#-estrutura-do-projeto)
- [Endpoints da API](#-endpoints-da-api)
- [Regras de Negócio](#-regras-de-negócio)
- [Tratamento de Exceções](#-tratamento-de-exceções)
- [Diferencial Exclusivo](#-diferencial-exclusivo--front-end-embutido)
- [Como Executar](#-como-executar)
- [Autor](#-autor)
- [Licença](#-licença)

---

##  Sobre o Projeto

O **Banco Digital API** é uma solução RESTful robusta desenvolvida com **Spring Boot 3.x** e **Java 21**, projetada para gerenciar operações essenciais de uma estrutura bancária simplificada, como criação de contas, consulta de saldos e depósitos transacionais.

A arquitetura segue o padrão de desenvolvimento em camadas **Controller → Service → Repository (Model)**, associado a um tratamento global de exceções que garante baixo acoplamento, separação estrita de responsabilidades e respostas HTTP sempre padronizadas.

O grande diferencial deste repositório é a inclusão de uma **Interface Client Interativa integrada** (`index.html`), hospedada diretamente nos recursos estáticos da aplicação. Ela atua como um **simulador REST** e **monitor de saúde** integrado, permitindo testar todos os endpoints em tempo real diretamente pelo navegador, **sem a necessidade de ferramentas externas** como Postman ou Insomnia.

---

## 🛠 Tecnologias Utilizadas

| Tecnologia          | Versão | Finalidade                                        |
|---------------------|--------|---------------------------------------------------|
| Java                | 21     | Linguagem de programação principal                |
| Spring Boot         | 3.x    | Framework base da aplicação                       |
| Spring Data JPA     | 3.x    | Camada de persistência e ORM (Hibernate)          |
| MySQL Driver        | 8.0.x  | Driver de conexão com o banco de dados            |
| Hibernate           | —      | Implementação JPA com `ddl-auto=update`           |
| Lombok              | —      | Produtividade e redução de código boilerplate     |
| Maven               | 3.x    | Gerenciador de dependências e build               |

---

##  Estrutura do Projeto

```text
banco-digital-api/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/claudiocastro/banco/api/
│   │   │       │
│   │   │       ├── controller/          # Exposição dos endpoints REST
│   │   │       │   └── ContaController.java
│   │   │       │
│   │   │       ├── exception/           # Tratamento global de erros customizados
│   │   │       │   ├── GlobalExceptionHandler.java
│   │   │       │   └── ContaNaoEncontradaException.java
│   │   │       │
│   │   │       ├── model/               # Entidades mapeadas no banco de dados
│   │   │       │   └── ContaCorrente.java
│   │   │       │
│   │   │       ├── repository/          # Interfaces de persistência (Spring Data JPA)
│   │   │       │   └── ContaRepository.java
│   │   │       │
│   │   │       ├── service/             # Camada de regras de negócio da aplicação
│   │   │       │   └── ContaService.java
│   │   │       │
│   │   │       └── BancoDigitalApiApplication.java   # Classe de inicialização
│   │   │
│   │   └── resources/
│   │       ├── static/
│   │       │   └── index.html           # Painel Front-end/Simulador REST integrado
│   │       └── application.properties   # Parâmetros de infraestrutura do sistema
│   │
│   └── test/                            # Ambiente de testes unitários e de contexto
│
└── pom.xml                              # Manifesto de dependências do Maven
```

---

##  Endpoints da API

**URL Base Local:** `http://localhost:8080/contas`

| Método | Endpoint | Descrição | Status HTTP |
|--------|----------|-----------|-------------|
| <kbd>GET</kbd> | `/contas` | Retorna a lista de todas as contas cadastradas | `200 OK` |
| <kbd>GET</kbd> | `/contas/{numero}` | Retorna os dados de uma conta específica pelo número | `200 OK` / `404 Not Found` |
| <kbd>POST</kbd> | `/contas` | Cria uma nova conta a partir de um JSON no corpo da requisição | `201 Created` / `400 Bad Request` |
| <kbd>POST</kbd> | `/contas/{numero}/deposito?valor=` | Executa uma operação de crédito e atualiza o saldo da conta | `200 OK` / `404 Not Found` |

###  Exemplo de Payload — Criar Conta

```json
{
  "titular": "Cláudio G. S. Castro",
  "tipo": "CORRENTE",
  "saldo": 1500.00
}
```

###  Exemplo de Resposta — Conta Criada

```json
{
  "numero": 1,
  "titular": "Cláudio G. S. Castro",
  "tipo": "CORRENTE",
  "saldo": 1500.00
}
```

---

##  Regras de Negócio

A entidade principal da aplicação é a `ContaCorrente`, com os seguintes campos:

| Campo     | Tipo   | Restrição                          |
|-----------|--------|------------------------------------|
| `numero`  | Long   | ID auto-incremento (chave primária)|
| `titular` | String | Nome do titular da conta           |
| `tipo`    | String | `CORRENTE` ou `POUPANÇA`           |
| `saldo`   | Double | Valor financeiro atual da conta    |

**Funcionalidades gerenciadas pelo `ContaService`:**

- **`listarTodas()`** — Recupera todas as contas registradas no banco de dados.
- **`buscarPorNumero(Long numero)`** — Localiza um registro específico pelo número identificador. Lança `ContaNaoEncontradaException` se não encontrada.
- **`criarConta(ContaCorrente conta)`** — Persiste uma nova conta com os dados fornecidos.
- **`depositar(Long numero, Double valor)`** — Processa um incremento financeiro na conta. Lança `IllegalArgumentException` se o valor informado for **menor ou igual a zero**, bloqueando automaticamente lançamentos negativos ou nulos.

---

##  Tratamento de Exceções

A aplicação conta com um interceptador global `@RestControllerAdvice` (`GlobalExceptionHandler`) que captura qualquer erro e devolve uma **resposta JSON padronizada**, evitando a exposição de falhas internas da JVM ao cliente.

**Formato padrão da resposta de erro:**

```json
{
  "timestamp": "2026-05-29T20:00:00",
  "status": 404,
  "erro": "Conta não encontrada",
  "mensagem": "Não existe conta com o número informado."
}
```

| Exceção Tratada                  | Status HTTP           | Cenário                                          |
|----------------------------------|-----------------------|--------------------------------------------------|
| `ContaNaoEncontradaException`    | `404 Not Found`       | Conta inexistente consultada pelo número         |
| `MethodArgumentNotValidException`| `400 Bad Request`     | Campos inválidos ou ausentes no corpo da requisição |
| `IllegalArgumentException`       | `400 Bad Request`     | Valor de depósito menor ou igual a zero          |
| `Exception` (genérica)           | `500 Internal Server Error` | Falhas inesperadas ou não mapeadas         |

---

##  Diferencial Exclusivo — Front-end Embutido

Um dos grandes diferenciais desta API é a presença de uma **Interface Client Interativa** nativa, servida diretamente pelo próprio Spring Boot a partir do diretório `src/main/resources/static/index.html`.

Acessível em `http://localhost:8080`, ela dispensa o uso de qualquer ferramenta externa e oferece:

-  **Monitor de Saúde em Tempo Real** — Realiza um ping no servidor a cada **15 segundos** e exibe o status da aplicação como `ONLINE` ou `OFFLINE`.
-  **Simulador de Requisições POST** — Painel dedicado para compor e disparar o payload de criação de conta diretamente pelo navegador.
-  **Terminal de Debug** — Painel estilo terminal que exibe as respostas do servidor em tempo real (Server Response).
-  **Busca e Depósito Integrados** — Campos de input para executar buscas por número de conta e operações de depósito sem sair da interface.

---

##  Como Executar

### Pré-requisitos

Certifique-se de ter instalado em sua máquina:

- [Java 21+](https://www.oracle.com/java/technologies/downloads/)
- [Maven 3.x+](https://maven.apache.org/download.cgi)
- [MySQL 8.x+](https://dev.mysql.com/downloads/)

### Passo a Passo

**1. Clone o repositório:**

```bash
git clone https://github.com/claudiodeveloper-github/banco-digital-api.git
cd banco-digital-api
```

**2. Crie o banco de dados MySQL:**

```sql
CREATE DATABASE banco_spring;
```

**3. Configure as credenciais no `application.properties`:**

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/banco_spring
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
spring.jpa.hibernate.ddl-auto=update
```

**4. Execute o build e inicie a aplicação:**

```bash
mvn clean install
mvn spring-boot:run
```

**5. Acesse a Interface Interativa no navegador:**

```
http://localhost:8080
```

> A API estará disponível em `http://localhost:8080/contas` ✅

---

##  Autor

<div align="center">
  <br/>
  <b>Cláudio G. S. Castro</b><br/>
  <i>Java Backend Developer em Formação</i>
  <br/><br/>

  [![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/claudio-g-s-castro)
  [![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/claudiodeveloper-github)

  <br/>

  > *"Desenvolvendo Backend em formação com foco em Java e Spring Boot. Atualmente construindo projetos práticos para aprofundar conhecimentos em APIs REST, bancos de dados relacionais e arquitetura backend."*

</div>

---

##  Licença

Este projeto está licenciado sob a **Licença MIT**. Consulte o arquivo [LICENSE](LICENSE) para mais detalhes.

---

<div align="center">
  <sub>Feito com Java e dedicação por <a href="https://github.com/claudiodeveloper-github">Cláudio G. S. Castro</a></sub>
</div>
