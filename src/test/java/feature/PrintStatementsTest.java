package feature;

import com.bankaccount.kata.MyBankAccount;
import com.bankaccount.kata.Printer;
import com.bankaccount.kata.StatementsRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

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

}
