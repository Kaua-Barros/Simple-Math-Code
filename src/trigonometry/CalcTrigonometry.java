import java.text.DecimalFormat;
import java.util.Scanner;


public class CalcTrigonometry {
    public final double FULL_CIRCLE_DEGREES = 360.0;
    public static final double DEGREES_TO_RADIANS = Math.PI / 180.0;
    public static final int taylorTerms = 50;
    public static final int arcTerms = 60;
    public static DecimalFormat formatDouble = new DecimalFormat("#.########");

    public static double formatNum(double x) {
        return Double.parseDouble((formatDouble.format(x)).replace(",", "."));
    }

    public static double factorial(int x) {
        double Fat = x;
        for (int iFat = x; iFat > 2; iFat--) {
            Fat *= iFat - 1;
        }
        return Fat;
    }

    public static int Menu(String trigonometrycFunction) {
            System.out.print("\nDigite a opção desejada: \n"
                    + "1) Calcular " + trigonometrycFunction + " através do Ângulo\n"
                    + "2) Calcular " + trigonometrycFunction + " através dos Lados do triângulo retângulo\n"
                    + "3) Ver a representação no circulo Trigonometrico\n"
                    + "4) Voltar ao Menu principal \n"
                    + "Digite aqui: ");
            int choice = InputUtils.getIntInputValue();
            if (choice < 0 || choice > 4) {
                System.out.println("\n Opção inválida, tente novamente.");
                Menu(trigonometrycFunction);
            }
            return choice;
        }
}