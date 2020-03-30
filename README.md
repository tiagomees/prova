# Prémio Pior Filme
Prémio Pior Filme (uma categoria do Golden Raspberry Awards).

Para o denvolvimento do projeto, foi desenvolvido uma API RESTful responsável pela manulipulação dos dados através dos métodos GET, POST e DELETE. 

- [Ferramentas Usadas](#ferramentas-usadas)
- [Como executar](#como-executar)
- [Erros](#erros)
- [Recursos](#recursos)

## Ferramentas Usadas

- IDE de Desenvolvimento: [IntelliJ IDEA](https://www.jetbrains.com/idea/)
- Gerenciador de Dependências: [Maven 3.6.3](https://maven.apache.org/)
- Framework para desenvolvimento da API: [Spring Boot 2.1](https://spring.io/projects/spring-boot)
- Servidor de Aplicação: [Apache Tomcat 9.0.31](http://tomcat.apache.org/)
- Testes da API RESTful: [Postman](https://www.getpostman.com/) 

## Como Executar

- Instalar a IDE 
- Instalar o servidor de aplicação [Apache Tomcat 9.0.31](http://tomcat.apache.org/)

- URL Base: http://localhost:8080/

- A porta pode ou não mudar dependendo da escolha durante a instalação do servidor de aplicação.

- O deploy do projeto pode ocorrer de duas maneira: a convencional que é gerar o ".war" e realizar o deploy em um servidor de aplicação externo ou gerar um arquivo ".jar" e utilizar o suporte do Spring encapsular Tomcat.  

## Erros

<p>Status code do protocolo HTTP, disponíveis no header de cada response.</p>
<p><code>200 OK</code> Tudo funcionou como esperado.</p>
<p><code>201 OK</code> O Recurso foi criado com sucesso.</p>
<p><code>400 Bad Request</code> Problema com os parâmetros.</p>
<p><code>404 Not Found</code> O recurso acessado não existe.</p>
<p><code>500 Server errors</code> Algum erro no servidor, causado por erro meu.</p>

## Recursos

<h3>
<a id="user-content-listagem-de-todos-os-amigos" class="anchor" href="#listagem-de-todos-os-amigos" aria-hidden="true"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>Winners</h3>
<p>Permite obter todos os filmes.</p>
<p><strong>Resource URL</strong></p>
<p><code>GET http://localhost:8080/filmes/</code></p>
<p><strong>Parâmetros</strong></p>
<ul>
<li>Nenhum</li>
</ul>
<p><strong>Exemplo de Requisição</strong></p>
<p><code>http://localhost:8080/filmes</code></p>
<p><strong>Exemplo de Resposta</strong></p>
<pre><code>[
    {
        "id": 1,
        "year": 1980,
        "title": "Can't Stop the Music",
        "studios": [
            "Associated Film Distribution"
        ],
        "producers": [
            "Allan Carr"
        ],
        "winner": true
    }
]</code></pre>
<h3>

<h3>
<a id="user-content-listagem-de-todos-os-amigos" class="anchor" href="#listagem-de-todos-os-amigos" aria-hidden="true"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>Years</h3>
<p>Permite obter o filme desejado, utilizando o ID como filtro</p>
<p><strong>Resource URL</strong></p>
<p><code>GET http://localhost:8080/filmes/{id}</code></p>
<p><strong>Parâmetros</strong></p>
<ul>
<li><strong>Id</strong> - Obrigário para localizar o filme desejado.</li>
</ul>
<p><strong>Exemplo de Requisição</strong></p>
<p><code>http://localhost:8080/filmes/1</code></p>
<p><strong>Exemplo de Resposta</strong></p>
<pre><code>{
    "id": 1,
    "year": 1980,
    "title": "Can't Stop the Music",
    "studios": [
        "Associated Film Distribution"
    ],
    "producers": [
        "Allan Carr"
    ],
    "winner": true
}</code></pre>
<h3>

<h3>
<a id="user-content-listagem-de-todos-os-amigos" class="anchor" href="#listagem-de-todos-os-amigos" aria-hidden="true"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>Studios</h3>
<p>Permite obter todos os filmes vencedores</p>
<p><strong>Resource URL</strong></p>
<p><code>GET http://localhost:8080/vencedores</code></p>
<p><strong>Parâmetros</strong></p>
<ul>
<li>Nenhum</li>
</ul>
<p><strong>Exemplo de Requisição</strong></p>
<p><code>http://localhost:8080/vencedores</code></p>
<p><strong>Exemplo de Resposta</strong></p>
<pre><code>{
    "studios": [
        {
        "id": 1,
        "year": 1980,
        "title": "Can't Stop the Music",
        "studios": [
            "Associated Film Distribution"
        ],
        "producers": [
            "Allan Carr"
        ],
        "winner": true
    }
    ]
}</code></pre>
<h3>

<h3>
<a id="user-content-listagem-de-todos-os-amigos" class="anchor" href="#listagem-de-todos-os-amigos" aria-hidden="true"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>Producers</h3>
<p>Obter o produtor com maior intervalo entre dois prêmios, e o que obteve dois prêmios mais rápido.</p>
<p><strong>Resource URL</strong></p>
<p><code>GET http://localhost:8080/produtoras</code></p>
<p><strong>Parâmetros</strong></p>
<ul>
<li>Nenhum</li>
</ul>
<p><strong>Exemplo de Requisição</strong></p>
<p><code>http://localhost:8080/produtoras</code></p>
<p><strong>Exemplo de Resposta</strong></p>
<pre><code>{
    "min": {
        "producer": "Bo Derek",
        "interval": 6,
        "previousWin": 1984,
        "followingWin": 1990
    },
    "max": {
        "producer": "Matthew Vaughn",
        "interval": 13,
        "previousWin": 2002,
        "followingWin": 2015
    }
}</code></pre>
<h3>

<h3>
<a id="user-content-listagem-de-todos-os-amigos" class="anchor" href="#listagem-de-todos-os-amigos" aria-hidden="true"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>Movies</h3>
<p>Permiter deletar um filme da lista.</p>
<p><strong>Resource URL</strong></p>
<p><code>DELETE http://localhost:8080/excluirFilme/{id}</code></p>
<p><strong>Parâmetros</strong></p>
<ul>
<li><strong>Id</strong> - Obrigário para poder excluir o filme.</li>
</ul>
<p><strong>Exemplo de Requisição</strong></p>
<p><code>http://localhost:8080/excluirFilme/1</code></p>
<p><strong>Exemplo de Resposta</strong></p>
<pre>
<p><code>200 OK</code> Tudo funcionou porém não há informação a ser retornada.</p>
</pre>
<h3>

