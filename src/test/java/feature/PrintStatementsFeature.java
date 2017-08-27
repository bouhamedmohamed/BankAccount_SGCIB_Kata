package feature;

import com.bankaccount.kata.MyBankAccount;
import com.bankaccount.kata.Printer;
import com.bankaccount.kata.StatementsRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.inOrder;
@RunWith(MockitoJUnitRunner.class)
public class PrintStatementsFeature {
    @Mock
    private Printer printer;
    private MyBankAccount myBankAccount;

    @Before
    public void setUp() throws Exception {
        StatementsRepository statementsRepository = new StatementsRepository();
        myBankAccount = new MyBankAccount(statementsRepository, printer);
    }

    @Test
    public void should_print_all_transactions_statements() {


        myBankAccount.deposit(1000);
        myBankAccount.withdraw(200);
        myBankAccount.withdrawAll();
        myBankAccount.printStatements();

        InOrder inOrder = inOrder(printer);
        inOrder.verify(printer).print("Type || Date || Amount || Balance");
        inOrder.verify(printer).print("DEPOSIT || 2017-08-27 || 1000 || 0");
        inOrder.verify(printer).print("WITHDRAW || 2017-08-27 || -200 || 1000");
        inOrder.verify(printer).print("WITHDRAW || 2017-08-27 || -800 || 800");
    }
}
