package feature;

import com.bankaccount.kata.MyBankAccount;
import com.bankaccount.kata.Printer;
import com.bankaccount.kata.StatementsRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PrintStatementsTest {

    private StatementsRepository statementsRepository;
    private MyBankAccount myBankAccount;
    @Mock
    private Printer printer;

    @Before
    public void setUp() throws Exception {
        statementsRepository = new StatementsRepository();
        myBankAccount = new MyBankAccount(statementsRepository, printer);

    }

    @Test
    public void should_print_no_statements_when_no_statements_have_been_done() {
        myBankAccount.printStatements();
        verify(printer).print("No statements");
    }

    @Test
    public void should_print_one_deposit_statement_when_just_one_deposit_statement_has_been_done() {
        myBankAccount.deposit(10);
        myBankAccount.printStatements();
        InOrder inOrder = inOrder(printer);
        inOrder.verify(printer).print("Type || Date || Amount || Balance");
        inOrder.verify(printer).print("DEPOSIT || 2017-08-26 || 10 || 0");
    }

}