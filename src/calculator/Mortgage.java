package calculator;
import java.util.Scanner;
import java.text.NumberFormat;


public class Mortgage {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Principal:");
        Double principal = sc.nextDouble();
        
        System.out.println("Annual Rate:"); 
        Double annualRate = sc.nextDouble();
        
        System.out.println("Period (Years):");
        Double period = sc.nextDouble();
        
        Double number = period * 12;

        Double rate = annualRate / 100 / 12;

        try{
            Double mortgage = principal * (rate * Math.pow(1 + rate, number)) / (Math.pow(1 + rate, number) - 1);
            
            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
            String formattedMortgage = currencyFormat.format(mortgage);

            System.out.println("Your monthly mortgage payment is: " + formattedMortgage);

           

        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid number.");
        } finally {
            sc.close();
        }
    }

    private static Double getValidDoubleInput(Scanner sc) {
        while (true) {
            try {
                return sc.nextDouble();
            } catch (Exception e) {
                sc.nextLine();  
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}
