import java.util.ArrayList;

public class Curso {
    private String codigo;
    private String nome;
    private ArrayList<Aluno> alunos;

    public Curso (String c, String n) {
        this.codigo = c;
        this.nome = n;
        this.alunos = new ArrayList<>();
    }

    public String toString() {
        return this.nome + " - " + this.codigo;
    }

    public void adicionarAluno(Aluno a) {
        this.alunos.add(a);
    }
    
    public double calcularMedia() {}

    public int calcularConceito() {}

    public ??? ingressantes() {}

    public ??? ingressantes(int s) {}
}
