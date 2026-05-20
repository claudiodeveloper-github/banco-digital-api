# Banco Digital API

![Java](https://img.shields.io/badge/Java-21-orange?style=flat-square)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.0.6-green?style=flat-square)
![Status](https://img.shields.io/badge/status-em%20desenvolvimento-blue?style=flat-square)
![License](https://img.shields.io/badge/license-MIT-green?style=flat-square)

API de Banco Digital desenvolvida com Spring Boot para simulação de operações bancárias básicas, estruturada com persistência de dados e uma interface client interativa.

---

## 💻 Interface de Testes Interativa (UI)

O projeto conta com um **Dashboard Client integrado** (HTML/CSS/JS) hospedado no próprio servidor do Spring Boot. Ele monitora o status da API em tempo real e permite disparar as requisições de criação de conta, busca e depósito diretamente do navegador.

* **Como acessar:** Com a aplicação rodando, abra o seu navegador e acesse:  
  `http://localhost:8080/index.html`

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java 21
* **Framework:** Spring Boot 4.0.6
* **Mapeamento/Persistência:** Spring Data JPA / Hibernate
* **Banco de Dados:** MySQL
* **Gerenciador de Conexões:** HikariCP
* **Gerenciador de Dependências:** Maven

---

## 🗄️ Configuração do Banco de Dados

Crie um arquivo chamado `application.properties` dentro do diretório `src/main/resources/` e adicione suas credenciais do MySQL local:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/banco_spring?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true