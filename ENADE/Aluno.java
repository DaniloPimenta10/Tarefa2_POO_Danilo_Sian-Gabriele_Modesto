public class Aluno {
    protected String nome;
    protected String matricula; 
    protected Boolean questionarioRespondido;

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public Aluno(String n, String m) {
        this.nome = n;
        this.matricula = m;
        this.questionarioRespondido = false;
    }

    public String toString() {
        return this.nome + " (" + this.matricula + ")";
    }

    public boolean regular() {
        return questionarioRespondido;
    }

    public void cadastrarResposta() {
        this.questionarioRespondido = true;
    }
}
