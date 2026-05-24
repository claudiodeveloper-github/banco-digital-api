<p align="center">
  <img src="banner-banco-digital-api.png" alt="Banco Digital API">
</p>

<br>

# Banco Digital API

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.0.6-6DB33F?style=for-the-badge&logo=springboot)
![MySQL](https://img.shields.io/badge/MySQL-Database-4479A1?style=for-the-badge&logo=mysql)
![API REST](https://img.shields.io/badge/API-REST-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/status-em_desenvolvimento-yellow?style=for-the-badge)
![License](https://img.shields.io/badge/license-MIT-green?style=for-the-badge)

API de Banco Digital desenvolvida com Spring Boot para simulação de operações
bancárias básicas, estruturada com persistência de dados e uma interface
client interativa.

## Sobre o Projeto

O Banco Digital API é uma aplicação backend desenvolvida com Spring Boot para simulação de operações bancárias básicas.

O projeto foi construído seguindo arquitetura em camadas (Controller, Service e Repository), utilizando persistência de dados com Spring Data JPA e MySQL.

Além da API REST, o sistema possui uma interface client integrada para testes interativos das operações bancárias.


## Interface de Testes Interativa (UI)

O projeto conta com um Dashboard Client integrado (HTML/CSS/JS) hospedado no
próprio servidor do Spring Boot. Ele monitora o status da API em tempo real e
permite disparar requisições de criação de conta, busca e depósito sem
necessidade obrigatória do Postman.

- **Como acessar:** Com a aplicação rodando, abra seu navegador e acesse:
  `http://localhost:8080/index.html`

## Tecnologias Utilizadas

| Tecnologia | Função |
|---|---|
| Java 21 | Linguagem principal |
| Spring Boot 4 | Framework backend |
| Spring Data JPA | Persistência |
| Hibernate | ORM |
| MySQL | Banco de dados |
| HikariCP | Pool de conexões |
| Maven | Gerenciamento de dependências |

## Configuração do Banco de Dados

Crie um arquivo `application.properties` dentro de `src/main/resources/`
e adicione suas credenciais do MySQL local:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/banco_spring?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.open-in-view=false
```

> **Crie o banco antes de rodar:**
> `CREATE DATABASE banco_spring;`

## Como Rodar a Aplicação

```bash
# 1. Clone
git clone https://github.com/claudiodeveloper-github/banco-digital-api.git

# 2. configuração
cd banco-digital-api

# 3. execução
mvn spring-boot:run
```

A aplicação estará disponível em: `http://localhost:8080`

## Endpoints Principais

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/contas` | Criar nova conta |
| GET | `/contas/{numero}` | Buscar conta por número |
| GET | `/contas` | Listar todas as contas |
| POST | `/contas/{numero}/deposito?valor=500.00` | Depositar valor |

**Exemplo de body para criar conta (POST /contas):**
```json
{
  "titular": "João Silva",
  "tipo": "CORRENTE",
  "saldo": 500.00
}
```

## Objetivo

Este projeto foi desenvolvido com foco em aprendizado prático de desenvolvimento backend utilizando Java e Spring Boot.

O objetivo é consolidar conhecimentos em:
- APIs REST
- Arquitetura em camadas
- Persistência com JPA/Hibernate
- Integração com banco de dados
- Boas práticas de desenvolvimento backend

## Funcionalidades

- Criar contas bancárias
- Buscar conta por número
- Listar contas cadastradas
- Realizar depósitos
- Persistência em banco MySQL
- Interface client integrada
- API REST estruturada

## Estrutura do Projeto

```text
src/main/java/com/claudiocastro/banco/api/
├── controller/
├── service/
├── repository/
├── model/
└── exception/
```

## Autor

Cláudio G. S. Castro  
Backend Developer em formação

[LinkedIn]([LINK](https://www.linkedin.com/in/claudio-g-s-castro/))

## Licença

Este projeto está sob a licença MIT.




