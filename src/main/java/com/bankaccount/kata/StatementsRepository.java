package com.bankaccount.kata;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class StatementsRepository {
    private AtomicInteger balanceAmount = new AtomicInteger(0);
    private List<BankAccountStatement> bankAccountStatements = new ArrayList<>();

    public void addDeposit(int amount) {
        bankAccountStatements.add(createNewStatement(amount, TypeStatement.DEPOSIT));
    }

    public int getBalanceAmount() {
        return getStatements().stream().mapToInt(statement->statement.getAmountStatement()).sum();
    }

    public void addWithdraw(int amount) {
        bankAccountStatements.add(createNewStatement(-amount,TypeStatement.WITHDRAW));
    }

    public List<BankAccountStatement> getStatements() {
        return Collections.unmodifiableList(bankAccountStatements);
    }

    private BankAccountStatement createNewStatement(int amountStatement, TypeStatement typeStatement) {
        return BankAccountStatement.BankAccountStatementBuilder.aBankAccountStatement()
                .withAmountStatement(amountStatement)
                .withDateStatement(LocalDate.now())
                .withTypeStatement(typeStatement)
                .build();
    }
}
