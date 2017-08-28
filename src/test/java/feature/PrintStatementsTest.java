package feature;

import com.bankaccount.kata.Clock;
import com.bankaccount.kata.domain.MyBankAccount;
import com.bankaccount.kata.Printer;
import com.bankaccount.kata.domain.StatementsRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PrintStatementsTest {

    private StatementsRepository statementsRepository;
    private MyBankAccount myBankAccount;
    @Mock
    private Printer printer;
    @Mock
    private Clock clock;

    @Before
    public void setUp() throws Exception {

        statementsRepository = new StatementsRepository(clock);
        myBankAccount = new MyBankAccount(statementsRepository, printer);
        given(clock.getToDayDate()).willReturn(LocalDate.of(2017, 8, 27));

    }

    @Test
    public void should_print_no_statements_when_no_statements_have_been_done() {
        myBankAccount.printAllMyBankAccountStatements();
        verify(printer).print("No statements");
    }

    @Test
    public void should_print_one_deposit_statement_when_just_one_deposit_statement_has_been_done() {
        myBankAccount.depositAmount(10);
        myBankAccount.printAllMyBankAccountStatements();
        InOrder inOrder = inOrder(printer);
        inOrder.verify(printer).print("Type || Date || Amount || Balance");
        inOrder.verify(printer).print("DEPOSIT || 2017-08-27 || 10 || 0");
    }

    @Test
    public void should_print_one_withdraw_statement_when_just_one_withdraw_statement_has_been_done() {
        myBankAccount.withdrawAmount(10);
        myBankAccount.printAllMyBankAccountStatements();
        InOrder inOrder = inOrder(printer);
        inOrder.verify(printer).print("Type || Date || Amount || Balance");
        inOrder.verify(printer).print("WITHDRAW || 2017-08-27 || -10 || 0");
    }

    @Test
    public void should_print_one_withdraw_statement_when_just_one_withdraw_all_statement_has_been_done() {
        myBankAccount.withdrawAllAmount();
        myBankAccount.printAllMyBankAccountStatements();
        InOrder inOrder = inOrder(printer);
        inOrder.verify(printer).print("Type || Date || Amount || Balance");
        inOrder.verify(printer).print("WITHDRAW || 2017-08-27 || 0 || 0");
    }

    @Test
    public void should_print_all_the_different_statements_when_many_statements_have_been_done() {
        myBankAccount.depositAmount(100);
        myBankAccount.withdrawAmount(20);
        myBankAccount.withdrawAllAmount();
        myBankAccount.printAllMyBankAccountStatements();
        InOrder inOrder = inOrder(printer);
        inOrder.verify(printer).print("Type || Date || Amount || Balance");
        inOrder.verify(printer).print("DEPOSIT || 2017-08-27 || 100 || 0");
        inOrder.verify(printer).print("WITHDRAW || 2017-08-27 || -20 || 100");
        inOrder.verify(printer).print("WITHDRAW || 2017-08-27 || -80 || 80");
    }

}