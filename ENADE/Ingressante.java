public class Ingressante extends Aluno{
    private int semInicio;

    public int getSemInicio() {
        return semInicio;
    }

    public Ingressante(String n, String m, int s) {
        super(n, m);
        semInicio = s;
    }

    
}
