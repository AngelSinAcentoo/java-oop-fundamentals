package com.angelesco.oop;

import com.angelesco.oop.banking.BankAccount;
import com.angelesco.oop.banking.CheckingAccount;
import com.angelesco.oop.banking.SavingsAccount;
import com.angelesco.oop.library.Book;
import com.angelesco.oop.library.Library;

public final class OopTest {
    private OopTest() {
    }

    public static void main(String[] args) {
        testLibrary();
        testPolymorphicWithdrawals();
        testValidation();
        System.out.println("OOP tests passed.");
    }

    private static void testLibrary() {
        Library library = new Library();
        Book book = new Book("Pedro Páramo", "Juan Rulfo");
        library.add(book);
        assert library.findByTitle("  PEDRO PÁRAMO ").orElseThrow().equals(book);
        assert library.inventory().size() == 1;
        expectFailure(() -> library.add(new Book("Pedro Páramo", "Another Author")));
        assert library.removeByTitle("pedro páramo");
        assert library.inventory().isEmpty();
    }

    private static void testPolymorphicWithdrawals() {
        BankAccount standard = new BankAccount(10_000);
        BankAccount savings = new SavingsAccount(10_000, 5_000);
        BankAccount checking = new CheckingAccount(10_000, 50);

        standard.withdraw(2_000);
        savings.withdraw(2_000);
        checking.withdraw(2_000);

        assert standard.balanceCents() == 8_000;
        assert savings.balanceCents() == 8_000;
        assert checking.balanceCents() == 7_950;
        expectFailure(() -> savings.withdraw(6_000));
    }

    private static void testValidation() {
        expectFailure(() -> new BankAccount(-1));
        BankAccount account = new BankAccount(100);
        expectFailure(() -> account.deposit(0));
        expectFailure(() -> account.withdraw(101));
    }

    private static void expectFailure(Runnable operation) {
        try {
            operation.run();
            throw new AssertionError("Expected IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            // Expected validation failure.
        }
    }
}
