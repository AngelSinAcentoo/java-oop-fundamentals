package com.angelesco.oop.banking;

/** Checking account that applies a fixed withdrawal fee. */
public final class CheckingAccount extends BankAccount {
    private final long withdrawalFeeCents;

    public CheckingAccount(long openingBalanceCents, long withdrawalFeeCents) {
        super(openingBalanceCents);
        if (withdrawalFeeCents < 0) {
            throw new IllegalArgumentException("fee cannot be negative");
        }
        this.withdrawalFeeCents = withdrawalFeeCents;
    }

    @Override
    public void withdraw(long amountCents) {
        requirePositive(amountCents);
        debit(Math.addExact(amountCents, withdrawalFeeCents));
    }
}
