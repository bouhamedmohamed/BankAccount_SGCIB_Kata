package com.bankaccount.kata;

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
        bankAccountStatements.add(createNewStatement(amount, TypeStatement.DEPOSIT));
    }

    public int getBalanceAmount() {
        return getStatements().stream().mapToInt(statement -> statement.getAmountStatement()).sum();
    }

    public void addWithdraw(int amount) {
        bankAccountStatements.add(createNewStatement(-amount, TypeStatement.WITHDRAW));
    }

    public List<BankAccountStatement> getStatements() {
        return Collections.unmodifiableList(bankAccountStatements);
    }

    private BankAccountStatement createNewStatement(int amountStatement, TypeStatement typeStatement) {
        return BankAccountStatement.BankAccountStatementBuilder.aBankAccountStatement()
                .withAmountStatement(amountStatement)
                .withDateStatement(clock.getToDayDate())
                .withTypeStatement(typeStatement)
                .build();
    }
}
