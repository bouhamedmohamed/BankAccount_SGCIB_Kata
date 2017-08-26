package com.bankaccount.kata;

public class MyBankAccount {
    private final StatementsRepository statementsRepository;
    private final Printer printer;
    private static int POSTIF_AMOUNT = 0;


    public MyBankAccount(StatementsRepository statementsRepository, Printer printer) {

        this.statementsRepository = statementsRepository;
        this.printer = printer;
    }

    public void deposit(int amount) {
        if (isPositiveAmount(amount))
            statementsRepository.addDeposit(amount);
    }

    public void withdraw(int amount) {
        if (isPositiveAmount(amount))
            statementsRepository.addWithdraw(amount);
    }

    public void withdrawAll() {
        statementsRepository.addWithdraw(getBalance());
    }

    public void printStatements() {
       printer.print(statementsRepository.getStatements());
    }

    public int getBalance() {
        return this.statementsRepository.getBalanceAmount();
    }

    private boolean isPositiveAmount(int amount) {
        return amount > POSTIF_AMOUNT;
    }
}
