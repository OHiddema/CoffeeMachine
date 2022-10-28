package machine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CoffeeMachine cofMac = new CoffeeMachine(400, 540, 120, 9, 550);
        Scanner scanner = new Scanner(System.in);

        State currentState = cofMac.getState();
        do {
            switch (currentState) {
                case MAIN_MENU -> {
                    System.out.println("Write action (buy, fill, take, remaining, exit): ");
                    cofMac.processInput(scanner.nextLine());
                }
                case FILL_STEP1 -> {
                    System.out.println("Write how many ml of water you want to add:");
                    cofMac.processInput(scanner.nextLine());
                }
                case FILL_STEP2 -> {
                    System.out.println("Write how many ml of milk you want to add:");
                    cofMac.processInput(scanner.nextLine());
                }
                case FILL_STEP3 -> {
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    cofMac.processInput(scanner.nextLine());
                }
                case FILL_STEP4 -> {
                    System.out.println("Write how many disposable cups you want to add:");
                    cofMac.processInput(scanner.nextLine());
                }
                case BUY -> {
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                    cofMac.processInput(scanner.nextLine());
                }
            }
            currentState = cofMac.getState();
        } while (currentState != State.EXIT);
    }
}