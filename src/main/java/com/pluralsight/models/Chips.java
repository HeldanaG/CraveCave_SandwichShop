package com.pluralsight.models;

import com.pluralsight.util.FixedValues;

public class Chips {
    private final String type;

    public Chips(String type) {
        this.type = type;
    }

    public double getPrice() {
        return FixedValues.CHIPS_PRICE;
    }

    public String getType() {
        return type;
    }
}
