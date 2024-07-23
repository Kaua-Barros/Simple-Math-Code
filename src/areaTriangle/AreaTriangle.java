import java.util.Scanner;

public class AreaTriangle {
    public static void calcArea() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Informe o valor da base");
        double base = input.nextDouble();
        
        System.out.println("Informe o valor da altura");
        double height = input.nextDouble();
        
        double area = (base * height) / 2;
        
        System.out.println("A área do triângulo é: " + area);
        
        input.close();
    }
}