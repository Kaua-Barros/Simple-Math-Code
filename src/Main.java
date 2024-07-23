import areaTriangle.AreaTriangle;
import pythagoras.PythagoreanTheorem;
import thales.TalesTheorem;
import trigonometry.CalcTrigonometry;
import utils.InputUtils;

public class Main {
    public static void main(String[] args) {

        label:
        while (true) {
            System.out.print("\nDigite a opção desejada: \n"
                    + "1) Trigonometria \n"
                    + "2) Teorema de Pitágoras \n"
                    + "3) Teorema de Tales \n"
                    + "4) Área de um Triângulo \n"
                    + "5) Encerrar seção \n"
                    + "Digite aqui: ");

            switch (InputUtils.getIntInputValue()) {
                case 1:
                    CalcTrigonometry.MenuTrigonometry();
                    break;
                case 2:
                    PythagoreanTheorem.calcHipotenuse();
                    break;
                case 3:
                    TalesTheorem.calcProportion();
                    break;
                case 4:
                    AreaTriangle.calcArea();
                    break;
                case 5:
                    break label;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }
        System.out.println("Seção encerrada.");
        InputUtils.input.close();
    }
}