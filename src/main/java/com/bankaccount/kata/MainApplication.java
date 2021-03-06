package com.bankaccount.kata;

import com.bankaccount.kata.domain.MyBankAccount;
import com.bankaccount.kata.domain.StatementsRepository;

import java.util.Scanner;

class MainApplication {

    private static MyBankAccount myBankAccount;
    private static Printer printer;


    public static void main(String[] args) throws Exception {
        bankAccountInit();
        animator();
    }

    private static void animator() throws Exception {
        MenuToShow();
        Scanner scan = new Scanner(System.in);
        int choiceNumber = scan.nextInt();
        callTheSuitableService(choiceNumber);
    }

    private static void bankAccountInit() {
        Clock clock = new Clock();
        printer = new Printer();
        StatementsRepository statementsRepository = new StatementsRepository(clock);
        myBankAccount = new MyBankAccount(statementsRepository, printer);

    }

    private static void callTheSuitableService(int choiseNumber) throws Exception {
        switch (choiseNumber) {
            case 1:
                deposit();
                break;

            case 2:
                withdraw();
                break;
            case 3:
                withdrawAll();
                break;
            case 4:
                displayAll();
                break;
            default:
                System.exit(1);
                break;
        }
    }


    private static void withdrawAll() throws Exception {
        printer.print("All withdraw Service");
        try {
            myBankAccount.withdrawAllAmount();
        } catch (RuntimeException e) {
            System.err.println("Exception: " + e.getMessage());
        }

        animator();
    }

    private static void displayAll() throws Exception {
        printer.print("All Your BankAccount statements ");
        myBankAccount.printAllMyBankAccountStatements();


        printer.print("Your balance(" + myBankAccount.getMyBankAccountBalance() + ")");
        animator();
    }

    private static void withdraw() throws Exception {
        printer.print("withdraw Service");
        printer.print("input the amount to withdraw");
        Scanner scan = new Scanner(System.in);
        int amountToWithdraw = scan.nextInt();
        try {
            myBankAccount.withdrawAmount(amountToWithdraw);
        } catch (RuntimeException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        animator();
    }

    private static void deposit() throws Exception {
        printer.print("Deposit Service");
        printer.print("input the amount to deposit");
        Scanner scan = new Scanner(System.in);
        int amountToDeposit = scan.nextInt();

        try {
            myBankAccount.depositAmount(amountToDeposit);
        } catch (RuntimeException e) {
            System.err.println("Exception: " + e.getMessage());
        }

        animator();
    }

    private static void MenuToShow() {

        printer.print("*************************************************************");
        printer.print("welcome SGCIB BankAccount Management input");
        printer.print("*************************************************************");
        printer.print("(1) to Deposit An amount in your Account ");
        printer.print("(2) to withdraw An amount from your Account ");
        printer.print("(3) to Withrawal all the current amount in your Balance ");
        printer.print("(4) to dispaly all the statements ");
        printer.print("                                             (0) to Exit ");
        printer.print("*************************************************************");
        printer.print("");

    }
}



