public class Concluinte extends Aluno{
    private double notaFormacaoGeral;
    private double notaComponenteEspecifico;
    private boolean presente;

    public Concluinte(String n, String m) {
        super(n, m);
    }

    public void cadastrarProva(double n1, double n2) {
        this.notaFormacaoGeral = n1;
        this.notaComponenteEspecifico = n2;
    }

    public double notaFinal() {
        return notaComponenteEspecifico + notaFormacaoGeral;
    }
    


}
