# 🥪 Crave Cave Sandwich Shop 🥪

                              Bold Bites. Fresh Ingredients. Endless Customization.  
Crave Cave is a command-line Java application designed to simulate a point-of-sale (POS) system for a growing custom sandwich shop. This project was developed using Object-Oriented Programming (OOP) principles and supports dynamic sandwich building, drinks, chips, and receipt generation — all through a smooth CLI experience.

---

## 📦 Project Structure
```
src/
├── main/
│ ├── java/
│ │ └── com/
│ │ └── pluralsight/
│ │ ├── models/
│ │ │ ├── Sandwich.java
│ │ │ ├── Topping.java
│ │ │ ├── Drink.java
│ │ │ ├── Chips.java
│ │ │ ├── Order.java
│ │ │ └── SignatureSandwich.java
│ │ ├── ui/
│ │ │ └── UserInterface.java
│ │ ├── util/
│ │ │ └── FixedValues.java
│ │ └── SandwichApp.java
│ └── resources/
│ └── receipts/

```

## 🚀 Features

### 🥪 Sandwich Customization
- Choose bread (White, Wheat, Rye, Wrap)
- Select size (4", 8", 12")
- Add meats & cheeses (regular or extra)
- Add toppings, sauces, and sides (all validated)
- Toasted or not toasted
- Real-time sandwich summary display

### ⭐ Signature Sandwiches
Prebuilt sandwiches available with preset ingredients:
- **BLT**
- **Philly Cheese Steak**
- **Chicken Club**
- **Veggie Delight**

💡 Users can customize signature sandwiches by removing or replacing any ingredient.

### 🧃 Drinks & 🥔 Chips
- Choose from fountain or bottled drinks (multiple flavors)
- Select chips from a preset list
- Prices are automatically calculated

### 🧾 Receipt Generation
- Dynamic receipt includes:
  - Itemized list of sandwiches, drinks, and chips
  - Tax & optional tip calculation
  - Payment method (card or cash)
- Saved as a `.txt` file in `/resources/receipts/` with timestamp

---

## 🧠 Object-Oriented Design Highlights

- **Encapsulation:** Logic for toppings, pricing, and menu display is isolated in specific classes.
- **Inheritance:** `SignatureSandwich` extends `Sandwich` for reusable base behavior.
- **Polymorphism:** Sandwiches can be customized dynamically regardless of type.
- **Separation of Concerns:** UI logic, models, and fixed values are organized in separate packages.

---

## 🖼️ Screenshots
 
  - Main Menu

![image](https://github.com/user-attachments/assets/5c78e630-b027-46dc-908a-437baff0451b)

![image](https://github.com/user-attachments/assets/41ad60d7-fd81-462c-b73c-fc5255592467)

 - Sandwich customization

![image](https://github.com/user-attachments/assets/783d47b3-af7b-4020-8176-b9b066432eb2)

- Signature sandwich selection

![image](https://github.com/user-attachments/assets/606ff1e2-d044-4dd4-96da-40aa94caa858)

![image](https://github.com/user-attachments/assets/cb4ed7ff-592d-41b3-bc55-f03f84205e83)

![image](https://github.com/user-attachments/assets/a8ef16b7-1f44-4bf9-bdf4-4b519b3802a1)


- Checkout summary

  ![image](https://github.com/user-attachments/assets/5e9365e4-d219-44d0-9d55-cbbacfd6c4be)
  
  ![image](https://github.com/user-attachments/assets/09255345-667f-4c01-966a-ded09896f67c)


- Receipt sample
  
![image](https://github.com/user-attachments/assets/8d885244-cdc8-4e23-8ff2-8111b133980b)

![image](https://github.com/user-attachments/assets/51fea2f6-3eb7-4a2f-b86e-b806a1236f28)

---

## 🖼️ UML Diagram

![image](https://github.com/user-attachments/assets/730fc7ab-eae9-46ff-9f9d-30a47493704a)

## 📌 Interesting Code Snippet

```java
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

```

## 💡 Why it’s interesting:
This method brings flexibility to the SignatureSandwich class by allowing users to interactively modify predefined sandwiches. It showcases dynamic category editing using polymorphic behavior, efficient input parsing with Java Streams, and user-driven logic branching — all in one place. It makes the app feel personalized, as users can truly own their order with live ingredient modifications.



## 🙋‍♀️ Author

Heldana Gebremariam

Java Developer & System Designer

05/30/2025
