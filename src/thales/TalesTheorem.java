import java.util.Scanner;
public class TalesTheorem {
	public static void calcProportion() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Informe o valor de AD");
        double AD = input.nextDouble();
        
        System.out.println("Informe o valor de DB");
        double DB = input.nextDouble();
        
        System.out.println("Informe o valor de AE");
        double AE = input.nextDouble();
        
        System.out.println("Informe o valor de EC");
        double EC = input.nextDouble();
        
        if (DB == 0 || EC == 0) {
            System.out.println("Os valores de DB e EC não podem ser zero.");
        } else {
            double proporcao1 = AD / DB;
            double proporcao2 = AE / EC;
            
            if (proporcao1 == proporcao2) {
                System.out.println("Os segmentos são proporcionais.");
                System.out.println("Proporção calculada: " + proporcao1);
            } else {
                System.out.println("Os segmentos não são proporcionais.");
                System.out.println("Proporção de AD/DB: " + proporcao1);
                System.out.println("Proporção de AE/EC: " + proporcao2);
            }
        }
	}
}

