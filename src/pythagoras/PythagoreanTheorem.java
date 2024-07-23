package pythagoras;

import utils.InputUtils;

public class PythagoreanTheorem {
    public static void calcHipotenuse() {
        System.out.print("Informe o valor do cateto A: ");
        double catetoA = InputUtils.getDoubleInputValue();
        
        System.out.print("Informe o valor do cateto B: ");
        double catetoB = InputUtils.getDoubleInputValue();
        
        double hipotenusa = Math.sqrt((catetoA * catetoA) + (catetoB * catetoB));
        
        System.out.println("O valor da hipotenusa é: " + hipotenusa);
    }
}