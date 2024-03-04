import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanInput = new Scanner(System.in);

        String name = userName(scanInput);
        greeting(name);

        double principal = readInput(scanInput, "\nEnter Principal Amount: ", 1, 10_000_000);
        double annualRate = readInput(scanInput, "\nEnter Annual Interest Rate: ", 0, 50);
        int periodYears = (int)readInput(scanInput, "\nEnter Mortgage Period (in years): ", 1, 40);

        double mortgagePayment = mortgageCalculator(principal, annualRate, periodYears);
        String result = NumberFormat.getCurrencyInstance().format(mortgagePayment);
        System.out.println("\nYour Monthly Payment is: " + result);

        scanInput.close();
    }

    public static String userName(Scanner scanInput) {
        String name = "";
        System.out.print("\nPlease, enter your name: ");
        name = scanInput.nextLine();
        return name;
    }

    public static void greeting(String name) {
        System.out.println("\nHello, " + name + "!");
        System.out.println("\nWelcome to the Simple Mortgage Calculator App.");
        System.out.println("\n***********************************************************************");
        System.out.println("To calculate your monthly payments, you will need to provide:");
        System.out.println("Principal amount, annual interest rate, and mortgage period in years.");
        System.out.println("***********************************************************************");
    }

    public static double readInput(Scanner scanInput, String prompt, int minValue, int maxValue) {
        double input = 0;
        while(true) {
            System.out.print(prompt);
            input = scanInput.nextDouble();
            if (input > minValue && input < maxValue)
                break;
            System.out.println("Enter a number between " + minValue + " and " + maxValue);
        }
        return input;
    }

    public static double mortgageCalculator(double amount, double rate, int years) {
        //declaring constants:
        final int MONTHS = 12;
        final int PERCENT = 100;

        double monthlyRate = (rate / PERCENT) / MONTHS;
        int numberMonths = years * MONTHS;

        double powerCalc = Math.pow(1+monthlyRate, numberMonths);
        double numerator = monthlyRate * powerCalc;
        double denominator = powerCalc - 1;
        double monthlyPayment = amount * (numerator / denominator);

        return monthlyPayment;
    }
}