# Java OOP Fundamentals

Dos ejercicios de Programación Orientada a Objetos reorganizados como un solo
proyecto Java 17: un catálogo de biblioteca y una jerarquía de cuentas
bancarias.

> **English summary:** A tested Java 17 project demonstrating encapsulation,
> composition, inheritance, method overriding and polymorphism.

## Diseño

### Biblioteca

- `Book` es un objeto de valor inmutable.
- `Library` encapsula el mapa interno.
- Se rechazan títulos duplicados y se devuelven vistas inmutables.

### Cuentas bancarias

- `BankAccount` concentra las invariantes del saldo.
- `SavingsAccount` limita el monto de retiro.
- `CheckingAccount` aplica una comisión.
- Los montos se almacenan en centavos para evitar errores de punto flotante.

## Compilar y probar

```powershell
.\run-tests.ps1
```

## Ejecutar la demostración

```powershell
java -cp build\classes com.angelesco.oop.PortfolioDemo
```

## Conceptos demostrados

- encapsulación y validación;
- composición;
- herencia y sobrescritura;
- despacho polimórfico;
- objetos inmutables;
- manejo explícito de errores.
