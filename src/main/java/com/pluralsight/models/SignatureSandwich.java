package com.pluralsight.models;

import com.pluralsight.util.FixedValues;

import java.util.*;
import java.util.stream.Collectors;

public class SignatureSandwich extends Sandwich {
    private String name;
    private final Scanner scanner = new Scanner(System.in);

    public SignatureSandwich(String name) {
        super("White", 8, true); // default for all
        this.name = name;

        switch (name.toLowerCase()) {
            case "blt" -> {
                addMeat("Bacon", false);
                addCheese("Cheddar", false);
                addTopping("Lettuce");
                addTopping("Tomatoes");
                addSauce("Ranch");
                addSide("Au Jus");

            }
            case "philly cheese steak" -> {
                addMeat("Steak", false);
                addCheese("American", false);
                addTopping("Peppers");
                addSauce("Mayo");
                addSide("Coleslaw");
            }
            case "chicken club" -> {
                addMeat("Chicken", false);
                addCheese("Swiss", false);
                addTopping("Lettuce");
                addTopping("Tomatoes");
                addTopping("Bacon");
                addSauce("Mayo");
                addSide("Potato Salad");
            }
            case "veggie delight" -> {
                addCheese("Provolone", false);
                addTopping("Lettuce");
                addTopping("Tomatoes");
                addTopping("Peppers");
                addTopping("Cucumbers");
                addTopping("Pickles");
                addSauce("Vinaigrette");
                addSide("Fruit Cup");
            }
            default -> System.out.println("Unknown signature sandwich.");
        }
    }

    public String getName() {
        return name;
    }

    public void customize() {
        System.out.println("\nCurrent sandwich:");
        System.out.println(getSummary());

        if (ask("Would you like to remove or change meats?")) editCategory("meat", meats.stream().map(Topping::getName).collect(Collectors.toList()));
        if (ask("Would you like to remove or change cheeses?")) editCategory("cheese", cheeses.stream().map(Topping::getName).collect(Collectors.toList()));
        if (ask("Would you like to remove or change toppings?")) editCategory("topping", new ArrayList<>(getToppings()));
        if (ask("Would you like to remove or change sauces?")) editCategory("sauce", new ArrayList<>(getSauces()));
        if (ask("Would you like to remove or change sides?")) editCategory("side", new ArrayList<>(getSides()));

    }

    private void editCategory(String category, List<String> availableItems) {
        if (availableItems.isEmpty()) {
            System.out.println("No items to edit in this category.");
            return;
        }
        String action = askText("Would you like to remove or change items? (remove/change): ").toLowerCase();
        if (action.equals("remove")) {
            String input = askText("Enter items from current sandwich to remove (comma-separated): ");
            List<String> toRemove = Arrays.stream(input.split(","))
                    .map(String::trim).map(String::toLowerCase).toList();
            switch (category) {
                case "meat" -> meats.removeIf(m -> toRemove.contains(m.getName().toLowerCase()));
                case "cheese" -> cheeses.removeIf(c -> toRemove.contains(c.getName().toLowerCase()));
                case "topping" -> getToppings().removeIf(t -> toRemove.contains(t.toLowerCase()));
                case "sauce" -> getSauces().removeIf(s -> toRemove.contains(s.toLowerCase()));
                case "side" -> getSides().removeIf(s -> toRemove.contains(s.toLowerCase()));
            }
        } else if (action.equals("change")) {
            String fromItem = askText("Enter items from current sandwich to replace: ").toLowerCase();
            String toItem = askText("Enter the new item: ");
            switch (category) {
                case "meat" -> {
                    meats.removeIf(m -> m.getName().equalsIgnoreCase(fromItem));
                    boolean extra = ask("Would you like " + toItem + " as extra?");
                    addMeat(toItem, extra);
                }
                case "cheese" -> {
                    cheeses.removeIf(c -> c.getName().equalsIgnoreCase(fromItem));
                    boolean extra = ask("Would you like " + toItem + " as extra?");
                    addCheese(toItem, extra);
                }
                case "topping" -> {
                    getToppings().removeIf(t -> t.equalsIgnoreCase(fromItem));
                    addTopping(toItem);
                }
                case "sauce" -> {
                    getSauces().removeIf(s -> s.equalsIgnoreCase(fromItem));
                    addSauce(toItem);
                }
                case "side" -> {
                    getSides().removeIf(s -> s.equalsIgnoreCase(fromItem));
                    addSide(toItem);
                }
            }
        }
    }

    private boolean ask(String q) {
        System.out.print(q + " (yes or no): ");
        return scanner.nextLine().trim().equalsIgnoreCase("yes");
    }

    private String askText(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public List<String> getToppings() {
        return super.regularToppings;
    }

    public List<String> getSauces() {
        return super.sauces;
    }

    public List<String> getSides() {
        return super.sides;
    }
}
