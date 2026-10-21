import java.util.ArrayList;

public class Sistema {
    private ArrayList<Area> areas;
    private ArrayList<Curso> cursos;
    private ArrayList<Aluno> alunos;

    public ArrayList<Area> getAreas() {
        return areas;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public Sistema() {
        this.areas = new ArrayList<>();
        this.cursos = new ArrayList<>();
        this.alunos = new ArrayList<>();
    }

    public void cadastrarArea(Area area) {
        this.areas.add(area);
    }

    public void cadastrarCurso(Curso curso, Area area) {
        this.cursos.add(curso);
        area.adicionarCurso(curso);
    }

    public void cadastrarAluno(Aluno aluno, Curso curso) {
        this.alunos.add(aluno);
        curso.adicionarAluno(aluno);
    }

    public void listarResultados(int conceito) {
        ArrayList<Curso> resultado = new ArrayList<>();

        for (Curso c: cursos) {
            if (c.calcularConceito() == conceito) {
                resultado.add(c);
            }
        }

        Entrada.imprimirResultadosConceito(this, conceito, resultado);
    }

    public Area areaDoCurso(Curso c) {
        for (Area a : areas) {
            if (a.getCursos().contains(c)) {
                return a;
            }
        }
        return null;
    }



}
