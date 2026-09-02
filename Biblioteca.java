import java.util.Arrays;

public class Biblioteca {

    private Livro[] livros;
    private int totalLivros;

    private Utilizador[] utilizadores;
    private int totalUtilizadores;

    private Emprestimo[] emprestimos;
    private int totalEmprestimos;

    private int[][] matrizEmprestimosPorMes = new int[50][12];

    private int proximoIdLivro = 1;
    private int proximoIdUtilizador = 1;
    private int proximoIdEmprestimo = 1;

    public Biblioteca(int capacidadeInicial) {
        livros = new Livro[capacidadeInicial];
        utilizadores = new Utilizador[capacidadeInicial];
        emprestimos = new Emprestimo[capacidadeInicial];
        totalLivros = 0;
        totalUtilizadores = 0;
        totalEmprestimos = 0;
    }

    public Livro registarLivro(String titulo, String autor, int anoPublicacao, int quantidade) {
        Livro novo = new Livro(proximoIdLivro, titulo, autor, anoPublicacao, quantidade);
        livros[totalLivros] = novo;
        totalLivros++;
        proximoIdLivro++;
        return novo;
    }

    public Livro[] listarLivros() {
        return Arrays.copyOf(livros, totalLivros);
    }

    public Livro procurarLivroPorId(int id) {
        for (int i = 0; i < totalLivros; i++) {
            if (livros[i].getId() == id) {
                return livros[i];
            }
        }
        return null;
    }

    public Livro[] pesquisarLivros(String termo) {
        String termoMinusculo = termo.toLowerCase();
        Livro[] resultadosTemp = new Livro[totalLivros];
        int encontrados = 0;

        for (int i = 0; i < totalLivros; i++) {
            String tituloMinusculo = livros[i].getTitulo().toLowerCase();
            String autorMinusculo = livros[i].getAutor().toLowerCase();

            if (tituloMinusculo.contains(termoMinusculo) || autorMinusculo.contains(termoMinusculo)) {
                resultadosTemp[encontrados] = livros[i];
                encontrados++;
            }
        }

        return Arrays.copyOf(resultadosTemp, encontrados);
    }

    public Utilizador registarUtilizador(String nome, String contacto) {
        Utilizador novo = new Utilizador(proximoIdUtilizador, nome, contacto);
        utilizadores[totalUtilizadores] = novo;
        totalUtilizadores++;
        proximoIdUtilizador++;
        return novo;
    }

    public Utilizador procurarUtilizadorPorId(int id) {
        for (int i = 0; i < totalUtilizadores; i++) {
            if (utilizadores[i].getId() == id) {
                return utilizadores[i];
            }
        }
        return null;
    }

    public Emprestimo emprestarLivro(int idLivro, int idUtilizador) {
        Livro livro = procurarLivroPorId(idLivro);
        Utilizador utilizador = procurarUtilizadorPorId(idUtilizador);

        if (livro == null || utilizador == null) {
            return null;
        }
        if (!livro.emprestarExemplar()) {
            return null;
        }

        Emprestimo novo = new Emprestimo(proximoIdEmprestimo, idLivro, idUtilizador, java.time.LocalDate.now());
        emprestimos[totalEmprestimos] = novo;
        totalEmprestimos++;
        proximoIdEmprestimo++;

        int indiceLivro = -1;
        for (int i = 0; i < totalLivros; i++) {
            if (livros[i].getId() == idLivro) {
                indiceLivro = i;
            }
        }
        int mesActual = java.time.LocalDate.now().getMonthValue() - 1;
        matrizEmprestimosPorMes[indiceLivro][mesActual]++;

        return novo;
    }

    public boolean devolverLivro(int idEmprestimo) {
        for (int i = 0; i < totalEmprestimos; i++) {
            Emprestimo e = emprestimos[i];
            if (e.getId() == idEmprestimo && !e.isDevolvido()) {
                e.registarDevolucao(java.time.LocalDate.now());
                Livro livro = procurarLivroPorId(e.getIdLivro());
                livro.devolverExemplar();
                return true;
            }
        }
        return false;
    }

    public Livro livroMaisEmprestado() {
        int indiceMaisEmprestado = -1;
        int maiorTotal = -1;

        for (int i = 0; i < totalLivros; i++) {
            int totalDoLivro = 0;
            for (int mes = 0; mes < 12; mes++) {
                totalDoLivro += matrizEmprestimosPorMes[i][mes];
            }
            if (totalDoLivro > maiorTotal) {
                maiorTotal = totalDoLivro;
                indiceMaisEmprestado = i;
            }
        }

        if (maiorTotal > 0) {
            return livros[indiceMaisEmprestado];
        }
        return null;
    }

    public int totalDeLivrosRequisitados() {
        return totalEmprestimos;
    }
}