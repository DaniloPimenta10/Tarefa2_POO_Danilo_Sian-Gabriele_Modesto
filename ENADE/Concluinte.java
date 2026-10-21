public class Concluinte extends Aluno{
    private double notaFormacaoGeral;
    private double notaComponenteEspecifico;
    private boolean presente;

    public Concluinte(String n, String m) {
        super(n, m);
        this.notaFormacaoGeral = 0.0;
        this.notaComponenteEspecifico = 0.0;
        this.presente = false;
    }

    public double getNotaFormacaoGeral() {
        return notaFormacaoGeral;
    }

    public double getNotaComponenteEspecifico() {
        return notaComponenteEspecifico;
    }

    public void cadastrarProva(double n1, double n2) {
        this.notaFormacaoGeral = n1;
        this.notaComponenteEspecifico = n2;
        this.presente = true;
    }

    public double notaFinal() {
        return (3 * notaFormacaoGeral + 7 * notaComponenteEspecifico)/10.0;
    }
    


}
