# 🥪 Crave Cave Sandwich Shop

**Bold Bites. Fresh Ingredients. Endless Customization.**  
DELI-cious is a command-line Java application designed to simulate a point-of-sale (POS) system for a growing custom sandwich shop. This project was developed using Object-Oriented Programming (OOP) principles and supports dynamic sandwich building, drinks, chips, and receipt generation — all through a smooth CLI experience.

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

> 💡 _Insert CLI screenshots here_  
> Suggested shots:
> - Main Menu
> - Sandwich customization
> - Signature sandwich selection
> - Checkout summary
> - Receipt sample

---

## 📌 Interesting Code Snippet

```java
public double getPrice(int size, boolean isMeat) {
    double basePrice = isMeat ? FixedValues.MEAT_PRICES.get(size) : FixedValues.CHEESE_PRICES.get(size);
    if (isExtra) {
        basePrice += isMeat ? FixedValues.EXTRA_MEAT.get(size) : FixedValues.EXTRA_CHEESE.get(size);
    }
    return basePrice;
}
```
## 🙋‍♀️ Author

Heldana Gebremariam

Java Developer & System Designer

05/23/2025
