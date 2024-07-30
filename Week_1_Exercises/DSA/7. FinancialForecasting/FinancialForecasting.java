import java.util.Scanner;
public class FinancialForecasting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the initial value:");
        double initialValue = scanner.nextDouble();
        System.out.println("Enter the number of past growth rates:");
        int n = scanner.nextInt();
        double[] growthRates = new double[n];
        System.out.println("Enter the past growth rates (as percentages, e.g., 5 for 5%):");
        for (int i = 0; i < n; i++) {
            growthRates[i] = scanner.nextDouble() / 100;  
        }
        System.out.println("Enter the number of years into the future you want to predict:");
        int futureYears = scanner.nextInt();
        double futureValue = calculateFutureValueRecursive(initialValue, growthRates, futureYears, 0);
        System.out.println("The predicted future value after " + futureYears + " years is: " + futureValue);
        scanner.close();
    }

    public static double calculateFutureValueRecursive(double initialValue, double[] growthRates, int futureYears, int currentYear) {
        if (futureYears == 0) {
            return initialValue;
        }
        double growthRate = growthRates[currentYear % growthRates.length];
        double newValue = initialValue * (1 + growthRate);
        return calculateFutureValueRecursive(newValue, growthRates, futureYears - 1, currentYear + 1);
    }
}
