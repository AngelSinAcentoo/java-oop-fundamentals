package com.angelesco.oop.banking;

/** Base account that stores money as integer cents. */
public class BankAccount {
    private long balanceCents;

    public BankAccount(long openingBalanceCents) {
        if (openingBalanceCents < 0) {
            throw new IllegalArgumentException("opening balance cannot be negative");
        }
        balanceCents = openingBalanceCents;
    }

    public final long balanceCents() {
        return balanceCents;
    }

    public final void deposit(long amountCents) {
        requirePositive(amountCents);
        balanceCents = Math.addExact(balanceCents, amountCents);
    }

    public void withdraw(long amountCents) {
        requirePositive(amountCents);
        debit(amountCents);
    }

    protected final void debit(long amountCents) {
        if (amountCents > balanceCents) {
            throw new IllegalArgumentException("insufficient funds");
        }
        balanceCents -= amountCents;
    }

    protected static void requirePositive(long amountCents) {
        if (amountCents <= 0) {
            throw new IllegalArgumentException("amount must be positive");
        }
    }
}
