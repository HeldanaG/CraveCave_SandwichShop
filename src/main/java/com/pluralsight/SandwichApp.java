package com.pluralsight;

import com.pluralsight.ui.UserInterface;

import java.util.Scanner;

public class SandwichApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(
                         "[=================== CRAVE CAVE SANDWICH SHOP 🥪 ===================]\n" +
                        "[         Bold Bites. Fresh Ingredients. Endless Customization.     ]\n"+
                        "[         1) New Order                                                ]\n"+
                        "[         0) Exit                                                     ]");

        System.out.print("Choose an option: ");
        String option = scanner.nextLine();

        if (option.equals("1")) {
            UserInterface ui = new UserInterface();
           ui.runApp();
        } else {
            System.out.println("Goodbye");
        }
    }
}
