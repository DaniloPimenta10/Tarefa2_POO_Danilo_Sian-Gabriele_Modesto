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
    
    public double calcularMedia() {
        double media = 0.0;
        int quantidade = 0;

        for (int i = 0; i < alunos.size(); i++) {
            Aluno a = alunos.get(i);
            
            if (a instanceof Concluinte) {
                Concluinte c = (Concluinte) a;
                media += c.notaFinal();
                quantidade += 1;
            }
        }

        if (quantidade == 0)
            return 0;

        else
            return media/quantidade;
    }

    public int calcularConceito() {
        double media = calcularMedia();
        if (media < 2.0)
            return 1;
        
        else if (media >= 2.0 || media < 4.0)
            return 2;

        else if (media >= 4.0 || media < 6.0)
            return 3;
        
        else if (media >= 6.0 || media < 8.0)
            return 4;

        else if (media >= 8.0)
            return 5;

        else 
            return 0;
    }

    public ArrayList<Ingressante> ingressantes() {
        ArrayList<Ingressante> alunosIngressantes = new ArrayList<>();

        for (int i = 0; i < alunos.size(); i++) {
        Aluno a = alunos.get(i);
            
        if (a instanceof Ingressante) {
                Ingressante ing = (Ingressante) a;
                alunosIngressantes.add(ing);
            }
        }
        return alunosIngressantes;

    }

    public ArrayList<Ingressante> ingressantes(int s) {
        ArrayList<Ingressante> alunosIngressantes = new ArrayList<>();

        for (int i = 0; i < alunos.size(); i++) {
        Aluno a = alunos.get(i);
            
        if (a instanceof Ingressante) {
                Ingressante ing = (Ingressante) a;
                if (ing.getSemInicio() == s)
                    alunosIngressantes.add(ing);
            }
        }
        return alunosIngressantes;
    }

}