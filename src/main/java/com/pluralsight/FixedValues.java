package com.pluralsight;
import java.util.*;

// PriceTable for consistent pricing logic
public class FixedValues {

    public static final Map<Integer, Double> SANDWICH_PRICES = Map.of(
            4, 5.50,
            8, 7.00,
            12, 8.50
    );

    public static final Map<Integer, Double> MEAT_PRICES = Map.of(
            4, 1.00,
            8, 2.00,
            12, 3.00
    );

    public static final Map<Integer, Double> EXTRA_MEAT = Map.of(
            4, 0.50,
            8, 1.00,
            12, 1.50
    );

    public static final Map<Integer, Double> CHEESE_PRICES = Map.of(
            4, 0.75,
            8, 1.50,
            12, 2.25
    );

    public static final Map<Integer, Double> EXTRA_CHEESE = Map.of(
            4, 0.30,
            8, 0.60,
            12, 0.90
    );

    public static final Map<String, Double> DRINK_PRICES = Map.of(
            "Small", 2.00,
            "Medium", 2.50,
            "Large", 3.00
    );

    public static final double CHIPS_PRICE = 1.50;

    public static final List<String> REGULAR_TOPPINGS = Arrays.asList(
            "lettuce", "peppers", "onions", "tomatoes", "jalapeños",
            "cucumbers", "pickles", "guacamole", "mushrooms"
    );

    public static final List<String> SAUCES = Arrays.asList(
            "mayo", "mustard", "ketchup", "ranch", "thousand islands", "vinaigrette"
    );

    public static final List<String> SIDES = Arrays.asList(
            "au jus", "sauce"
    );
}
