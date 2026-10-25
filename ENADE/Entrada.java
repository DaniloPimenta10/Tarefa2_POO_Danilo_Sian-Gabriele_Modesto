import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * Classe com as rotinas de entrada e saída do projeto
 * @author Hilario Seibel Junior e <seu nome aqui>
 */
public class Entrada {

    /**
     * Se houver um arquivo input.txt na pasta em que o projeto está sendo executado,
     * define que o Scanner vai ler deste arquivo e não do teclado.
     * Se o arquivo não existir, define que o Scanner vai ler da entrada padrão (teclado)
     * NÃO ALTERE O ESTE CODIGO!!!!
     * @return Um objeto da classe Scanner de onde a entrada será lida
     */
    
    public static Scanner abrirEntrada() {
        Scanner input = null;
        try {
            // Se houver um arquivo input.txt, o Scanner vai ler dele.
            input = new Scanner(new FileInputStream("input.txt")).useLocale(Locale.US);
        } catch (FileNotFoundException e) {
            // Caso contrário, vai ler do teclado.
            // Locale.US para que o Java sempre leia double com "pontos" ao invés de "vírgulas"
            input = new Scanner(System.in).useLocale(Locale.US);
        }
        finally {
            return input;
        }
    }

    /**
     * Fecha o Scanner antes de sair do programa.
     * @param input: Um objeto da classe Scanner de onde a entrada está sendo lida
     */
    public static void fecharEntrada(Scanner input) {
        input.close();
    }

    /**
     * Faz a leitura de uma linha inteira
     * @param msg: Mensagem que será exibida ao usuário
     * @param input: Um objeto da classe Scanner de onde a entrada está sendo lida
     * @return Uma String contendo a linha que foi lida
     */
    public static String lerLinha(String msg, Scanner input) {
        // Imprime uma mensagem ao usuário, lê uma e retorna esta linha
        System.out.print(msg);
        String linha = input.nextLine();
        return linha;
    }

    /**
     * Faz a leitura de um número inteiro
     * @param msg: Mensagem que será exibida ao usuário
     * @param input: Um objeto da classe Scanner de onde a entrada está sendo lida
     * @return O número digitado pelo usuário convertido para int
     */
    public static int lerInteiro(String msg, Scanner input) {
        // Imprime uma mensagem ao usuário, lê uma linha contendo um inteiro e retorna este inteiro
        String linha = Entrada.lerLinha(msg, input);
        return Integer.parseInt(linha);
    }

    /**
     * Faz a leitura de um double
     * @param msg: Mensagem que será exibida ao usuário
     * @param input: Um objeto da classe Scanner de onde a entrada está sendo lida
     * @return O número digitado pelo usuário convertido para double
     */
    private static double lerDouble(String msg, Scanner input) {
        // Imprime uma mensagem ao usuário, lê uma linha contendo um double e retorna este double
        String linha = Entrada.lerLinha(msg, input);
        return Double.parseDouble(linha);
    }

    /**
     * Imprime o menu principal, lê a opção escolhida pelo usuário e retorna a opção selecionada.
     * @return Inteiro contendo a opção escolhida pelo usuário
     */
    public static int menu(Scanner input) {
        // Imprime o menu principal, lê a opção escolhida pelo usuário e retorna a opção selecionada.
        String msg = "*********************\n" +
                "Escolha uma opção:\n" +
                "1) Cadastro\n" +
                "2) Relatórios\n" +
                "0) Sair\n";

        int op = Entrada.lerInteiro(msg, input);

        while (op < 0 || op > 2) {
            System.out.println("Opção inválida. Tente novamente: ");
            op = Entrada.lerInteiro(msg, input);
        }

        return op;
    }

    public static void menu_cadastro(Sistema s, Scanner input) {
        String msg = "*********************\n" +
                "1) Cadastrar Área\n" +
                "2) Cadastrar Curso\n" +
                "3) Cadastrar Aluno Ingressante\n" +
                "4) Cadastrar Aluno Concluinte\n" +
                "5) Cadastrar Resposta de Questionário\n" +
                "6) Cadastrar Resultado de Prova\n" +
                "0) Voltar\n";

        int op = Entrada.lerInteiro(msg, input);

        if (op == 0) return;

        switch(op) {
            case 1:
                Entrada.cadArea(s, input);
                break;
            case 2:
                //Entrada.cadCurso(s, input);
                break;
            case 3:
                //Entrada.cadIngressante(s, input);
                break;
            case 4:
                //Entrada.cadConcluinte(s, input);
                break;
            case 5:
                //Entrada.cadResposta(s, input);
                break;
            case 6:
                //Entrada.cadProva(s, input);
                break;
            default:
                System.out.println("Opção Inválida.");
        }

    }

    public static void cadArea(Sistema s, Scanner input) {
        String nome = Entrada.lerLinha("Digite o nome da área: ", input);
        String codigo = Entrada.lerLinha("Digite o código da área: ", input);

        s.cadastrarArea(new Area(nome, codigo));
        System.out.println("Área cadastrada com sucesso!");
    }

    public static void imprimirResultadosConceito(Sistema s, int conceito, ArrayList<Curso> cursos) {
        System.out.println("Cursos com conceito" + conceito + ":");

        if (cursos.isEmpty()) {
            System.out.println("Nenhum curso com conceito " + conceito + "encontrado.");
            return;
        }

        for (Curso c : cursos) {
            Area area = s.areaDoCurso(c);
            System.out.println(Entrada.descreverCurso(c) + " - Área: " + Entrada.descreverArea(area));
        }
    }

    public static void imprimirResultadosArea(Area area, String nomeArea, ArrayList<Curso> cursos) {
        if (area == null || cursos.isEmpty()) {
            System.out.println("Nenhum curso na área " + nomeArea + "foi encontrado.");
            return;
        }
        System.out.println("Conceitos dos cursos das área" + Entrada.descreverArea(area) + ":");
        for (Curso c : cursos) {
            System.out.println(Entrada.descreverCurso(c) + ": " + c.calcularConceito());
        }
    }

    public static void imprimirIrregulares(Sistema s, ArrayList<Aluno> alunos) {
        System.out.println("Alunos irregulares com o ENADE: ");
        for (Aluno a : alunos) {
            Curso curso = s.cursoAluno(a);
            System.out.println(a + " - CURSO: " + Entrada.descreverCurso(curso));
        }
    }


    private static String descreverArea(Area a) {
        return a.getNome() + " (" + a.getCodigo() + ")";
    }

    private static String descreverCurso(Curso c) {
        return c.getNome() + "(" + c.getCodigo() + ")";
    }

    private static void exibirAreas(Sistema s) {
        System.out.println("Áreas cadastradas: ");
        for (Area a : s.getAreas()) {
            System.out.println(Entrada.descreverArea(a));
        }
    }

    private static Curso lerCurso(Sistema s, Scanner input) {
        System.out.println("Cursos cadastrados: ");
        for (Curso c : s.getCursos()) {
            System.out.println(Entrada.descreverCurso(c));
        }
        String codigo = Entrada.lerLinha("Digite o código do curso do aluno: ", input);
        return s.buscarCurso(codigo);
    }



}
