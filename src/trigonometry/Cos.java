package trigonometry;

import utils.InputUtils;

public class Cosseno {

    public static double taylorSerieCos(double radianos) {
        double cos = 1;
        double factorial = 1;
        double pow = 1;

        for (int n = 2; n <= CalcTrigonometry.taylorTerms; n += 2) {
            factorial *= n * (n-1);
            pow *= radianos * radianos;

            double sumNum = pow / factorial;
            if ((n / 2) % 2 == 0) {
                cos += sumNum;
            } else {
                cos -= sumNum;
            }
        }
        return cos;
    }

    private static double taylorSeriesAcos(double cos) {
        double radians = cos;
        double pow = cos;
        double factorial = 1;

        for (int n = 1; n < CalcTrigonometry.arcTerms; n++) {
            pow *= cos * cos;
            factorial *= (2 * n) * (2 * n - 1);

            double numerator = factorial;
            double denominator = Math.pow(Math.pow(2, n) * CalcTrigonometry.factorial(n), 2) * (2 * n + 1);
            double quotient = numerator / denominator;
            radians += quotient * pow;
        }
        return (Math.PI / 2.0 - radians) / CalcTrigonometry.DEGREES_TO_RADIANS;
    }

    public static void calcCos() {
        int choice = 0;
        double cos = 0;
        double angle = 0;
        while (choice != 5) {
            choice = CalcTrigonometry.MenuFormat("\nDigite a opção desejada: \n"
                    + "1) Calcular " + "Cosseno" + " através do Ângulo\n"
                    + "2) Calcular " + "Cosseno" + " através dos Lados do triângulo retângulo\n"
                    + "3) Ver a representação no circulo Trigonometrico\n"
                    + "4) Ver a representação da f(x) = cos(x)\n"
                    + "5) Voltar ao Menu principal \n"
                    + "Digite aqui: ", 5);
            switch (choice) {
                case 1:
                    System.out.print("Digite o valor da ângulação(em graus): ");
                    angle = InputUtils.getDoubleInputValue();
                    double radians = angle * CalcTrigonometry.DEGREES_TO_RADIANS;
                    cos = CalcTrigonometry.formatNum(taylorSerieCos(radians));
                    System.out.println("Cosseno: " + cos);
                    break;
                case 2:
                    System.out.print("Digite o valor do cateto adjacente: ");
                    double catAd = InputUtils.getDoubleInputValue();
                    System.out.print("Digite o valor da hipotenusa: ");
                    double hypotenuse = InputUtils.getDoubleInputValue();
                    if (catAd < hypotenuse) {
                        cos = CalcTrigonometry.formatNum(catAd / hypotenuse);
                        angle = CalcTrigonometry.formatNum(taylorSeriesAcos(cos));
                        System.out.println("Cosseno: " + cos);
                        System.out.println("Ângulo: " + angle + "°");
                    } else {
                        System.out.println("Valor inválido, pois cateto adjacente não pode ser maior ou igual a hipotenusa.");
                    }
                    break;

                case 3:
                    DrawUnitCircle.drawCos(cos, angle);
                    break;
                case 4:
                    int choiceCosFunction = 0;
                    double interval = 1;
                    double period = 1;
                    while (choiceCosFunction != 3) {
                        DrawTrigonometricFunctions.drawFunctionCos(interval, period);
                        choiceCosFunction = CalcTrigonometry.MenuFormat("\nDigite a opção desejada: \n"
                                + "1) Alterar Intervalo da imagem da função Cosseno\n"
                                + "2) Alterar período da função Cosseno\n"
                                + "3) Voltar para opções de Cosseno\n"
                                + "Digite aqui: ", 3);
                        switch (choiceCosFunction) {
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
