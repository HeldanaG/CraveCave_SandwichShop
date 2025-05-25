package com.pluralsight;

import java.util.*;

public class Sandwich  {
    private String breadType;
    private int size;
    private boolean isToasted;
    private List<Topping> meats = new ArrayList<>();
    private List<Topping> cheeses = new ArrayList<>();
    private List<String> regularToppings = new ArrayList<>();
    private List<String> sauces = new ArrayList<>();

    public Sandwich(String breadType, int size, boolean isToasted) {
        this.breadType = breadType;
        this.size = size;
        this.isToasted = isToasted;
    }

    public void addMeat(String name, boolean isExtra) {
        meats.add(new Topping(name, isExtra));
    }

    public void addCheese(String name, boolean isExtra) {
        cheeses.add(new Topping(name, isExtra));
    }

    public void addTopping(String name) {
        if (FixedValues.REGULAR_TOPPINGS.contains(name.toLowerCase())) {
            regularToppings.add(name);
        }
    }

    public void addSauce(String name) {
        if (FixedValues.SAUCES.contains(name.toLowerCase())) {
            sauces.add(name);
        }
    }

    public double calculatePrice() {
        double price = FixedValues.SANDWICH_PRICES.getOrDefault(size, 0.0);
        for (Topping meat : meats) price += meat.getPrice(size, true);
        for (Topping cheese : cheeses) price += cheese.getPrice(size, false);
        return price;
    }

    public String getSummary() {
        StringBuilder sb = new StringBuilder();
        sb.append(size).append("\" ").append(breadType).append(isToasted ? " (Toasted)\n" : "\n");
        sb.append("Meats:\n"); for (Topping meat : meats) sb.append(" - ").append(meat.getName()).append("\n");
        sb.append("Cheeses:\n"); for (Topping cheese : cheeses) sb.append(" - ").append(cheese.getName()).append("\n");
        sb.append("Toppings:\n"); for (String topping : regularToppings) sb.append(" - ").append(topping).append("\n");
        sb.append("Sauces:\n"); for (String sauce : sauces) sb.append(" - ").append(sauce).append("\n");
        sb.append("Price: $").append(String.format("%.2f", calculatePrice()));
        return sb.toString();
    }
}
