# 🥪 Crave Cave Sandwich Shop 🥪

                   Bold Bites. Fresh Ingredients. Endless Customization.  
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

05/30/2025
