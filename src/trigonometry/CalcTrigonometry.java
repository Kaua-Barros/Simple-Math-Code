package trigonometry;

import java.text.DecimalFormat;

import utils.InputUtils;

import javax.swing.JFrame;

public class CalcTrigonometry {

    public static JFrame frame = new JFrame() {{
        setSize(900, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }};
    public static final double DEGREES_TO_RADIANS = Math.PI / 180.0;
    public static final int taylorTerms = 50;
    public static final int arcTerms = 60;
    public static final DecimalFormat formatDouble = new DecimalFormat("#.########");

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

    public static void MenuTrigonometry() {

        label:
        while (true) {
            System.out.print("\nDigite a opção desejada: \n"
                    + "1) Calcular Seno \n"
                    + "2) Calcular Cosseno \n"
                    + "3) Calcular Tangente \n"
                    + "4) Conversões \n"
                    + "5) Voltar ao menu principal \n"
                    + "Digite aqui: ");

            switch (InputUtils.getIntInputValue()) {
                case 1:
                    Sen.calcSeno();
                    break;
                case 2:
                    Cos.calcCos();
                    break;
                case 3:
                    Tangent.calcTan();
                    break;
                case 4:
                    TrigonometricConverter.menuConversion();
                    break;
                case 5:
                    break label;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }
    }

    public static int MenuFormat(String text, int limit) {
        int choice = 0;
        while (choice <= 0 || choice > limit) {
            System.out.print(text);
            InputUtils.input.nextLine();
            choice = InputUtils.getIntInputValue();
            if (choice <= 0 || choice > limit) {
                System.out.println("\n Opção inválida, tente novamente.");
            }
        }
        return choice;
    }
}