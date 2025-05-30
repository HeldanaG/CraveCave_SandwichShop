package com.pluralsight.util;
import java.util.*;

// PriceTable for consistent pricing logic
public class FixedValues {

    public static final double CHIPS_PRICE = 1.50;
    public static final double BOTTLED_DRINK_PRICE = 3.25;


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

    public static final List<String> BOTTLED_DRINKS = Arrays.asList(
            "sparkling water", "iced tea", "orange juice", "bottled water"
    );


    public static final List<String> DRINK_FLAVORS = Arrays.asList(
            "Coke", "Sprite", "Fanta" ,"Lemonade", "Root Beer", "Mountain Blast", "Dr. Pepper");

    public static final List<String> CHIP_TYPES = Arrays.asList(
            "Lays", "Doritos", "Cheetos", "BBQ Chips", "Salt & Vinegar"
    );

    public static final List<String> REGULAR_TOPPINGS = Arrays.asList(
            "lettuce", "peppers", "onions", "tomatoes", "jalapeños",
            "cucumbers", "pickles", "guacamole", "mushrooms"
    );

    public static final List<String> SAUCES = Arrays.asList(
            "mayo", "mustard", "ketchup", "ranch", "thousand islands", "vinaigrette"
    );

    public static final List<String> SIDES = Arrays.asList(
            "au jus", "sauce", "coleslaw", "potato salad", "macaroni salad",
            "pickle spear", "fruit cup", "cup of soup"
    );

    public static void displayMainMenu() {
        System.out.println(
                        "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                        "            🥪 WELCOME TO CRAVE CAVE SANDWICH SHOP 🥪                              \n" +
                        "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                        " What would you like to do today?                                                  \n" +
                        " 1 - Add Sandwich                                                                  \n" +
                        " 2 - Add Drink                                                                     \n" +
                        " 3 - Add Chips                                                                     \n" +
                        " 4 - Signature Sandwiches                                                          \n" +
                        " 5 - Checkout                                                                      \n" +
                        " 0 - Cancel Order                                                                  \n" +
                        "-----------------------------------------------------------------------------------");
    }

    public static void displaySignatureMenu() {
        System.out.println(
                        "//==================== SIGNATURE SANDWICH MENU ====================//\n" +
                        "| 1 - 🥓 BLT                                                      |\n" +
                        "|     • 8\" White Bread, Toasted                                   |\n" +
                        "|     • Bacon, Cheddar                                            |\n" +
                        "|     • Lettuce, Tomatoes                                         |\n" +
                        "|     • Ranch, Au Jus                                             |\n" +
                        "|                                                                 |\n" +
                        "| 2 - 🧀 Philly Cheese Steak                                      |\n" +
                        "|     • 8\" White Bread, Toasted                                   |\n" +
                        "|     • Steak, American Cheese                                    |\n" +
                        "|     • Peppers, Mayo, Coleslaw                                   |\n" +
                        "|                                                                 |\n" +
                        "| 3 - 🐔 Chicken Club                                             |\n" +
                        "|     • 8\" White Bread, Toasted                                   |\n" +
                        "|     • Chicken, Bacon, Swiss                                     |\n" +
                        "|     • Lettuce, Tomatoes, Mayo, Potato Salad                     |\n" +
                        "|                                                                 |\n" +
                        "| 4 - 🥦 Veggie Delight                                           |\n" +
                        "|     • 8\" White Bread, Toasted                                   |\n" +
                        "|     • Provolone                                                 |\n" +
                        "|     • Lettuce, Tomatoes, Peppers, Cucumbers, Pickles            |\n" +
                        "|     • Vinaigrette, Fruit Cup                                    |\n" +
                        "//=================================================================//"
        );
    }

    public static void displaySandwichMenu() {
        System.out.println(
                        "//====================== SANDWICH MENU ======================//\n" +
                        "|  🍞 Bread Types                                            |\n" +
                        "|   • White   • Wheat   • Rye   • Wrap                       |\n" +
                        "|                                                            |\n" +
                        "|  🥪 Sandwich Sizes                                         |\n" +
                        "|   • 4\" - $5.50   • 8\" - $7.00   • 12\" - $8.50               |\n" +
                        "|                                                            |\n" +
                        "|  🥩 Meat Options (4- $1.00 ,8- $2.00 ,12- $3.00)           |\n" +
                        "|   • Turkey   • Ham   • Roast Beef   • Chicken              |\n" +
                        "|   • Salami   • Bacon   • Tuna                              |\n" +
                        "|                                                            |\n" +
                        "|  🧀 Cheese Options (4- $0.75 ,8- $1.50 ,12- $2.25)         |\n" +
                        "|   • American   • Provolone   • Cheddar   • Swiss           |\n" +
                        "|                                                            |\n" +
                        "|  🥩 Extra Meat (per size)                                  |\n" +
                        "|   • 4\" - $0.50   • 8\" - $1.00   • 12\" - $1.50              |\n" +
                        "|                                                            |\n" +
                        "|  🧀 Extra Cheese (per size)                                |\n" +
                        "|   • 4\" - $0.30   • 8\" - $0.60   • 12\" - $0.90              |\n" +
                        "|                                                            |\n" +
                        "|  🥬 Toppings (no cost)                                     |\n" +
                        "|   🥬 Lettuce   🌶️ Peppers   🧅 Onions   🥑 Guacamole      |\n" +
                        "|   🍅 Tomatoes   🌶️ Jalapeños   🥒 Cucumbers   🥒 Pickles  |\n" +
                        "|   🍄 Mushrooms                                             |\n" +
                        "|                                                            |\n" +
                        "|  🧂 Sauces (no cost)                                       |\n" +
                        "|   🧂 Mayo   🌭 Mustard   🍅 Ketchup   🥛 Ranch            |\n" +
                        "|   🫒 Vinaigrette   🍹 Thousand Islands                    |\n" +
                        "|                                                            |\n" +
                        "|  🍽️ Sides (no cost)                                        |\n" +
                        "|   🍖 Au Jus   🍯 Sauce   🥗 Coleslaw   🥔 Potato Salad    |\n" +
                        "|   🍝 Macaroni Salad   🥒 Pickle Spear   🍇 Fruit Cup      |\n" +
                        "|   🍜 Cup of Soup                                           |\n" +
                        "//===========================================================//\n"
        );

    }
        public static void displayDrinkMenu() {
        System.out.println(
                        "//====================== DRINK MENU ====================//\n"+
                        "|  🥤 Fountain Drink Sizes                              |\n" +
                        "|   • Small   - $2.00                                   |\n" +
                        "|   • Medium  - $2.50                                   |\n" +
                        "|   • Large   - $3.00                                   |\n" +
                        "|                                                       |\n" +
                        "| 🧃 Fountain Flavors                                   |\n" +
                        "|   🥤 Coke   🥤 Sprite   🥤 Fanta   🍋 Lemonade       |\n" +
                        "|   🥤 Root Beer   🧃 Mountain Blast   🥤 Dr. Pepper   |\n" +
                        "|                                                       |\n" +
                        "|   Bottled Drinks (Flat $3.25)                         |\n" +
                        "|   💧 Sparkling Water   🍹 Iced Tea                   |\n" +
                        "|   🍊 Orange Juice   🚰 Bottled Water                 |\n" +
                        "//=====================================================//\n");
    }
    public static void displayChipsMenu() {
        System.out.print(
                        "\n//============== CHIPS MENU =========================//"+
                        "|  🥔 Available Chip Types (Flat $1.50 Each)           |\n" +
                        "|    • Lays       • Doritos                            |\n" +
                        "|    • Cheetos    • BBQ Chips                          |\n" +
                        "|    • Salt & Vinegar                                  |\n" +
                        "//=====================================================//\n");
    }
}
