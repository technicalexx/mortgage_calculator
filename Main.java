import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //declaring constants:
        final int MONTHS = 12;
        final int PERCENT = 100;

        System.out.println("\nWelcome to the Simple Mortgage Calculator App!");
        System.out.println("\nTo calculate your monthly payments, you will need to provide:");
        System.out.println("Principal amount, annual interest rate, and mortgage period in years.");

        Scanner scanInput = new Scanner(System.in);
        System.out.print("\nEnter Principal Amount: ");
        Double principal = scanInput.nextDouble();
        System.out.print("\nEnter Annual Interest Rate: ");
        Double annualRate = scanInput.nextDouble();
        System.out.print("\nEnter Mortgage Period (in years): ");
        int periodYears = scanInput.nextInt();
        scanInput.close();

        double monthlyRate = (annualRate / PERCENT) / MONTHS;
        int numberMonths = periodYears * MONTHS;

        double powerCalc = Math.pow(1+monthlyRate, numberMonths);
        double numerator = monthlyRate * powerCalc;
        double denominator = powerCalc - 1;
        double monthlyPayment = principal * (numerator / denominator);
        String result = NumberFormat.getCurrencyInstance().format(monthlyPayment);

        System.out.println("\nYour Monthly Payment is: " + result);



    }
}