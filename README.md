Em Cnstrucao
# 🪐 Banco Digital API

<p align="center">
  <img src="banner-banco-digital-api.png" alt="Banco Digital API Banner" width="100%">
</p>

## 💻 Sobre o Projeto

O **Banco Digital API** é uma solução RESTful robusta desenvolvida com **Spring Boot 3.x** e **Java 21**, projetada para gerenciar operações essenciais de uma estrutura bancária simplificada, como criação de contas, consulta de saldos e depósitos transacionais.

O grande diferencial deste repositório é a inclusão de uma **Interface Client Interativa integrada** (`index.html`), hospedada diretamente nos recursos estáticos da aplicação. Ela atua como um simulador REST e monitor de saúde integrado, permitindo testar todos os endpoints em tempo real diretamente pelo navegador sem a necessidade de ferramentas externas como Postman ou Insomnia.

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia | Versão | Finalidade |
| :--- | :--- | :--- |
| **Java** | 21 | Linguagem de programação principal |
| **Spring Boot** | 3.x | Framework base da aplicação |
| **Spring Data JPA** | 3.x | Camada de persistência e ORM (Hibernate) |
| **MySQL Driver** | 8.0.x | Driver de conexão com o banco de dados |
| **Lombok** | — | Produtividade e redução de código boilerplate |
| **Maven** | 3.x | Gerenciador de dependências e build |

---

## 📂 Estrutura do Projeto

A arquitetura segue o padrão de desenvolvimento em camadas (Controller-Service-Repository-Model) associado a um tratamento global de exceções, garantindo baixo acoplamento e separação estrita de responsabilidades:

```text
banco-digital-api/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/claudiocastro/banco/api/
│   │   │       ├── controller/        # Exposição dos endpoints REST
│   │   │       ├── exception/         # Tratamento global de erros customizados
│   │   │       ├── model/             # Entidades mapeadas no banco de dados
│   │   │       ├── repository/        # Interfaces de persistência (Spring Data JPA)
│   │   │       ├── service/           # Camada de regras de negócio da aplicação
│   │   │       └── BancoDigitalApiApplication.java # Classe de inicialização
│   │   └── resources/
│   │       ├── static/
│   │       │   └── index.html         # Painel Front-end/Simulador REST integrado
│   │       └── application.properties # Parâmetros de infraestrutura do sistema
│   └── test/                          # Ambiente de testes unitários e de contexto
└── pom.xml                            # Manifesto de dependências do Maven

```
Funcionalidades e Regras de Negócio
Abertura de Contas: Permite a criação de contas definindo o nome do titular, saldo inicial e tipo de conta (CORRENTE ou POUPANÇA).

Consulta Inteligente: Localiza registros de contas específicos pelo número identificador, retornando respostas padronizadas em JSON.

Depósitos Seguros: Processa incrementos financeiros nas contas com validações estritas (bloqueio automático de lançamentos negativos ou zerados).

Tratamento de Exceções Customizado: Interceptador global que impede a exposição de falhas internas da JVM, traduzindo erros estruturais (ex: ContaNaoEncontradaException) em retornos amigáveis ao cliente com códigos HTTP corretos (400, 404, 500).

