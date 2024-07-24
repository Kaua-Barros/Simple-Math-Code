package trigonometry;

import utils.InputUtils;

public class Sen {

    public static double taylorSerieSen(double radians) {
        double sen = radians;
        TaylorSeriesParams params = new TaylorSeriesParams(radians, sen, radians);

        for (int n = 3; n <= CalcTrigonometry.taylorTerms; n += 2) {
            sen = CalcTrigonometry.updateTaylorSeriesParams(params, n).partialResult;
            ;
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
            choice = CalcTrigonometry.MenuFormat("""

                    Digite a opção desejada:\s
                    1) Calcular Seno através do Ângulo
                    2) Calcular Seno através dos Lados do triângulo retângulo
                    3) Ver a representação no circulo Trigonometrico
                    4) Ver a representação da f(x) = sen(x)
                    5) Voltar ao Menu trigonomêtrico\s
                    Digite aqui:\s""", 5);
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
                        choiceSenFunction = CalcTrigonometry.MenuFormat("""
                                      
                                Digite a opção desejada:\s
                                1) Alterar Intervalo da imagem da função Seno
                                2) Alterar período da função Seno
                                3) Voltar para opções de Seno
                                Digite aqui:\s""", 3);
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
