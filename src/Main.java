import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        Seno seno = new Seno();
        while (true) {
            System.out.println("Digite a opção desejada: \n"
                               + "1) Descobrir seno \n"
                               + "2) Descobrir cosseno \n"
                               + "3) Calcular radianos em graus \n"
                               + "4) Calcular graus em radianos \n"
                               + "5) Encerrar seção \n"
                               + "Digite aqui:_");
            int x = tec.nextInt();
            if (x == 5) {
                break;
            }
            switch (x) {
                case 1:
                    System.out.println("Opção 1 escolhida: Descobrir seno. \n");
                    seno.CalculaSeno();
                    break;
                case 2:
                    System.out.println("Opção 2 escolhida: Descobrir cosseno.");
                    
                    break;
                case 3:
                    System.out.println("Opção 3 escolhida: Calcular radianos em graus.");
                 
                    break;
                case 4:
                    System.out.println("Opção 4 escolhida: Calcular graus em radianos.");
                    
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }
        System.out.println("Seção encerrada.");
        tec.close();
    }
}