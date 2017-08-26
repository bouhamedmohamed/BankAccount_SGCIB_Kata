package com.bankaccount.kata;

import java.util.concurrent.atomic.AtomicInteger;

public class StatementsRepository {
    private AtomicInteger balanceAmount = new AtomicInteger(0);

    public void addDeposit(int amount) {
        System.out.println(amount);
        balanceAmount.addAndGet(amount);
    }

    public int getBalanceAmount() {
        System.out.println(balanceAmount);
        return balanceAmount.get();
    }
}
