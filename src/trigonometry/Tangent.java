package trigonometry;

import java.text.DecimalFormat;

import utils.InputUtils;

public class Tangent {

    public static final DecimalFormat formatDouble = new DecimalFormat("#.###");

    public static double formatNumTan(double x) {
        return Double.parseDouble((formatDouble.format(x)).replace(",", "."));
    }

    public static double taylorSerieTan(double radians) {
        double sen = Sen.taylorSerieSen(radians);
        double cos = Cos.taylorSerieCos(radians);
        return (sen / cos);
    }

    private static double taylorSeriesAtan(double tan) {
        double radians = tan;
        double pow = tan;
        for (int n = 3; n < CalcTrigonometry.arcTerms; n += 2) {
            pow *= tan * tan;
            double sumNum = pow / n;
            if ((n / 2) % 2 == 0) {
                radians += sumNum;
            } else {
                radians -= sumNum;
            }
        }
        return radians / CalcTrigonometry.DEGREES_TO_RADIANS;
    }

    public static void calcTan() {
        int choice = 0;
        double tan = 0;
        double angle = 0;
        while (choice != 5) {
            choice = CalcTrigonometry.MenuFormat("""

                    Digite a opção desejada:\s
                    1) Calcular Tangente através do Ângulo
                    2) Calcular Tangente através dos Lados do triângulo retângulo
                    3) Ver a representação no circulo Trigonometrico
                    4) Ver a representação da f(x) = tan(x)
                    5) Voltar ao Menu trigonomêtrico\s
                    Digite aqui:\s""", 5);
            switch (choice) {
                case 1:
                    System.out.print("Digite o valor da ângulação(em graus): ");
                    angle = InputUtils.getDoubleInputValue();
                    if (angle == 90 || angle == 270) {
                        System.out.println("A tangente de 90° não pode ser calculada");
                    } else {
                        double radians = angle * CalcTrigonometry.DEGREES_TO_RADIANS;
                        tan = formatNumTan(taylorSerieTan(radians));
                        System.out.println("Tangente: " + tan);
                    }
                    break;

                case 2:
                    System.out.print("Digite o valor do cateto oposto: ");
                    double catOp = InputUtils.getDoubleInputValue();
                    System.out.print("Digite o valor da cateto adjacente: ");
                    double catAd = InputUtils.getDoubleInputValue();
                    tan = formatNumTan(catOp / catAd);
                    angle = formatNumTan(taylorSeriesAtan(tan));
                    System.out.println("Tangente: " + tan);
                    System.out.println("Ângulo: " + Math.round(angle) + "°");
                    break;

                case 3:
                    DrawUnitCircle.drawTan(tan, angle);
                    break;

                case 4:
                    int choiceTanFunction = 0;
                    double interval = 1;
                    double period = 1;
                    while (choiceTanFunction != 3) {
                        DrawTrigonometricFunctions.drawFunctionTan(interval, period);
                        choiceTanFunction = CalcTrigonometry.MenuFormat("""

                                Digite a opção desejada:\s
                                1) Alterar Intervalo da imagem da função Seno
                                2) Alterar período da função Seno
                                3) Voltar para opções de Seno
                                Digite aqui:\s""", 3);
                        switch (choiceTanFunction) {
                            case 1:
                                System.out.print("\nDigite o valor do multiplicador do intervalo: ");
                                interval = InputUtils.getDoubleInputValue();
                                break;
                            case 2:
                                System.out.print("\nDigite o valor do multiplicador do período: ");
                                period = InputUtils.getDoubleInputValue();
                                break;
                        }
                    }
            }
        }
    }
}
