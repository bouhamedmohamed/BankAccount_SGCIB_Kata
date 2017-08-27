package feature;

import com.bankaccount.kata.Clock;
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

import java.time.LocalDate;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.inOrder;
@RunWith(MockitoJUnitRunner.class)
public class PrintStatementsFeature {
    @Mock
    private Printer printer;
    @Mock
    private Clock clock;
    private MyBankAccount myBankAccount;

    @Before
    public void setUp() throws Exception {
        StatementsRepository statementsRepository = new StatementsRepository(clock);
        myBankAccount = new MyBankAccount(statementsRepository, printer);
    }

    @Test
    public void should_print_all_transactions_statements() {

        given(clock.getToDayDate()).willReturn(LocalDate.of(2017,5,27),LocalDate.of(2017,8,29),LocalDate.of(2017,8,27));

        myBankAccount.deposit(1000);
        myBankAccount.withdraw(200);
        myBankAccount.withdrawAll();
        myBankAccount.printStatements();


        InOrder inOrder = inOrder(printer);
        inOrder.verify(printer).print("Type || Date || Amount || Balance");
        inOrder.verify(printer).print("DEPOSIT || 2017-05-27 || 1000 || 0");
        inOrder.verify(printer).print("WITHDRAW || 2017-08-29 || -200 || 1000");
        inOrder.verify(printer).print("WITHDRAW || 2017-08-27 || -800 || 800");
    }
}
