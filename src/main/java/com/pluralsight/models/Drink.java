package com.pluralsight.models;

import com.pluralsight.util.FixedValues;

public class Drink {
    private final String size;
    private final String flavor;
    private final boolean bottled;

    public Drink(String size, String flavor, boolean bottled) {
        this.size = size;
        this.flavor = flavor;
        this.bottled = bottled;
    }

    public double getPrice() {
        return bottled ? FixedValues.BOTTLED_DRINK_PRICE : FixedValues.DRINK_PRICES.getOrDefault(size, 0.0);
    }

    public String getSummary() {
        return (bottled ? "Bottled " : size + " ") + flavor + " ($" + String.format("%.2f", getPrice()) + ")";
    }
}


