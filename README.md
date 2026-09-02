# Sistema de Gestão da Biblioteca Municipal

Sistema informático baseado em consola, desenvolvido em Java, para apoiar a
Biblioteca Municipal na gestão do seu catálogo de livros e no controlo de
empréstimos aos utilizadores.

## Descrição

Com o aumento do número de leitores, a Biblioteca Municipal precisava de
substituir o registo manual por um sistema automatizado. Este programa
permite aos bibliotecários registar livros, consultar o catálogo (por
listagem completa ou pesquisa por título/autor), registar utilizadores,
gerir empréstimos e devoluções, e consultar estatísticas de utilização
(livro mais emprestado e total de requisições).

A base de dados é simulada inteiramente em memória, usando vectores
(arrays) para armazenar livros, utilizadores e empréstimos, e uma matriz
bidimensional para contar os empréstimos de cada livro por mês do ano.

## Requisitos

- Java Development Kit (JDK) 17 ou superior instalado.

Para confirmar se já tens o Java instalado, abre o terminal (cmd) e escreve:


Se aparecer um número de versão em ambos, já tens tudo o que precisas. Caso
contrário, descarrega o JDK em https://adoptium.net

## Como executar

1. Descarrega ou clona este repositório para o teu computador.
2. Abre o terminal (cmd) dentro da pasta do projecto.
3. Compila todos os ficheiros Java:


4. Executa o programa:


5. Segue o menu interactivo apresentado na consola.