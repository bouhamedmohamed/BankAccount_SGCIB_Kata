package com.bankaccount.kata;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

public class MyBankAccount {
    private final StatementsRepository statementsRepository;
    private final Printer printer;
    private static int ZERO_AMOUNT = 0;
    private AtomicInteger balance = new AtomicInteger(0);


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
        final String header = "Type || Date || Amount || Balance";
        if (statementsRepository.getStatements().isEmpty())
            printer.print("No statements");
        else {
            printer.print(header);

            statementsRepository.getStatements()
                    .stream()
                    .map(getBankAccountStatementTransaction())
                    .forEach(statement -> printer.print(statement));
        }


    }

    private Function<BankAccountStatement, String> getBankAccountStatementTransaction() {

        return statement -> statement.toString().concat(" || " + balance.getAndAdd(statement.getAmountStatement()));
    }

    public int getBalance() {
        return this.statementsRepository.getBalanceAmount();
    }

    private boolean isPositiveAmount(int amount) {
        return amount > ZERO_AMOUNT;
    }
}
