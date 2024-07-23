import java.util.Scanner;

public class PythagoreanTheorem {
    public static void calcHipotenusa() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Informe o valor do cateto A");
        double catetoA = input.nextDouble();
        
        System.out.println("Informe o valor do cateto B");
        double catetoB = input.nextDouble();
        
        double hipotenusa = Math.sqrt((catetoA * catetoA) + (catetoB * catetoB));
        
        System.out.println("A hipotenusa é: " + hipotenusa);
        
        input.close();
    }
}