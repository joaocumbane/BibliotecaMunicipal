import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Biblioteca biblioteca = new Biblioteca(10);

    public static void main(String[] args) {

        biblioteca.registarLivro("Terra Sonambula", "Mia Couto", 1992, 3);
        biblioteca.registarLivro("Nos, os do Makulusu", "Luandino Vieira", 1974, 2);
        biblioteca.registarUtilizador("Fatima Nhaca", "84 555 1122");

        boolean continuar = true;

        while (continuar) {
            System.out.println("");
            System.out.println("1. Registar livro");
            System.out.println("2. Listar livros");
            System.out.println("3. Pesquisar livros");
            System.out.println("4. Registar utilizador");
            System.out.println("5. Emprestar livro");
            System.out.println("6. Devolver livro");
            System.out.println("7. Estatisticas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: ");

            int opcao = lerInteiro();

            if (opcao == 1) {
                registarLivro();
            } else if (opcao == 2) {
                listarLivros();
            } else if (opcao == 3) {
                pesquisarLivros();
            } else if (opcao == 4) {
                registarUtilizador();
            } else if (opcao == 5) {
                emprestarLivro();
            } else if (opcao == 6) {
                devolverLivro();
            } else if (opcao == 7) {
                estatisticas();
            } else if (opcao == 0) {
                continuar = false;
                System.out.println("Ate breve!");
            } else {
                System.out.println("Opcao invalida.");
            }
        }
    }

    private static int lerInteiro() {
        while (true) {
            String texto = scanner.nextLine().trim();
            try {
                return Integer.parseInt(texto);
            } catch (NumberFormatException erro) {
                System.out.print("Isso nao e um numero valido. Tente outra vez: ");
            }
        }
    }

    private static void registarLivro() {
        System.out.print("Titulo: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Ano: ");
        int ano = lerInteiro();
        System.out.print("Quantidade: ");
        int quantidade = lerInteiro();

        biblioteca.registarLivro(titulo, autor, ano, quantidade);
        System.out.println("Livro registado!");
    }

    private static void listarLivros() {
        Livro[] livros = biblioteca.listarLivros();
        if (livros.length == 0) {
            System.out.println("Nao ha livros registados.");
            return;
        }
        for (int i = 0; i < livros.length; i++) {
            System.out.println(livros[i].getId() + " - " + livros[i].getTitulo()
                    + " (" + livros[i].getAutor() + ") - Disponiveis: "
                    + livros[i].getQuantidadeDisponivel());
        }
    }

    private static void pesquisarLivros() {
        System.out.print("Titulo ou autor a pesquisar: ");
        String termo = scanner.nextLine();

        Livro[] resultados = biblioteca.pesquisarLivros(termo);
        if (resultados.length == 0) {
            System.out.println("Nenhum livro encontrado.");
            return;
        }
        for (int i = 0; i < resultados.length; i++) {
            System.out.println(resultados[i].getId() + " - " + resultados[i].getTitulo()
                    + " (" + resultados[i].getAutor() + ")");
        }
    }

    private static void registarUtilizador() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Contacto: ");
        String contacto = scanner.nextLine();

        biblioteca.registarUtilizador(nome, contacto);
        System.out.println("Utilizador registado!");
    }

    private static void emprestarLivro() {
        System.out.print("ID do livro: ");
        int idLivro = lerInteiro();
        System.out.print("ID do utilizador: ");
        int idUtilizador = lerInteiro();

        Emprestimo emprestimo = biblioteca.emprestarLivro(idLivro, idUtilizador);
        if (emprestimo != null) {
            System.out.println("Emprestimo registado! Numero: " + emprestimo.getId());
        } else {
            System.out.println("Nao foi possivel emprestar.");
        }
    }

    private static void devolverLivro() {
        System.out.print("Numero do emprestimo: ");
        int idEmprestimo = lerInteiro();

        boolean sucesso = biblioteca.devolverLivro(idEmprestimo);
        if (sucesso) {
            System.out.println("Devolucao registada!");
        } else {
            System.out.println("Emprestimo nao encontrado ou ja devolvido.");
        }
    }

    private static void estatisticas() {
        System.out.println("Total requisitados: " + biblioteca.totalDeLivrosRequisitados());
        Livro maisEmprestado = biblioteca.livroMaisEmprestado();
        if (maisEmprestado != null) {
            System.out.println("Mais emprestado: " + maisEmprestado.getTitulo());
        } else {
            System.out.println("Ainda nao ha emprestimos.");
        }
    }
}

Move Main.java para pasta src
