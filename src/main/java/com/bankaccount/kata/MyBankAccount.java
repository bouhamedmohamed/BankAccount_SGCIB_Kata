package com.bankaccount.kata;

public class MyBankAccount {
    private final StatementsRepository statementsRepository;
    private static int POSTIF_AMOUNT =0;


    public MyBankAccount(StatementsRepository statementsRepository) {

        this.statementsRepository = statementsRepository;
    }

    public void deposit(int amount) {
        if(isPositiveAmount(amount))
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
        return this.statementsRepository.getBalanceAmount();
    }

    private boolean isPositiveAmount(int amount) {
        return amount> POSTIF_AMOUNT;
    }
}
