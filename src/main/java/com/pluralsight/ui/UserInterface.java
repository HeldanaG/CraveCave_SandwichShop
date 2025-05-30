
package com.pluralsight.ui;

import com.pluralsight.models.SignatureSandwich;
import com.pluralsight.util.FixedValues;
import com.pluralsight.models.Drink;
import com.pluralsight.models.Order;
import com.pluralsight.models.Sandwich;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class UserInterface {
    private final Scanner scanner;
    private final Order order;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
        this.order = new Order();
    }

    // Main loop of the application: displays the menu and handles user input for different actions.
    public void runApp() {
        boolean appRunning = true;

        while (appRunning) {
            try {
                FixedValues.displayMainMenu();
                String menuChoice = askQuestion("Please enter your choice: ").trim();

                switch (menuChoice) {
                    case "1" -> addSandwich();
                    case "2" -> addDrink();
                    case "3" -> addChips();
                    case "4" -> addSignatureSandwich();
                    case "5" -> checkout();
                    case "0" -> {
                        System.out.println("Order canceled. Goodbye!");
                        appRunning = false;
                    }
                    default -> System.out.println("Invalid choice! Please select 1, 2, 3, 4, or 0.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please try again.");
                scanner.nextLine();
            }
        }
    }

    // Handles the process of customizing a sandwich: bread, size, toasted, meats, cheeses, toppings, sauces, and sides.
    private void addSandwich() {
        FixedValues.displaySandwichMenu();
        String bread = capitalizeWords(getValidString("Choose bread type: "));
        int size = Integer.parseInt(getValidatedNumber("What size: "));
        boolean toasted = askQuestion("Would you like it toasted? (yes or no): ").equalsIgnoreCase("yes");

        Sandwich sandwich = new Sandwich(bread, size, toasted);
        while (true) {
            String meat = capitalizeWords(getValidString("Enter meat (or 'done'): "));
            if (meat.equalsIgnoreCase("done")) break;
            boolean extra = askQuestion("Extra meat? (yes or no): ").equalsIgnoreCase("yes");
            sandwich.addMeat(meat, extra);
            break;
        }
        while (true) {
            String cheese = capitalizeWords(getValidString("Enter cheese (or 'done'): "));
            if (cheese.equalsIgnoreCase("done")) break;
            boolean extra = askQuestion("Extra cheese? (yes or no): ").equalsIgnoreCase("yes");
            sandwich.addCheese(cheese, extra);
            break;
        }
        while (true) {
            String toppingInput = getValidString("Enter toppings separated by commas (or 'none'): ");
            if (toppingInput.equalsIgnoreCase("none")) break;
            List<String> valid = new ArrayList<>();
            List<String> invalid = new ArrayList<>();

            for (String item : toppingInput.split(",")) {
                String t = capitalizeWords(item.trim());
                if (FixedValues.REGULAR_TOPPINGS.contains(t.toLowerCase())) {
                    valid.add(t);
                } else {
                    invalid.add(t);
                }
            }

            if (!invalid.isEmpty()) {
                System.out.println("We don't have: " + String.join(", ", invalid));
                if (!askQuestion("Would you like to re-enter toppings? (yes or no): ").equalsIgnoreCase("yes")) {
                    break;
                }
            } else {
                System.out.println("You selected: " + String.join(", ", valid));
                if (askQuestion("Is this correct? (yes or no): ").equalsIgnoreCase("yes")) {
                    for (String t : valid) sandwich.addTopping(t);
                    break;
                }
            }
        }
        while (true) {
            String sauceInput = getValidString("Enter sauces separated by commas (or 'none'): ");
            if (sauceInput.equalsIgnoreCase("none")) break;
            List<String> valid = new ArrayList<>();
            List<String> invalid = new ArrayList<>();

            for (String item : sauceInput.split(",")) {
                String s = capitalizeWords(item.trim());
                if (FixedValues.SAUCES.contains(s.toLowerCase())) {
                    valid.add(s);
                } else {
                    invalid.add(s);
                }
            }

            if (!invalid.isEmpty()) {
                System.out.println("We don't have: " + String.join(", ", invalid));
                if (!askQuestion("Would you like to re-enter sauces? (yes or no): ").equalsIgnoreCase("yes")) {
                    break;
                }
            } else {
                System.out.println("You selected: " + String.join(", ", valid));
                if (askQuestion("Is this correct? (yes or no): ").equalsIgnoreCase("yes")) {
                    for (String s : valid) sandwich.addSauce(s);
                    break;
                }
            }
        }
        while (true) {
            String sideInput = getValidString("Enter sides separated by commas (or 'none'): ");
            if (sideInput.equalsIgnoreCase("none")) break;
            List<String> valid = new ArrayList<>();
            List<String> invalid = new ArrayList<>();

            for (String item : sideInput.split(",")) {
                String s = capitalizeWords(item.trim());
                if (FixedValues.SIDES.contains(s.toLowerCase())) {
                    valid.add(s);
                } else {
                    invalid.add(s);
                }
            }

            if (!invalid.isEmpty()) {
                System.out.println("We don't have: " + String.join(", ", invalid));
                if (!askQuestion("Would you like to re-enter sides? (yes or no): ").equalsIgnoreCase("yes")) {
                    break;
                }
            } else {
                System.out.println("You selected: " + String.join(", ", valid));
                if (askQuestion("Is this correct? (yes or no): ").equalsIgnoreCase("yes")) {
                    for (String s : valid) sandwich.addSide(s);
                    break;
                }
            }
        }

        System.out.println("\nPlease review your sandwich:");
        System.out.println(sandwich.getSummary());

        String confirm = getValidString("Is this correct? (yes to confirm, no to start over): ");
        if (confirm.equalsIgnoreCase("yes")) {
            order.addSandwich(sandwich);
            System.out.println("Sandwich added successfully!");
            System.out.println("-----------------------------------------------------------------------------------");

            String next = getValidString("\nWould you like to (A)checkout,(B)addDrinks or (C)addChips: ").toUpperCase();
            switch (next) {
                case "A" -> checkout();
                case "B" -> addDrink();
                case "C" -> addChips();
                default -> System.out.println("Invalid option. Returning to main menu...");
                }
        } else {
            System.out.println("Let's start your sandwich order again.");
            addSandwich();  // Restart
        }

    }

    // Allows the user to select a drink, either bottled or fountain, with validation and review confirmation.
    private void addDrink() {
        FixedValues.displayDrinkMenu();
        boolean isBottled = askQuestion("Would you like a bottled drink? (yes or no): ").equalsIgnoreCase("yes");
        String size = "";
        String flavor;

        if (isBottled) {
            while (true) {
                flavor = getValidString("Enter name: ").toLowerCase();
                if (FixedValues.BOTTLED_DRINKS.contains(flavor)) break;
                System.out.println("Invalid bottled drink. Please choose from the list.");
            }
        } else {
            while (true) {
                size = capitalizeWords(getValidString("Enter drink size (Small, Medium, Large): "));
                if (FixedValues.DRINK_PRICES.containsKey(size)) break;
                System.out.println("Invalid size! Please enter Small, Medium, or Large.");
            }

            while (true) {
                flavor = capitalizeWords(getValidString("Enter flavor: "));
                if (FixedValues.DRINK_FLAVORS.contains(flavor)) break;
                System.out.println("Invalid flavor. Please choose from the list above.");
            }
        }

        Drink drink = new Drink(size, flavor, isBottled);
        System.out.println("You selected: " + drink.getSummary());

        if (getValidString("Is this correct? (yes or no): ").equalsIgnoreCase("yes")) {
            order.addDrink(drink);
            System.out.println("\nDrink added successfully!");
            System.out.println("-----------------------------------------------------------------------------------");


            String next = getValidString("\nWould you like to checkout or return to main menu? ");
            switch (next) {
                case "checkout" -> checkout();
                default -> System.out.println("Returning to main menu...");
            }
        } else {
            System.out.println("Let's try again.");
            addDrink();
        }
    }

    // Handles chip selection with price confirmation and option to proceed or return to the main menu.
    private void addChips() {
        FixedValues.displayChipsMenu();
        String chipType;
        while (true) {
            chipType = capitalizeWords(getValidString("Enter chips type: "));
            if (FixedValues.CHIP_TYPES.contains(chipType)) break;
            System.out.println("Invalid chip type. Please select from the available options.");
        }

        System.out.println("You selected: " + chipType + " ($" + String.format("%.2f", FixedValues.CHIPS_PRICE) + ")");
        if (getValidString("Is this correct? (yes or no): ").equalsIgnoreCase("yes")) {
            order.addChips(chipType);
            System.out.println("\nChips added successfully!");
            System.out.println("-----------------------------------------------------------------------------------");
            String next = getValidString("\nWould you like to checkout or return to main menu? ");
            switch (next.toLowerCase()) {
                case "checkout" -> checkout();
                default -> System.out.println("Returning to main menu...");
            }
        } else {
            System.out.println("Let's try again.");
            addChips();
        }
    }

    // Displays and manages Signature Sandwich options. Allows customization and adds to order if confirmed.
    private void addSignatureSandwich() {
        FixedValues.displaySignatureMenu();

        String choice = getValidString("Enter the name of the sandwich: ").toLowerCase();
        String selectedName;

        switch (choice) {
            case "blt":
                selectedName = "BLT";
                break;
            case "philly cheese steak":
                selectedName = "Philly Cheese Steak";
                break;
            case "chicken club":
                selectedName = "Chicken Club";
                break;
            case "veggie delight":
                selectedName = "Veggie Delight";
                break;
            default:
                System.out.println("Invalid selection. Returning to main menu.");
                return;
        }

        SignatureSandwich ss = new SignatureSandwich(selectedName);

        System.out.println("\nHere's your selected sandwich:");
        System.out.println(ss.getSummary());

        if (getValidString("Would you like to customize this sandwich? (yes or no): ").equalsIgnoreCase("yes")) {
            ss.customize();
            System.out.println("\nYour customized sandwich:");
            System.out.println(ss.getSummary());
        }

        if (getValidString("Would you like to confirm and add this to your order? (yes or no): ").equalsIgnoreCase("yes")) {
            order.addSandwich(ss);
            System.out.println("Signature sandwich added successfully!");
            System.out.println(order.getOrderSummary());

            String next = getValidString("\nWould you like to (A) Checkout, (B) Add Drink, (C) Add Chips, or (D) Return to main menu? ").toUpperCase();
            switch (next) {
                case "A" -> checkout();
                case "B" -> addDrink();
                case "C" -> addChips();
                default -> System.out.println("Returning to main menu...");
            }
        } else {
            System.out.println("No problem. Returning to main menu.");
        }
    }

    // Finalizes the order, calculates tax and tip, processes payment, prints a receipt, and saves it to a file.
    private void checkout() {
        double subtotal = order.getTotal();
        double taxRate = 0.0825;
        double tax = subtotal * taxRate;

        System.out.println(order.getOrderSummary());
        String tipPercentInput = askQuestion("Tip Options: 10%, 15%, 20% or press Enter to Skip (e.g. 15): ");
        double tipPercent = 0.0;
        try {
            tipPercent = Double.parseDouble(tipPercentInput);
        } catch (NumberFormatException e) {
            System.out.println("No tip will be applied.");
        }

        double tip = subtotal * (tipPercent / 100);
        double grandTotal = subtotal + tax + tip;

        System.out.println("Tax (8.25%): $" + String.format("%.2f", tax));
        System.out.println("Grand Total:"+grandTotal);
        String customerName = askQuestion("\nEnter name for the order: ");
        String paymentMethod = askQuestion("Select payment method (cash or card): ").toLowerCase();
        String maskedCard = "";

        if (paymentMethod.equals("card")) {
            String fullName = askQuestion("Enter full name on card: ");
            String cardNumber = askQuestion("Enter card number: ");
            String expDate = askQuestion("Enter expiration date (MM/YY): ");
            String cvv = askQuestion("Enter Sec Code: ");
            maskedCard = "************" + cardNumber.substring(cardNumber.length() - 4);
            System.out.println("Processing card... Approved.");
        } else if (paymentMethod.equals("cash")) {
            double cashGiven;
            while (true) {
                try {
                    cashGiven = Double.parseDouble(askQuestion("Enter cash amount given: $"));
                    if (cashGiven < grandTotal) {
                        System.out.println("Insufficient amount. Please enter a valid amount.");
                    } else {
                        double change = cashGiven - grandTotal;
                        System.out.println("Change to return: $" + String.format("%.2f", change));
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                }
            }
        } else {
            System.out.println("Unknown payment method. Returning to main menu...");
            return;
        }

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        StringBuilder receiptContent = new StringBuilder();
        receiptContent.append("\n|==================== RECEIPT ====================|\n");
        receiptContent.append("| Date: ").append(timestamp).append("\n");
        receiptContent.append("| Customer Name: ").append(customerName).append("\n");
        receiptContent.append("| ------------------------------------------------|\n");
        receiptContent.append("| Items Ordered:\n");
        for (Sandwich s : order.getSandwiches()) {
            receiptContent.append("| Sandwich:\n");
            for (String line : s.getSummary().split("\\n")) {
                receiptContent.append("| ").append(line).append("\n");
            }
            receiptContent.append("|\n");
        }
        for (Drink d : order.getDrinks()) {
            receiptContent.append("| Drink: ").append(d.getSummary()).append("\n");
        }
        for (String c : order.getChips()) {
            receiptContent.append("| Chips: ").append(c).append(" ($").append(String.format("%.2f", FixedValues.CHIPS_PRICE)).append(")\n");
        }
        receiptContent.append("| ------------------------------------------------|\n");
        receiptContent.append("| Subtotal: $").append(String.format("%.2f", subtotal)).append("\n");
        receiptContent.append("| Tax (8.25%): $").append(String.format("%.2f", tax)).append("\n");
        receiptContent.append("| Tip (" + tipPercent + "%): $").append(String.format("%.2f", tip)).append("\n");
        receiptContent.append("| Total: $").append(String.format("%.2f", grandTotal)).append("\n");

        if (paymentMethod.equals("card")) {
            receiptContent.append("| Payment Method: CARD (ending in ").append(maskedCard.substring(maskedCard.length() - 4)).append(")\n");
        } else {
            receiptContent.append("| Payment Method: CASH\n");
        }
        receiptContent.append("|=================================================|\n");
        System.out.println(receiptContent);

        saveReceipt(receiptContent.toString());
        System.out.println("Order complete. Thank you! Receipt saved.");
        System.exit(0);
    }

    // Writes the receipt content to a timestamped file under the receipts folder.
    private void saveReceipt(String receiptContent) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        String directoryPath = "src/main/resources/receipts";
        String filename = directoryPath + "/" + timestamp + ".txt";

        File dir = new File(directoryPath);
        if (!dir.exists()) dir.mkdirs();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(receiptContent);
        } catch (IOException e) {
            System.out.println("Error writing receipt: " + e.getMessage());
        }
    }

    // Utility method to prompt the user with a question and return their input.
    private static String askQuestion(String prompt) {
        System.out.print(prompt);
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    // Ensures user input is non-numeric and not empty; used for names and text inputs.
    private static String getValidString(String prompt) {
        while (true) {
            String input = askQuestion(prompt);
            if (input.isEmpty()) {
                System.out.println("This field cannot be empty.");
            } else if (input.matches("\\d+")) {
                System.out.println("Input cannot be numbers.");
            } else {
                return input;
            }
        }
    }

    // Ensures the input is a valid numeric string, used for size selection or payment input.
    private static String getValidatedNumber(String prompt) {
        while (true) {
            String input = askQuestion(prompt);
            if (input.isEmpty()) {
                System.out.println("This field cannot be empty.");
            } else if (!input.matches("[\\d.]+")) {
                System.out.println("Please enter a valid number (digits only).\n");
            } else {
                return input;
            }
        }
    }

    // Capitalizes the first letter of each word in the input string.
    private static String capitalizeWords(String input) {
        String[] words = input.trim().toLowerCase().split("\\s+");
        StringBuilder capitalized = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                capitalized.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1))
                        .append(" ");
            }
        }
        return capitalized.toString().trim();
    }
}
