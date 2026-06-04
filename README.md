# 💰 Banco Digital API

<div align="center">
  <img src="banner-banco-digital-api.png" alt="Banner Banco Digital API" width="100%"/>

<br/><br/>

  <img src="https://readme-typing-svg.demolab.com?font=Fira+Code&size=28&duration=3000&pause=1000&color=00D9FF&center=true&vCenter=true&width=600&lines=%F0%9F%8F%A6+Banco+Digital+API;Spring+Boot+4.0+%7C+Java+21+%7C+MySQL;REST+API+%7C+Docker+%7C+JPA%2FHibernate" alt="Typing SVG" />

<br/><br/>

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.0.6-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-8.0-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-Compose-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![JPA](https://img.shields.io/badge/JPA_/_Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white)

<br/><br/>

![GitHub stars](https://img.shields.io/github/stars/claudiodeveloper-github/banco-digital-api?style=social)
![GitHub forks](https://img.shields.io/github/forks/claudiodeveloper-github/banco-digital-api?style=social)
![GitHub last commit](https://img.shields.io/github/last-commit/claudiodeveloper-github/banco-digital-api?color=00D9FF)
![Status](https://img.shields.io/badge/Status-Em_Desenvolvimento-00D9FF?style=flat-square)

</div>

---

## 📋 Índice

- [Sobre o Projeto](#-sobre-o-projeto)
- [Diferenciais Exclusivos](#-diferenciais-exclusivos--front-end-embutido)
- [Tecnologias Utilizadas](#-tecnologias-utilizadas)
- [Estrutura do Projeto](#-estrutura-do-projeto)
- [Endpoints da API](#-endpoints-da-api)
- [Regras de Negócio](#-regras-de-negócio)
- [Tratamento de Exceções](#-tratamento-de-exceções)
- [Como Executar](#-como-executar)
  - [🐳 Via Docker (Recomendado)](#-via-docker-recomendado--produção)
  - [💻 Via IDE (Desenvolvimento)](#-via-ide-desenvolvimento-nativo)
- [Autor](#-autor)
- [Licença](#-licença)

---

## 🏦 Sobre o Projeto

O **Banco Digital API** é uma solução RESTful robusta desenvolvida com **Spring Boot 4.x** e **Java 21**, projetada para simular operações bancárias essenciais do mundo real. O projeto aplica as melhores práticas de arquitetura em camadas no padrão **Controller → Service → Repository (Model)**, utilizando o ecossistema Spring para garantir alta coesão e baixo acoplamento entre os componentes.

A aplicação segue o padrão de documentação do repositório **Controller → Service → Repository (Model)**, separando claramente as responsabilidades entre as camadas de negócio, persistência e interface HTTP. O tratamento de exceções é feito com um interceptador global `@RestControllerAdvice` que captura falhas em toda a aplicação e as transforma em respostas JSON padronizadas, garantindo previsibilidade e clareza para o consumidor da API.

> 💡 **Diferencial técnico:** além de ser uma REST API funcional, o projeto conta com uma **Interface Client Interativa** embutida — servida diretamente pelo Spring Boot via `src/main/resources/static` — que permite disparar requisições reais ao servidor e monitorar o status da API em tempo real, sem nenhuma ferramenta externa.

---

## ✨ Diferenciais Exclusivos — Front-end Embutido

Esta API vai além de um simples backend. Ela inclui um **front-end interativo** servido diretamente pelo Spring Boot, que funciona como um client de demonstração completo, projetado para simular e visualizar todas as operações bancárias da API:

| Funcionalidade do Client | Descrição |
|---|---|
| 🟢 **Status em Tempo Real** | Monitora se a API está `ONLINE` ou `OFFLINE`, realizando um `GET /contas` ao vivo |
| 📋 **Simulador REST — POST /contas** | Preencha os campos, visualize o JSON gerado em tempo real e dispare a requisição |
| 🔍 **Busca de Conta — GET /contas/{numero}** | Consulte qualquer conta pelo número diretamente na interface |
| 💰 **Depósito Integrado — POST /contas/{numero}/deposito** | Campos de conta e valor com feedback instantâneo do servidor |
| 💻 **Server Response Viewer** | Exibe a resposta HTTP bruta retornada pelo `ContaController.java`, com botão de limpeza |

> **Acesse em:** `http://localhost:8080` após subir a aplicação. Nenhum Postman ou Insomnia necessário.

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia | Versão | Finalidade |
|---|---|---|
| **Java** | 21 | Linguagem de programação principal |
| **Spring Boot** | 4.0.6 | Framework base da aplicação |
| **Spring Web** | — | Criação dos endpoints REST |
| **Spring Data JPA** | — | Abstração da camada de persistência |
| **Hibernate** | — | Implementação do JPA / ORM |
| **MySQL / Docker** | 8.0 | Banco de dados relacional em container |
| **Lombok** | — | Redução de boilerplate (getters, construtores) |
| **Maven** | — | Gerenciamento de dependências e build |
| **Docker & Compose** | — | Containerização da API e do banco de dados |

---

## 📁 Estrutura do Projeto

```
banco-digital-api/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/claudio/bancodigital/
│   │   │       │
│   │   │       ├── controller/         # Camada REST — recebe e responde requisições HTTP
│   │   │       │   └── ContaController.java
│   │   │       │
│   │   │       ├── service/            # Camada de negócio — orquestra as regras da aplicação
│   │   │       │   └── ContaService.java
│   │   │       │
│   │   │       ├── repository/         # Camada de persistência — interface com o banco de dados
│   │   │       │   └── ContaRepository.java
│   │   │       │
│   │   │       ├── model/              # Entidades JPA — mapeamento das tabelas do banco
│   │   │       │   └── Conta.java
│   │   │       │
│   │   │       ├── exception/          # Tratamento global de erros com @RestControllerAdvice
│   │   │       │   ├── GlobalExceptionHandler.java
│   │   │       │   └── ContaNaoEncontradaException.java
│   │   │       │
│   │   │       └── BancoDigitalApplication.java   # Ponto de entrada da aplicação
│   │   │
│   │   └── resources/
│   │       ├── static/                 # ✨ Front-end interativo servido pelo Spring Boot
│   │       │   └── index.html
│   │       └── application.properties  # Configurações de banco, porta e JPA
│   │
│   └── test/                           # Testes unitários e de integração
│
├── docker-compose.yml                  # Orquestração dos containers (API + MySQL)
├── Dockerfile                          # Imagem da aplicação Spring Boot
├── pom.xml                             # Dependências e build Maven
└── README.md
```

---

## 🔌 Endpoints da API

**Base URL:** `http://localhost:8080`

| Método | Endpoint | Descrição | Status de Sucesso |
|:---:|---|---|:---:|
| `GET` | `/contas` | Lista todas as contas cadastradas | `200 OK` |
| `POST` | `/contas` | Cria uma nova conta bancária | `201 Created` |
| `GET` | `/contas/{numero}` | Busca uma conta específica pelo número | `200 OK` |
| `POST` | `/contas/{numero}/deposito?valor=` | Realiza um depósito na conta informada | `200 OK` |

### 📦 Exemplo de Payload — Criar Conta

```json
{
  "titular": "Cláudio Castro",
  "tipo": "CORRENTE",
  "saldo": 500
}
```

### ✅ Exemplo de Resposta — Conta Criada

```json
{
  "numero": 1,
  "titular": "Cláudio Castro",
  "tipo": "CORRENTE",
  "saldo": 500.00
}
```

---

## 📐 Regras de Negócio

A entidade principal da aplicação é a `CONTA (tb_contas)`, com os seguintes campos:

| Campo | Tipo | Restrição |
|---|---|---|
| `numero` | `Long` | Gerado automaticamente pelo banco de dados |
| `titular` | `String` | Não pode ser nulo ou em branco |
| `tipo` | `String` | Deve ser `CORRENTE` ou `POUPANÇA` |
| `saldo` | `Double` | Deve ser maior ou igual a zero no momento da criação |

- **[DEPÓSITO]** — Não são aceitos valores menores ou iguais a zero. Toda tentativa resulta em erro com status `400 Bad Request`.
- **[BUSCA]** — Se uma conta não for localizada pelo número informado, um erro padronizado é retornado com status `404 Not Found`.
- **[CRIAÇÃO]** — O número da conta é auto-incrementado pelo banco de dados; o cliente não deve informá-lo no payload.
- **[@GlobalExceptionHandler]** — Um interceptador global captura as exceptions da aplicação e as transforma em respostas JSON padronizadas para o consumidor da API.

---

## 🚨 Tratamento de Exceções

A aplicação conta com um interceptador `@RestControllerAdvice / @GlobalExceptionHandler` que captura e formata todas as falhas de forma padronizada.

| Exceção | Status HTTP | Cenário |
|---|:---:|---|
| `ContaNaoEncontradaException` | `404 Not Found` | Conta não localizada pelo número informado |
| `DepositoInvalidoException` | `400 Bad Request` | Tentativa de depósito com valor ≤ zero |
| `MethodArgumentNotValidException` | `400 Bad Request` | Payload enviado com campos inválidos ou ausentes |
| `HttpMessageNotReadableException` | `400 Bad Request` | Corpo da requisição malformado ou tipo inválido |

---

## 🚀 Como Executar

### Pré-requisitos

Certifique-se de ter instalado em sua máquina:

- [Git](https://git-scm.com/)
- [Docker Desktop](https://www.docker.com/products/docker-desktop/) *(para o modo Docker)*
- [JDK 21+](https://adoptium.net/) e [Maven 3.8+](https://maven.apache.org/) *(para o modo nativo)*

```bash
# 1. Clone o repositório
git clone https://github.com/claudiodeveloper-github/banco-digital-api.git

# 2. Acesse a pasta do projeto
cd banco-digital-api
```

---

### 🐳 Via Docker (Recomendado — Produção)

> O modo **Docker Compose** sobe a API Spring Boot e o banco MySQL 8.0 em containers isolados, sem precisar configurar nada localmente. Basta ter o Docker Desktop rodando.

**Passo a Passo:**

```bash
# 1. Gere o artefato .jar da aplicação
mvn clean package -DskipTests

# 2. Suba todos os containers com Docker Compose
docker compose up --build
```

A aplicação estará disponível em: **http://localhost:8080**

**Para encerrar os containers:**

```bash
docker compose down
```

**Para encerrar E remover os volumes (dados do banco):**

```bash
docker compose down -v
```

---

### 💻 Via IDE (Desenvolvimento Nativo)

> Use este modo durante o desenvolvimento ativo. Requer JDK 21 e Maven instalados localmente. O banco MySQL pode ser provisionado via Docker separadamente.

**Passo a Passo:**

**1. Suba apenas o banco MySQL via Docker:**

```bash
docker run -d \
  --name mysql-banco-digital \
  -e MYSQL_ROOT_PASSWORD=root \
  -e MYSQL_DATABASE=banco_digital \
  -p 3306:3306 \
  mysql:8.0
```

**2. Configure o banco no `application.properties`:**

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/banco_digital
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

**3. Execute a aplicação:**

```bash
mvn spring-boot:run
```

**4. Acesse a Interface Interativa no navegador:**

```
http://localhost:8080
```

---

## 👤 Autor

<div align="center">

<img src="https://github.com/claudiodeveloper-github.png" width="100" style="border-radius: 50%;" />

**Cláudio G. S. Castro**
*Java Backend Developer em Formação*

Desenvolvedor Backend em formação com foco em Java e Spring Boot.
Construindo APIs robustas com boas práticas, aprendendo continuamente e enfrentando desafios reais.

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/claudio-g-s-castro)
[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/claudiodeveloper-github)
[![Gmail](https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:claudiodeveloper007@gmail.com)

</div>

---

## 📄 Licença

Este projeto está licenciado sob a licença **MIT** — veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

<div align="center">

*Feito com ☕ Java e muito aprendizado por **Cláudio G. S. Castro***

⭐ Se este projeto te ajudou ou te inspirou, deixa uma estrela no repositório!

</div>
