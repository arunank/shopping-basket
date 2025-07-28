# Shopping Basket – Scala Technical Assignment

A command-line Scala application to calculate the total cost of a basket of goods, applying promotional discounts where applicable. This project is a solution to a technical challenge involving pricing logic, discount rules, and test-driven development.

---

## Requirements

- Parse a list of grocery items passed via command line
- Compute subtotal and apply current special offers
- Print all applicable discounts and final total
- Show `(No offers available)` if no discounts apply

---

##  Available Products

| Item   | Price   |
|--------|---------|
| Soup   | £0.65   |
| Bread  | £0.80   |
| Milk   | £1.30   |
| Apples | £1.00   |

---

##  Special Offers

- **Apples** – 10% off
- **Bread** – 50% off **per 2 tins of Soup purchased**  
  _(e.g., buy 4 Soups, get 2 Breads at half price)_

---

## Tech Stack

- **Scala 2.13**
- **sbt** (Scala Build Tool)
- **ScalaTest** for unit testing

---

## Getting Started

### 1. Clone the repo

```
git clone https://github.com/arunank/shopping-basket.git
cd shopping-basket
```

### 2. Compile, Test and Run
```
sbt clean compile test

sbt "run Apples Milk Bread"

sbt "run Milk Bread"

sbt "run Apples Milk Bread Soup Soup Orange"
```