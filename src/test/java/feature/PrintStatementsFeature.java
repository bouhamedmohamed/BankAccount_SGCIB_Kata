package feature;

import com.bankaccount.kata.MybankAccount;
import com.bankaccount.kata.Printer;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;


import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

public class PrintStatementsFeature {
    private Printer printer;
    private MybankAccount myBankAccount;

    @Before
    public void setUp() throws Exception {
        printer=new Printer();
        myBankAccount=new MybankAccount();
    }

    @Test
    public void should_print_all_transactions_statements() {


        myBankAccount.deposit(1000);
        myBankAccount.withdraw(200);
        myBankAccount.withdrawAll();
        myBankAccount.printStatements();

        InOrder inOrder= inOrder(printer);
        inOrder.verify(printer).print("Type || Date || Amount || Balance");
        inOrder.verify(printer).print("Deposit  || 27/08/2017 || 1000 || 0");
        inOrder.verify(printer).print("Withdraw || 27/08/2017 || 200 || 1000");
        inOrder.verify(printer).print("Withdraw || 27/08/2017 || 800 || 800");
    }
}
