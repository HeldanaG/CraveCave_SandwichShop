package com.pluralsight.models;

import com.pluralsight.util.FixedValues;

public class Topping {
        private String name;
        private boolean isExtra;

        public Topping(String name, boolean isExtra) {
            this.name = name;
            this.isExtra = isExtra;
        }

        public boolean isExtra() {
            return isExtra;
        }

        public double getPrice(int size, boolean isMeat) {
            double basePrice = isMeat ? FixedValues.MEAT_PRICES.get(size) : FixedValues.CHEESE_PRICES.get(size);
            if (isExtra) {
                basePrice += isMeat ? FixedValues.EXTRA_MEAT.get(size) : FixedValues.EXTRA_CHEESE.get(size);
            }
            return basePrice;
        }

        public String getName() {
            return name + (isExtra ? " (extra)" : "");
        }
    }
