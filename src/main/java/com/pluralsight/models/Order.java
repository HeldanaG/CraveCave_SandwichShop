package com.pluralsight.models;

import com.pluralsight.models.*;
import com.pluralsight.util.FixedValues;

import java.util.*;

public class Order {
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<String> chips = new ArrayList<>();

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addChips(String chipType) {
        chips.add(chipType);
    }

    public double getTotal() {
        double total = 0.0;
        for (Sandwich s : sandwiches) total += s.calculatePrice();
        for (Drink d : drinks) total += d.getPrice();
        total += chips.size() * FixedValues.CHIPS_PRICE;
        return total;
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public List<String> getChips() {
        return chips;
    }

    public String getOrderSummary() {
        StringBuilder sb = new StringBuilder("📦 Order Summary:\n");
        int count = 1;

        for (Sandwich s : sandwiches) {
            sb.append("🥪 Sandwich #").append(count++).append(":\n");
            sb.append(s.getSummary()).append("\n\n");
        }

        if (!drinks.isEmpty()) {
            sb.append("🧃 Drinks:\n");
            for (Drink d : drinks) {
                sb.append(" - ").append(d.getSummary()).append("\n");
            }
        }

        if (!chips.isEmpty()) {
            sb.append("🥔 Chips:\n");
            for (String c : chips) {
                sb.append(" - ").append(c).append(" ($").append(String.format("%.2f", FixedValues.CHIPS_PRICE)).append(")\n");
            }
        }

        sb.append("\n💰 Total: $").append(String.format("%.2f", getTotal()));
        return sb.toString();
    }
}
