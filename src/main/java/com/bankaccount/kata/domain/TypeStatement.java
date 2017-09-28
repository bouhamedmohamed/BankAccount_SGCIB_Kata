package com.bankaccount.kata.domain;

public enum TypeStatement {
    WITHDRAW {
        @Override
        public int amount(int amount) {
            return -amount;
        }
    }, DEPOSIT {
        @Override
        public int amount(int amount) {
            return amount;
        }
    };

    abstract public int amount(int amount);


}
