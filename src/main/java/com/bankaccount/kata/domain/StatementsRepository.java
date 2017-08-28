package com.bankaccount.kata.domain;

import com.bankaccount.kata.Clock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StatementsRepository {
    private List<BankAccountStatement> bankAccountStatements = new ArrayList<>();
    private Clock clock;

    public StatementsRepository(Clock clock) {

        this.clock = clock;
    }

    public void addDeposit(int amount) {
        bankAccountStatements.add(createNewBankAccountStatement(amount, TypeStatement.DEPOSIT));
    }

    public int getBalanceAmount() {
        return getBankAccountStatements().stream().mapToInt(statement -> statement.getAmountStatement()).sum();
    }

    public void addWithdraw(int amount) {
        bankAccountStatements.add(createNewBankAccountStatement(-amount, TypeStatement.WITHDRAW));
    }

    public List<BankAccountStatement> getBankAccountStatements() {
        return Collections.unmodifiableList(bankAccountStatements);
    }

    private BankAccountStatement createNewBankAccountStatement(int amountStatement, TypeStatement typeStatement) {
        return BankAccountStatement.BankAccountStatementBuilder.aBankAccountStatement()
                .withAmountStatement(amountStatement)
                .withDateStatement(clock.getToDayDate())
                .withTypeStatement(typeStatement)
                .build();
    }
}
