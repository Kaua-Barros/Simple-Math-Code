package trigonometry;

import utils.InputUtils;

public class Seno {

    public static double taylorSerieSen(double radians) {
        double sen = radians;
        double factorial = 1;
        double pow = radians;

        for (int n = 3; n <= CalcTrigonometry.taylorTerms; n += 2) {
            factorial *= n * (n - 1);
            pow *= radians * radians;

            double sumNum = pow / factorial;
            if ((n / 2) % 2 == 0) {
                sen += sumNum;
            } else {
                sen -= sumNum;
            }
        }
        return sen;
    }

    private static double taylorSeriesAsin(double sen) {
        double radians = sen;
        double pow = sen;
        double factorial = 1;

        for (int n = 1; n < CalcTrigonometry.arcTerms; n++) {
            pow *= sen * sen;
            factorial *= (2 * n) * (2 * n - 1);

            double numerator = factorial;
            double denominator = Math.pow(Math.pow(2, n) * CalcTrigonometry.factorial(n), 2) * (2 * n + 1);
            double quotient = (numerator / denominator);
            radians += quotient * pow;
        }
        return radians / CalcTrigonometry.DEGREES_TO_RADIANS;
    }

    public static void calcSeno() {
        int choice = 0;
        double sen = 0;
        double angle = 0;
        while (choice != 5) {
            choice = CalcTrigonometry.MenuFormat("\nDigite a opção desejada: \n"
                    + "1) Calcular " + "Seno" + " através do Ângulo\n"
                    + "2) Calcular " + "Seno" + " através dos Lados do triângulo retângulo\n"
                    + "3) Ver a representação no circulo Trigonometrico\n"
                    + "4) Ver a representação da f(x) = sen(x)\n"
                    + "5) Voltar ao Menu principal \n"
                    + "Digite aqui: ", 5);
            switch (choice) {
                case 1:
                    System.out.print("Digite o valor da ângulação(em graus): ");
                    angle = InputUtils.getDoubleInputValue();
                    double radians = angle * CalcTrigonometry.DEGREES_TO_RADIANS;
                    sen = CalcTrigonometry.formatNum(taylorSerieSen(radians));
                    System.out.println("Seno: " + sen);
                    break;
                case 2:
                    System.out.print("Digite o valor do cateto oposto: ");
                    double catOp = InputUtils.getDoubleInputValue();
                    System.out.print("Digite o valor da hipotenusa: ");
                    double hypotenuse = InputUtils.getDoubleInputValue();
                    if (catOp < hypotenuse) {
                        sen = CalcTrigonometry.formatNum(catOp / hypotenuse);
                        angle = CalcTrigonometry.formatNum(taylorSeriesAsin(sen));
                        System.out.println("Seno: " + sen);
                        System.out.println("Ângulo: " + angle + "°");
                    } else {
                        System.out.println("Valor inválido, pois cateto oposto não pode ser maior ou igual a hipotenusa.");
                    }
                    break;
                case 3:
                    DrawUnitCircle.drawSeno(sen, angle);
                    break;
                case 4:
                    int choiceSenFunction = 0;
                    double interval = 1;
                    double period = 1;
                    while (choiceSenFunction != 3) {
                        DrawTrigonometricFunctions.drawFunctionSen(interval, period);
                        choiceSenFunction = CalcTrigonometry.MenuFormat("\nDigite a opção desejada: \n"
                                + "1) Alterar Intervalo da imagem da função Seno\n"
                                + "2) Alterar período da função Seno\n"
                                + "3) Voltar para opções de Seno\n"
                                + "Digite aqui: ", 3);
                        switch (choiceSenFunction) {
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
