package Bill_Generator;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to PizzaCodeHub by Palak Singhal");
        System.out.println("=======================================");

        // Customer details
        System.out.print("Enter your name: ");
        String customerName = scanner.next();
        
        // Validate phone number
        String phoneNumber;
        do {
            System.out.print("Enter your phone number: ");
            phoneNumber = scanner.next();
        } while (!isValidPhoneNumber(phoneNumber));

        // Base Pizza
        System.out.print("Would you like a vegetarian pizza? (Y/N): ");
        boolean isVegetarian = scanner.next().equalsIgnoreCase("Y");

        Pizza basePizza = new Pizza(isVegetarian);
        customizePizza(basePizza, scanner);

        // Choose payment method
        System.out.println("Select payment method:");
        System.out.println("1. Cash");
        System.out.println("2. UPI (You will get a discount of 5%)");
        int paymentMethod = scanner.nextInt();

        // Process payment
        processPayment(basePizza, paymentMethod, customerName);

        // Display the bill
        basePizza.getBill();

        // Close the Scanner
        scanner.close();
    }

    // Method to validate phone number
    private static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("\\d{10}");
    }

    // Method to customize pizza based on user input
    private static void customizePizza(Pizza pizza, Scanner scanner) {
        System.out.print("Do you want extra cheese? (Y/N): ");
        if (scanner.next().equalsIgnoreCase("Y")) {
            pizza.addExtraCheese();
        }

        System.out.print("Do you want extra toppings? (Y/N): ");
        if (scanner.next().equalsIgnoreCase("Y")) {
            pizza.addExtraToppings();
        }

        System.out.print("Do you want to take away? (Y/N): ");
        if (scanner.next().equalsIgnoreCase("Y")) {
            pizza.takeAway();
        }
    }

    // Method to process payment
    private static void processPayment(Pizza pizza, int paymentMethod, String customerName) {
        switch (paymentMethod) {
            case 1: // Cash
                System.out.println("Payment by Cash for " + customerName + ". Please pay the actual bill amount: " + pizza.getTotalBill());
                break;

            case 2: // UPI
                double discountPercentage = 5.0;
                double discountAmount = (discountPercentage / 100) * pizza.getTotalBill();
                pizza.applyDiscount(discountAmount);
                System.out.println("Payment by UPI for " + customerName + ". You get a " + discountPercentage + "% discount. Paid amount: " + pizza.getTotalBill());
                break;

            default:
                System.out.println("Invalid payment method. Please choose a valid option.");
        }
    }
}
