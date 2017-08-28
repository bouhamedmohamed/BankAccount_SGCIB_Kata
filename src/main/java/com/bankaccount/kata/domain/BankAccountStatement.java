package com.bankaccount.kata.domain;

import java.time.LocalDate;

public class BankAccountStatement {
    private final TypeStatement typeStatement;
    private final LocalDate dateStatement;
    private final int amountStatement;

    private BankAccountStatement(TypeStatement typeStatement, LocalDate dateStatement, int amountStatement) {
        this.typeStatement = typeStatement;
        this.dateStatement = dateStatement;
        this.amountStatement = amountStatement;
    }

    @Override
    public String toString() {
        return typeStatement + " || " + dateStatement + " || " + amountStatement;
    }

    public TypeStatement getTypeStatement() {
        return typeStatement;
    }

    public LocalDate getDateStatement() {
        return dateStatement;
    }

    public int getAmountStatement() {
        return amountStatement;
    }

    public static final class BankAccountStatementBuilder {
        private TypeStatement typeStatement;
        private LocalDate dateStatement;
        private int amountStatement;

        private BankAccountStatementBuilder() {
        }

        public static BankAccountStatementBuilder aBankAccountStatement() {
            return new BankAccountStatementBuilder();
        }

        public BankAccountStatementBuilder withTypeStatement(TypeStatement typeStatement) {
            this.typeStatement = typeStatement;
            return this;
        }

        public BankAccountStatementBuilder withDateStatement(LocalDate dateStatement) {
            this.dateStatement = dateStatement;
            return this;
        }

        public BankAccountStatementBuilder withAmountStatement(int amountStatement) {
            this.amountStatement = amountStatement;
            return this;
        }

        public BankAccountStatement build() {
            BankAccountStatement bankAccountStatement = new BankAccountStatement(typeStatement, dateStatement, amountStatement);
            return bankAccountStatement;
        }
    }
}
