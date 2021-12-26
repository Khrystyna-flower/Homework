package BurgerCompany;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Order {

    private static final double CLASSIC_BURGER_PRICE = 50;
    private Scanner scanner = new Scanner(System.in);
    ArrayList<Integer> additions = new ArrayList<>();

    public void takeOrder() {
        greetCustomer();
        printMenu();
        offerExtraItems();
    }

    private void greetCustomer() {
        System.out.println("Welcome to Heavenly Burgers!");
    }

    private void printMenu() {
        System.out.println("Our classic burger costs $" + CLASSIC_BURGER_PRICE + "\n" +
                "Additional items are available: ");
        ExtraItem.printExtraItems();
    }

    private void offerExtraItems() {
        System.out.println("Would you like to add an extra item to your burger? For Yes, enter 1, for No, enter 0: ");
        boolean isValid = false;
        int choice = 0;
        try {
            while (!isValid) {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 0:
                        isValid = true;
                        finalizeOrder();
                        break;
                    case 1:
                        isValid = true;
                        addExtraItems();
                        break;
                    default:
                        System.out.println("The input is invalid. For Yes, enter 1, for No, enter 0: ");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Your order cannot be processed...");
        }
    }

    private void addExtraItems() {
        System.out.println("Please enter a number of an item you would like to add. Enter 0 to Cancel: ");
        ExtraItem.printExtraItems();
        boolean isValid = false;
        try {
            while (!isValid) {
                int customerChoice = scanner.nextInt();
                scanner.nextLine();
                switch (customerChoice) {
                    case 0:
                        isValid = true;
                        finalizeOrder();
                        break;
                    case 1: case 2: case 3:
                        isValid = true;
                        additions.add(customerChoice);
                        offerExtraItems();
                        break;
                    default:
                        System.out.println("The input is invalid. Please enter a number of an item you would like to add. Enter 0 to Cancel");
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
        }

    }

    private void finalizeOrder() {

        double sum = CLASSIC_BURGER_PRICE;
        System.out.println("*********************************************************" +
                "\n Your order: \n\t" +
                "Classic burger: $" + CLASSIC_BURGER_PRICE);

        for (int itemId : additions) {
            sum += ExtraItem.getItemById(itemId).getPrice();
            System.out.println("\tExtras: " + ExtraItem.getItemById(itemId).getItem() + ": $" + ExtraItem.getItemById(itemId).getPrice());
        }
        System.out.println("Total to pay: $" + sum + ". Thank you for your order!");


    }

}
