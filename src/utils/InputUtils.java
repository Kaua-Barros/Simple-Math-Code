import java.util.Scanner;

public class InputUtils {
    public static final Scanner input = new Scanner(System.in);

    public static double getDoubleInputValue() {
        double var = 0;
        boolean inputAccepted = false;
        while (!(inputAccepted)) {
            try {
                var = input.nextDouble();
                inputAccepted = true;
            } catch (Exception e) {
                System.out.print("\nValor inválido, digite novamente: ");
                input.nextLine();
            }
        }
        return var;
    }

    public static int getIntInputValue() {
        int var = 0;
        boolean inputAccepted = false;
        while (!(inputAccepted)) {
            try {
                var = input.nextInt();
                inputAccepted = true;
            } catch (Exception e) {
                System.out.print("\nValor inválido, digite novamente: ");
                input.nextLine();
            }
        }
        return var;
    }
}
