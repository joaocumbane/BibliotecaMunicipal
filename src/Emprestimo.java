import java.time.LocalDate;

public class Emprestimo {

    private int id;
    private int idLivro;
    private int idUtilizador;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean devolvido;

    public Emprestimo(int id, int idLivro, int idUtilizador, LocalDate dataEmprestimo) {
        this.id = id;
        this.idLivro = idLivro;
        this.idUtilizador = idUtilizador;
        this.dataEmprestimo = dataEmprestimo;
        this.devolvido = false;
        this.dataDevolucao = null;
    }

    public int getId() {
        return id;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public int getIdUtilizador() {
        return idUtilizador;
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public void registarDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
        this.devolvido = true;
    }
}

Move Emprestimo.java para pasta src
