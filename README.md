# Java OOP Fundamentals

Two object-oriented programming exercises organized as one Java 17 project: a library catalog and a bank-account hierarchy.

The project demonstrates encapsulation, composition, inheritance, method overriding, polymorphism, immutable objects, and explicit error handling.

## Design

### Library

- `Book` is an immutable value object.
- `Library` encapsulates its internal map.
- Duplicate titles are rejected.
- Callers receive immutable views of the collection.

### Bank accounts

- `BankAccount` owns the balance invariants.
- `SavingsAccount` limits withdrawal amounts.
- `CheckingAccount` applies a fee.
- Monetary values are stored in cents to avoid floating-point errors.

## Compile and test

```powershell
.\run-tests.ps1
```

## Run the demonstration

```powershell
java -cp build\classes com.angelesco.oop.PortfolioDemo
```
