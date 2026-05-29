#  Banco Digital API

<p align="center">
  <img src="banner-banco-digital-api.png" alt="Banco Digital API Banner" width="100%">
</p>

##  Sobre o Projeto

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

Analisando o seu novo print, o problema principal foi resolvido: **o banner principal renderizou perfeitamente** e a tabela de tecnologias está linda!

Porém, as seções que vêm logo abaixo (**Estrutura do Projeto**, **Endpoints** e **Como Executar**) perderam toda a quebra de linha e viraram blocos de texto maciços. Isso acontece porque o Markdown do GitHub é bem exigente com o espaçamento: se você não deixar uma **linha em branco** antes e depois de listas, tabelas ou blocos de código, ele junta tudo no mesmo parágrafo.

Para deixar o seu repositório impecável e com a mesma legibilidade profissional dos seus outros projetos, vamos aplicar a formatação exata que o parser do GitHub precisa.

---

### 🛠️ Como corrigir agora para ficar definitivo:

1. Na página do seu repositório `banco-digital-api`, clique no ícone do **lápis** ✏️ para editar o `README.md`.
2. Apague tudo o que está do título `## 📂 Estrutura do Projeto` para baixo.
3. Copie o bloco de texto abaixo (que já está com os espaçamentos e correções de sintaxe corrigidos) e cole no lugar:

```markdown
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

---

## ⚙️ Funcionalidades e Regras de Negócio

* **Abertura de Contas:** Permite a criação de contas definindo o nome do titular, saldo inicial e tipo de conta (`CORRENTE` ou `POUPANÇA`).
* **Consulta Inteligente:** Localiza registros de contas específicos pelo número identificador, retornando respostas padronizadas em JSON.
* **Depósitos Seguros:** Processa incrementos financeiros nas contas com validações estritas (bloqueio automático de lançamentos negativos ou zerados).
* **Tratamento de Exceções Customizado:** Interceptador global que impede a exposição de falhas internas da JVM, traduzindo erros estruturais (ex: `ContaNaoEncontradaException`) em retornos amigáveis ao cliente com códigos HTTP corretos (`400`, `404`, `500`).

---

## 🔌 Endpoints da API

A API responde localmente na URL base: `http://localhost:8080`

| Método | Endpoint | Descrição | Status HTTP |
| --- | --- | --- | --- |
| GET | `/contas` | Lista todas as contas cadastradas | `200 OK` |
| GET | `/contas/{numero}` | Busca uma conta pelo número id | `200 OK` / `404 Not Found` |
| POST | `/contas` | Registra uma nova conta no sistema | `201 Created` / `400 Bad Request` |
| POST | `/contas/{numero}/deposito?valor=` | Efetua um depósito na conta | `200 OK` / `400 Bad Request` |

---

## 🖥️ Simulador REST e Health Monitor Embutido

A aplicação conta com um painel web acoplado. Sempre que a API estiver rodando, você pode acessar `http://localhost:8080/index.html` (ou apenas abrir o arquivo localmente) para visualizar a interface:

* **Monitor de Status:** Um medidor assíncrono executa ping no servidor a cada 15 semestres/segundos, exibindo um badge dinâmico `ONLINE` ou `OFFLINE`.
* **Disparador de Payloads:** Campos interativos geram a estrutura de dados JSON em tempo real na tela, permitindo submeter requisições de teste instantâneas.
* **Console do Servidor:** Exibe a resposta estruturada retornada pelos métodos do `ContaController.java` simulando um terminal de depuração.

---

## 🚀 Como Executar o Projeto

### Pré-requisitos

* **Java 21** instalado.
* **Maven 3.x** configurado.
* **MySQL Server** em execução.

### 1. Preparar o Banco de Dados

Acesse o seu console MySQL e crie o esquema utilizado pela aplicação:

```sql
CREATE DATABASE banco_spring;

```

### 2. Configurar as Credenciais

Se necessário, edite o arquivo `src/main/resources/application.properties` ajustando os parâmetros do seu ambiente:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/banco_spring?useSSL=false&serverTimezone=UTC
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

```

### 3. Buildar e Inicializar o Sistema

No diretório raiz do projeto, execute os comandos através do terminal:

```bash
mvn clean install
mvn spring-boot:run

```

Aguarde a mensagem no console confirmando a inicialização bem-sucedida: `Started BancoDigitalApiApplication`.

---

## ✒️ Autor

* **Cláudio G. S. Castro** — *Java Backend Developer em Formação* — [GitHub Profile](https://github.com/claudiodeveloper-github)

---

## 📄 Licença

Este projeto é distribuído sob a licença **MIT**. Consulte o arquivo `LICENSE` anexado para obter mais informações detalhadas.

```

---

4. Clique no botão verde **Commit changes...** para salvar as alterações diretamente no repositório principal.

### O que mudou aqui:
* **Árvore de arquivos corrigida:** O bloco de texto confuso foi encapsulado em uma tag de código limpa (` ```text `), fazendo com que a hierarquia de pastas do seu projeto Java apareça estruturada.
* **Tabela de Endpoints gerada:** Agora os métodos HTTP (`GET`, `POST`) ganharam seus respectivos blocos visuais e descrições tabuladas corretas, facilitando a vida do recrutador.
* **Passos destacados:** A seção de execução foi dividida por títulos e blocos de código isolados para os comandos de banco e terminal.

```

Funcionalidades e Regras de Negócio
 
* Abertura de Contas: Permite a criação de contas definindo o nome do titular, saldo inicial e tipo de conta (CORRENTE ou POUPANÇA).

* Consulta Inteligente: Localiza registros de contas específicos pelo número identificador, retornando respostas padronizadas em JSON.

* Depósitos Seguros: Processa incrementos financeiros nas contas com validações estritas (bloqueio automático de lançamentos negativos ou zerados).

* Tratamento de Exceções Customizado: Interceptador global que impede a exposição de falhas internas da JVM, traduzindo erros estruturais (ex: ContaNaoEncontradaException) em retornos amigáveis ao cliente com códigos HTTP corretos (400, 404, 500).

Endpoints da APIA API responde localmente na URL base: http://localhost:8080MétodoEndpointDescriçãoStatus HTTPGET/contasLista todas as contas cadastradas200 OKGET/contas/{numero}Busca uma conta pelo número id200 OK / 404 Not FoundPOST/contasRegistra uma nova conta no sistema201 Created / 400 Bad RequestPOST/contas/{numero}/deposito?valor=Efetua um depósito na conta200 OK / 400 Bad Request

Simulador REST e Health Monitor Embutido
A aplicação conta com um painel web acoplado. Sempre que a API estiver rodando, você pode acessar http://localhost:8080/index.html (ou apenas abrir o arquivo localmente) para visualizar a interface:

Monitor de Status: Um medidor assíncrono executa ping no servidor a cada 15 segundos, exibindo um badge dinâmico ONLINE ou OFFLINE.

Disparador de Payloads: Campos interativos geram a estrutura de dados JSON em tempo real na tela, permitindo submeter requisições de teste instantâneas.

Console do Servidor: Exibe a resposta estruturada retornada pelos métodos do ContaController.java simulando um terminal de depuração.

Como Executar o Projeto
Pré-requisitos
Java 21 instalado.

Maven 3.x configurado.

MySQL Server em execução.

1. Preparar o Banco de Dados
Acesse o seu console MySQL e crie o esquema utilizado pela aplicação:

CREATE DATABASE banco_spring;

2. Configurar as Credenciais
Se necessário, edite o arquivo src/main/resources/application.properties ajustando os parâmetros do seu ambiente:

spring.datasource.url=jdbc:mysql://localhost:3306/banco_spring?useSSL=false&serverTimezone=UTC
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

3. Buildar e Inicializar o Sistema
No diretório raiz do projeto, execute os comandos através do terminal:

mvn clean install
mvn spring-boot:run

Aguarde a mensagem no console confirmando a inicialização bem-sucedida: Started BancoDigitalApiApplication.

Autor
Cláudio G. S. Castro — Java Backend Developer em Formação — GitHub Profile

Licença
Este projeto é distribuído sob a licença MIT. Consulte o arquivo LICENSE anexado para obter mais informações detalhadas.
