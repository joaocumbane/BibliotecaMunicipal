# 1. Introdução

O presente documento constitui a documentação técnica do Trabalho de Campo
da disciplina de Introdução a Algoritmos e Programação, do curso de
Licenciatura em Engenharia Informática da Universidade Aberta ISCED
(UnISCED). O trabalho consistiu no desenvolvimento de um sistema
informático, baseado em consola, destinado a apoiar a Biblioteca Municipal
na gestão do seu inventário de livros e no histórico de empréstimos aos
utilizadores.

Com o crescimento do número de leitores, tornou-se necessário substituir
os processos manuais por uma solução automatizada, capaz de organizar o
catálogo de obras, gerir os utilizadores registados e controlar de forma
fiável as operações de empréstimo e devolução. O sistema foi desenvolvido
em linguagem Java, utilizando vectores e uma matriz bidimensional para
simular uma base de dados em memória.

## 1.1. Objectivos

### Objectivo Geral

Desenvolver um sistema informático em linguagem Java, baseado em consola,
que permita à Biblioteca Municipal gerir de forma automatizada e fiável o
seu catálogo de livros, os seus utilizadores e o processo de empréstimo e
devolução de obras.

### Objectivos Específicos

- Implementar o registo de livros, com identificador único, título, autor,
  ano de publicação e quantidade disponível;
- Implementar a consulta do catálogo, permitindo listar todos os livros ou
  pesquisar por autor e/ou título;
- Implementar o registo de utilizadores da biblioteca;
- Implementar a gestão de empréstimos, com actualização automática da
  quantidade de exemplares disponíveis e registo da respectiva devolução;
- Implementar estatísticas capazes de identificar o livro mais emprestado
  e o número total de livros requisitados;
- Aplicar vectores e matrizes na simulação de uma base de dados em memória;
- Garantir tratamento de erros robusto, evitando a interrupção inesperada
  do programa perante dados inválidos.

# 2. Referencial Teórico

O desenvolvimento deste trabalho apoiou-se nos conteúdos leccionados na
disciplina de Introdução a Algoritmos e Programação, em particular nos
temas relativos a estruturas de dados, variáveis, operadores e lógica de
programação, tal como apresentados no manual da disciplina do curso de
Licenciatura em Engenharia Informática da UnISCED (UnISCED, s.d.).

## 2.1. Algoritmos e Lógica de Programação

Um algoritmo pode ser entendido como uma sequência finita e ordenada de
passos, bem definidos, que conduzem à resolução de um determinado
problema. A lógica de programação constitui a base do raciocínio
necessário para transformar essa sequência de passos em instruções
compreensíveis por um computador (UnISCED, s.d.).

## 2.2. Estruturas de Dados: Vectores e Matrizes

Os vectores (arrays unidimensionais) e as matrizes (arrays
bidimensionais) permitem armazenar múltiplos valores do mesmo tipo sob
um único identificador, sendo acedidos através de um índice numérico.
Esta característica torna-as adequadas à simulação de bases de dados em
memória, quando não se pretende recorrer a um sistema de gestão de bases
de dados externo (UnISCED, s.d.).

No sistema desenvolvido, os vectores foram utilizados para armazenar as
colecções de Livros, Utilizadores e Empréstimos, ao passo que uma matriz
bidimensional foi utilizada para acumular o número de empréstimos de
cada livro, distribuído pelos doze meses do ano — estrutura que serve de
base ao cálculo das estatísticas do sistema.

## 2.3. Programação Orientada a Objectos em Java

A linguagem Java segue o paradigma da Programação Orientada a Objectos
(POO), no qual os dados e os comportamentos associados são organizados
em classes. Este paradigma favorece a modularidade, a reutilização de
código e a manutenção do software, na medida em que cada classe é
responsável por representar uma entidade do domínio do problema.

No presente trabalho, este princípio foi aplicado através da criação das
classes Livro, Utilizador e Emprestimo — que representam as entidades do
domínio — e da classe Biblioteca, responsável por gerir as colecções
destas entidades e pela lógica de negócio do sistema.

## 2.4. Tratamento de Excepções

O tratamento de excepções é um mecanismo da linguagem Java que permite
capturar e responder a situações de erro em tempo de execução (como a
introdução de dados num formato inesperado), sem que o programa termine
de forma abrupta. Este mecanismo é essencial em sistemas interactivos,
nos quais a fiabilidade perante a introdução incorrecta de dados pelo
utilizador é um requisito de qualidade do software.

# 3. Metodologia de Pesquisa e de Desenvolvimento de Software

## 3.1. Metodologia de Pesquisa

Para a realização deste trabalho foi adoptada uma abordagem de pesquisa
bibliográfica e aplicada. A componente bibliográfica consistiu na
consulta do manual da disciplina de Introdução a Algoritmos e Programação
da UnISCED, com vista à consolidação dos conceitos de estruturas de
dados, orientação a objectos e tratamento de excepções. A componente
aplicada consistiu na implementação prática destes conceitos, testada de
forma incremental ao longo do desenvolvimento, com recurso a consultas
pontuais sempre que surgiam dúvidas específicas sobre a sintaxe da
linguagem Java.

## 3.2. Metodologia de Desenvolvimento de Software

Optou-se pela adopção de uma metodologia de desenvolvimento incremental,
em detrimento do modelo em cascata tradicional. Esta escolha justifica-se
pela dimensão e pela natureza académica do projecto, que beneficiou de
ciclos curtos de implementação, teste e refinamento, permitindo
identificar e corrigir erros logo nas fases iniciais do desenvolvimento.

O desenvolvimento foi organizado nas seguintes etapas:

- Análise do enunciado e levantamento dos requisitos funcionais (registo
  de livros, consulta de catálogo, gestão de empréstimos e estatísticas);
- Modelação das entidades do domínio (Livro, Utilizador, Emprestimo) e da
  classe responsável pela gestão dos dados (Biblioteca);
- Implementação incremental de cada classe, começando pelas entidades
  mais simples (Livro, Utilizador, Emprestimo) e avançando progressivamente
  para a classe Biblioteca e para o menu interactivo (Main), com testes
  manuais através da consola após cada etapa, antes de se avançar para a
  seguinte;
- Implementação do tratamento de erros e validação de dados de entrada,
  após se testarem os cenários em que o utilizador introduz dados
  inválidos;
- Testes finais de integração, simulando um cenário completo de
  utilização do sistema por um bibliotecário;
- Elaboração da documentação técnica e organização do repositório no
  GitHub.

Quanto à arquitectura de dados, optou-se por representar a base de dados
em memória através de vectores com um contador de elementos ocupados
(`totalLivros`, `totalUtilizadores`, `totalEmprestimos`), em vez de se
recorrer directamente às colecções dinâmicas da biblioteca padrão do
Java (como `ArrayList`). Esta escolha teve como objectivo evidenciar de
forma mais directa o domínio das estruturas de dados de base — vectores e
matrizes — tal como exigido no enunciado do trabalho de campo.

# 4. Desenvolvimento

Nesta secção apresenta-se, através de capturas de ecrã da execução em
consola, o funcionamento das principais funcionalidades implementadas.

## 4.1. Registo de Livros e Tratamento de Erros

A opção 1 do menu permite registar um novo livro, atribuindo
automaticamente um identificador único. A captura seguinte demonstra
também o tratamento de erros do sistema: ao introduzir "2003,4" no campo
do ano de publicação (um valor não numérico), o sistema recusa a entrada
e solicita novamente um número válido, sem interromper o programa:

![Registo de livro com tratamento de erro](Erro1.png)

## 4.2. Consulta do Catálogo

A opção 2 lista todos os livros registados, incluindo os que acabaram de
ser adicionados ao sistema:

![Listagem do catálogo](Listar%20livro.png)

## 4.3. Empréstimo, Devolução e Estatísticas

As opções 5 e 6 permitem, respectivamente, emprestar e devolver um
livro, actualizando automaticamente a quantidade de exemplares
disponíveis. A opção 7 apresenta as estatísticas de utilização,
calculadas a partir da matriz de empréstimos por mês. A captura seguinte
demonstra ainda uma validação importante: a tentativa de devolver o
mesmo empréstimo duas vezes é correctamente rejeitada pelo sistema:

![Empréstimo, devolução e estatísticas](Emprestimo%20livros%201.png)

## 4.4. Testes de Registo e Organização do Projecto

A captura seguinte documenta o estado da pasta do projecto durante os
testes, confirmando a organização dos ficheiros-fonte (.java), dos
ficheiros compilados (.class), da documentação (README.md e
Documentacao_Tecnica.md) e o registo de um novo livro no sistema:

![Estrutura do projecto e registo de livro](Registros%20de%20Livro%20Test.png)

# 5. Conclusão

O desenvolvimento deste trabalho permitiu consolidar, de forma prática,
os conceitos fundamentais leccionados na disciplina de Introdução a
Algoritmos e Programação, nomeadamente a utilização de vectores e
matrizes na simulação de uma base de dados em memória, a organização do
código segundo o paradigma da Programação Orientada a Objectos e a
aplicação de mecanismos de tratamento de excepções.

O sistema desenvolvido cumpre os requisitos definidos no enunciado do
trabalho de campo, disponibilizando um menu interactivo através do qual
os bibliotecários podem registar livros, consultar o catálogo, registar
utilizadores, gerir empréstimos e devoluções, e consultar estatísticas
de utilização. A validação cuidada dos dados introduzidos pelo utilizador
confere ao sistema um nível de fiabilidade adequado a um contexto real de
utilização, como demonstrado nas capturas de ecrã apresentadas.

Como trabalho futuro, o sistema poderia ser expandido com a persistência
dos dados em ficheiro ou base de dados relacional (actualmente os dados
existem apenas em memória, sendo perdidos ao terminar o programa), com a
implementação de prazos de devolução e cálculo de multas por atraso, e
com o desenvolvimento de uma interface gráfica.

# 6. Referências Bibliográficas

UnISCED. (s.d.). *Manual do Curso de Licenciatura em Engenharia
Informática: Introdução a Algoritmo e Programação*. Universidade Aberta
ISCED.
