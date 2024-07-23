package thales;

import utils.InputUtils;

public class TalesTheorem {
	public static void calcProportion() {

        System.out.print("Informe o valor de AD: ");
        double AD = InputUtils.getDoubleInputValue();
        
        System.out.print("Informe o valor de DB: ");
        double DB = InputUtils.getDoubleInputValue();

        System.out.print("Informe o valor de AE: ");
        double AE = InputUtils.getDoubleInputValue();
        
        System.out.print("Informe o valor de EC: ");
        double EC = InputUtils.getDoubleInputValue();
        
        if (DB == 0 || EC == 0) {
            System.out.println("Os valores de DB e EC não podem ser iguais a zero.");
        } else {
            double proportion1 = AD / DB;
            double proportion2 = AE / EC;
            
            if (proportion1 == proportion2) {
                System.out.println("Os segmentos são proporcionais.");
                System.out.println("Proporção calculada: " + proportion1);
            } else {
                System.out.println("Os segmentos não são proporcionais.");
                System.out.println("Proporção de AD/DB: " + proportion1);
                System.out.println("Proporção de AE/EC: " + proportion2);
            }
        }
	}
}

