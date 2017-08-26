package com.bankaccount.kata;

import java.util.concurrent.atomic.AtomicInteger;

public class StatementsRepository {
    private AtomicInteger balanceAmount = new AtomicInteger(0);

    public void addDeposit(int amount) {
        balanceAmount.addAndGet(amount);
    }

    public int getBalanceAmount() {
        return balanceAmount.get();
    }

    public void addWithdraw(int amount) {
        throw new UnsupportedOperationException();
    }
}
