package com.angelesco.oop;

import com.angelesco.oop.banking.BankAccount;
import com.angelesco.oop.banking.CheckingAccount;
import com.angelesco.oop.banking.SavingsAccount;
import com.angelesco.oop.library.Book;
import com.angelesco.oop.library.Library;

public final class PortfolioDemo {
    private PortfolioDemo() {
    }

    public static void main(String[] args) {
        Library library = new Library();
        library.add(new Book("Pedro Páramo", "Juan Rulfo"));
        library.add(new Book("El principito", "Antoine de Saint-Exupéry"));
        System.out.println("Library inventory: " + library.inventory());

        BankAccount[] accounts = {
                new BankAccount(100_00),
                new SavingsAccount(100_00, 50_00),
                new CheckingAccount(100_00, 50)
        };
        for (BankAccount account : accounts) {
            account.withdraw(20_00);
            System.out.println(
                    account.getClass().getSimpleName() + ": " + account.balanceCents()
            );
        }
    }
}
