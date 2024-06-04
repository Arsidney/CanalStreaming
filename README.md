CanalStreaming

Bem-vindo ao CanalStreaming! Este é um projeto de exemplo de um aplicativo de streaming de filmes e séries, onde os usuários podem pesquisar e favoritar seus filmes e séries favoritos.

Como executar o projeto

Para executar este projeto localmente, siga estas etapas:

Certifique-se de ter o Java e o Maven instalados em sua máquina.

Clone este repositório em sua máquina local:

bash

Copy code

git clone https://github.com/seu-usuario/CanalStreaming.git
Navegue até o diretório do projeto:


bash

Copy code

cd CanalStreaming

Abra o projeto em sua IDE de escolha (por exemplo, IntelliJ IDEA, Eclipse).

Configure as variáveis de ambiente necessárias. Crie um arquivo .env na raiz do projeto com as seguintes variáveis:

TMDB_API_KEY=sua-api-key-do-TMDB

Substitua sua-api-key-do-TMDB pela sua chave de API do TMDB. Você pode obter uma em themoviedb.org.

Execute o projeto. Você pode fazer isso pela IDE ou executando o seguinte comando Maven na raiz do projeto:

mvn spring-boot:run

Após a inicialização, você poderá acessar o aplicativo em http://localhost:8080.

Divirta-se explorando e experimentando as funcionalidades do CanalStreaming!

Funcionalidades:

Pesquisa de Filmes e Séries: Os usuários podem pesquisar filmes e séries por nome.

Favoritos: Os usuários podem favoritar filmes e séries e acessar uma lista de favoritos.

Ordenação de Favoritos: Os usuários podem ordenar sua lista de favoritos por título.

Tecnologias Utilizadas

Java

Spring Boot

Spring Data JPA

Thymeleaf

RESTful APIs

Hibernate

H2 Database (para armazenamento em memória)

Maven

Contribuindo

- Arsidney Martins Rocha
- Tiago Oliveira Lelis Dos Santos
- João Eduardo Evangelista Elias
