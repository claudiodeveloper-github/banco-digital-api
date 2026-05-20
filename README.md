# Banco Digital API

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.6-brightgreen)
![Status](https://img.shields.io/badge/status-em%20desenvolvimento-yellow)
![License](https://img.shields.io/badge/license-MIT-green)

API de Banco Digital desenvolvida com Spring Boot para simulação de operações
bancárias básicas, estruturada com persistência de dados e uma interface
client interativa.

## Sobre o Projeto

Este projeto foi desenvolvido para praticar a construção de APIs REST utilizando
Java, arquitetura em camadas (Controller, Service, Repository) e integração
com banco de dados relacional.

## Interface de Testes Interativa (UI)

O projeto conta com um Dashboard Client integrado (HTML/CSS/JS) hospedado no
próprio servidor do Spring Boot. Ele monitora o status da API em tempo real e
permite disparar requisições de criação de conta, busca e depósito sem
necessidade obrigatória do Postman.

- **Como acessar:** Com a aplicação rodando, abra seu navegador e acesse:
  `http://localhost:8080/index.html`

## Tecnologias Utilizadas

- **Linguagem:** Java 21
- **Framework:** Spring Boot 4.0.6
- **Mapeamento/Persistência:** Spring Data JPA / Hibernate
- **Banco de Dados:** MySQL
- **Gerenciador de Conexões:** HikariCP
- **Gerenciador de Dependências:** Maven

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
# 1. Clone o repositório
git clone https://github.com/claudiodeveloper-github/banco-digital-api.git

# 2. Entre na pasta
cd banco-digital-api

# 3. Rode com Maven
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

Este projeto é voltado para aprendizado e prática de Spring Boot + JPA + MySQL.
Sinta-se à vontade para contribuir, abrir issues ou sugerir melhorias!