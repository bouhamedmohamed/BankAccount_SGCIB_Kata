package com.bankaccount.kata.domain;

import com.bankaccount.kata.Printer;

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

    public void depositAmount(int amount) {
        if (isStrictlyPositiveAmount(amount))
            statementsRepository.addDeposit(amount);
    }

    public void withdrawAmount(int amount) {
        if (isStrictlyPositiveAmount(amount))
            statementsRepository.addWithdraw(amount);
    }

    public void withdrawAllAmount() {
        statementsRepository.addWithdraw(getMyBankAccountBalance());
    }

    public void printAllMyBankAccountStatements() {
        balance.set(0);
        final String header = "Type || Date || Amount || Balance";
        if (statementsRepository.getBankAccountStatements().isEmpty())
            printer.print("No statements");
        else {
            printer.print(header);

            statementsRepository.getBankAccountStatements()
                    .stream()
                    .map(getBankAccountStatementTransaction())
                    .forEach(statement -> printer.print(statement));
        }


    }

    private Function<BankAccountStatement, String> getBankAccountStatementTransaction() {

        return statement -> statement.toString().concat(" || " + balance.getAndAdd(statement.getAmountStatement()));
    }

    public int getMyBankAccountBalance() {
        return this.statementsRepository.getBalanceAmount();
    }

    private boolean isStrictlyPositiveAmount(int amount) {
        return amount > ZERO_AMOUNT;
    }
}
