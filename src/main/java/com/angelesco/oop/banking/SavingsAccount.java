package com.angelesco.oop.banking;

/** Savings account with a configurable per-operation withdrawal limit. */
public final class SavingsAccount extends BankAccount {
    private final long withdrawalLimitCents;

    public SavingsAccount(long openingBalanceCents, long withdrawalLimitCents) {
        super(openingBalanceCents);
        requirePositive(withdrawalLimitCents);
        this.withdrawalLimitCents = withdrawalLimitCents;
    }

    @Override
    public void withdraw(long amountCents) {
        requirePositive(amountCents);
        if (amountCents > withdrawalLimitCents) {
            throw new IllegalArgumentException("withdrawal exceeds the savings limit");
        }
        super.withdraw(amountCents);
    }
}
