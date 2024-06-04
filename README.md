# CanalStreaming

Bem-vindo ao CanalStreaming! Este é um projeto de exemplo de um aplicativo de streaming de filmes e séries, onde os usuários podem pesquisar e favoritar seus filmes e séries favoritos.

## Como executar o projeto

Para executar este projeto localmente, siga estas etapas:

1. Certifique-se de ter o Java e o Maven instalados em sua máquina.

2. Clone este repositório em sua máquina local:

   ```bash
   git clone https://github.com/seu-usuario/CanalStreaming.git
   
3. Navegue até o diretório do projeto:

   ```bash
   cd CanalStreaming
   
4. Abra o projeto em sua IDE de escolha (por exemplo, IntelliJ IDEA, Eclipse).

5. Configure as variáveis de ambiente necessárias. Crie um arquivo `.env` na raiz do projeto com as seguintes variáveis:

   ```bash
   TMDB_API_KEY=020439ffadded454f398a9c9f34ac978
   
6. Execute o projeto. Você pode fazer isso pela IDE ou executando o seguinte comando Maven na raiz do projeto:

   ```bash
   mvn spring-boot:run
  Certifique-se de ter o Maven instalado em seu sistema. Você pode instalá-lo seguindo as instruções em Maven Installation.
  
7. Após a inicialização, você poderá acessar o aplicativo em [[http://localhost:8080](http://localhost:8080/swagger-ui/index.html#/).

8. Divirta-se explorando e experimentando as funcionalidades do CanalStreaming!

## Funcionalidades

- **Pesquisa de Filmes e Séries:** Os usuários podem pesquisar filmes e séries por nome.
  
- **Favoritos:** Os usuários podem favoritar filmes e séries e acessar uma lista de favoritos.

- **Ordenação de Favoritos:** Os usuários podem ordenar sua lista de favoritos por título.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Thymeleaf
- RESTful APIs
- Hibernate
- H2 Database (para armazenamento em memória)
- Maven

## Contribuindo
- Arsidney Martins Rocha
- Tiago Oliveira Lelis Dos Santos
- João Eduardo Evangelista Elias
