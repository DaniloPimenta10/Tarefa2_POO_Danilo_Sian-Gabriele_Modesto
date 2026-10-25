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

    public void listarResultados(String nomeArea) {
        Area a = buscarAreaNome(nomeArea);
        ArrayList<Curso> resultado = new ArrayList<>();
        if (a != null) {
            resultado = a.getCursos();
        }
        Entrada.imprimirResultadosArea(a, nomeArea, resultado);
    }

    public void listarAlunosIrregulares() {
        ArrayList<Aluno> resultado = new ArrayList<>();
        for (Aluno a : alunos) {
            if (!a.regular()) {
                resultado.add(a);
            }
        }
        Entrada.imprimirIrregulares(this, resultado);
    }

    public Area areaDoCurso(Curso c) {
        for (Area a : areas) {
            if (a.getCursos().contains(c)) {
                return a;
            }
        }
        return null;
    }

    public Area buscarAreaNome(String nome){
        for (Area a : areas) {
            if (a.getNome().equalsIgnoreCase(nome)) {
                return a;
            }
        }
        return null;
    }

    public Area buscarAreaCodigo(String codigo) {
        for (Area a : areas) {
            if (a.getCodigo().equals(codigo)) {
                return a;
            }
        }
        return null;
    }

    public Curso buscarCurso(String codigo) {
        for (Curso c : cursos) {
            if (c.getCodigo().equals(codigo)) {
                return c;
            }
        }
        return null;
    }

    public Aluno buscarAluno(String matricula) {
        for (Aluno a : alunos) {
            if (a.getMatricula().equals(matricula)) {
                return a;
            }
        }
        return null;
    }

    public Curso cursoAluno(Aluno aluno) {
        for (Curso c : cursos) {
            if (c.getAlunos().contains(aluno)) {
                return c;
            }
        }
        return null;
    }





}
