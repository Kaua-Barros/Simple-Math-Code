package trigonometry;

import utils.InputUtils;

public class TrigonometricConverter {

    public static void menuConversion() {

        label:
        while (true) {
            System.out.print("\nDigite a opção desejada: \n"
                    + "1) Graus para Radiano \n"
                    + "2) Radiano para Graus \n"
                    + "3) Voltar ao menu principal \n"
                    + "Digite aqui: ");

            switch (InputUtils.getIntInputValue()) {
                case 1:
                    System.out.print("Digite o valor em Graus: ");
                    double angle = InputUtils.getDoubleInputValue();
                    System.out.println(angle + "° equivalem a :" + angle * CalcTrigonometry.DEGREES_TO_RADIANS);
                    break;
                case 2:
                    System.out.print("Digite o valor em Radianos: ");
                    double radians = InputUtils.getDoubleInputValue();
                    System.out.println(radians + " equivalem a: " + radians / CalcTrigonometry.DEGREES_TO_RADIANS + "°");
                    break;
                case 3:
                    break label;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }
    }
}
