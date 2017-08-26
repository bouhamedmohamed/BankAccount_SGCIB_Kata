package com.bankaccount.kata;

public class MyBankAccount {
    private final StatementsRepository statementsRepository;

    public MyBankAccount(StatementsRepository statementsRepository) {

        this.statementsRepository = statementsRepository;
    }

    public void deposit(int amount) {
        statementsRepository.addDeposit(amount);
    }

    public void withdraw(int amount) {
        throw new UnsupportedOperationException();
    }

    public void withdrawAll() {
        throw new UnsupportedOperationException();
    }

    public void printStatements() {
        throw new UnsupportedOperationException();
    }

    public int getBalance() {
        return 12;
    }
}
