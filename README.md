# Banco Digital API

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green)
![Status](https://img.shields.io/badge/status-em%20desenvolvimento-blue)
![License](https://img.shields.io/badge/license-MIT-green)

API de Banco Digital desenvolvida com Spring Boot para operações bancárias básicas.

Bem-vindo ao Banco Digital API!  
Este projeto foi desenvolvido em Spring Boot para simular operações bancárias básicas, como criação de contas, depósitos e consultas.  
A ideia é oferecer uma base sólida para quem deseja aprender ou evoluir em aplicações Java com integração ao MySQL.

***

##  Tecnologias utilizadas
- Java 21
- Spring Boot 4.0.6
- Spring Data JPA / Hibernate
- MySQL
- HikariCP (pool de conexões)

***

## Configuração do Banco de Dados

Crie um arquivo `application.properties` em `src/main/resources` 
com suas credenciais locais:

properties
spring.datasource.url=jdbc:mysql://localhost:3306/banco_spring?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

 Importante: nunca suba suas credenciais reais para o GitHub.
Use o arquivo application.properties.example como referência.

*****************************************
Como rodar a aplicação:
1- Clone o repositório: git clone https://github.com/seu-usuario/banco-digital-api.git
cd banco-digital-api
2- Configure o banco MySQL: CREATE DATABASE banco_spring;
3- Crie o arquivo application.properties com suas credenciais.
4- Rode a aplicação: mvn spring-boot:run
*****************************************
A aplicação estará disponível em: http://localhost:8080
*****************************************
Endpoints principais
Criar conta  
POST /contas  
Body (JSON):
==========================================
{
  "numero": 1,
  "agencia": 123,
  "nomeCliente": "João Silva",
  "dataNascimento": "1990-01-01"
}
===========================================
Buscar conta  
GET /contas/{numero}

Depositar valor  
POST /contas/{numero}/deposito?valor=500.00
********************************************
Segurança: 
As credenciais do banco devem ser configuradas via variáveis de ambiente (DB_USER, DB_PASS) ou em application.properties local.
O arquivo application.properties está no .gitignore e não deve ser versionado.
********************************************
Objetivo:
Este projeto é voltado para aprendizado e prática de Spring Boot + JPA + MySQL.
Sinta-se à vontade para contribuir, abrir issues ou sugerir melhorias!







