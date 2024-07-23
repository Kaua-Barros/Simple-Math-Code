package areaTriangle;

import utils.InputUtils;

public class AreaTriangle {
    public static void calcArea() {
        System.out.print("Informe o valor da base do triângulo: ");
        double base = InputUtils.getDoubleInputValue();
        
        System.out.print("Informe o valor da altura do triângulo: ");
        double height = InputUtils.getDoubleInputValue();
        
        double area = (base * height) / 2;
        
        System.out.println("A área do triângulo é: " + area + "u²(unidade de medida²)");
    }
}