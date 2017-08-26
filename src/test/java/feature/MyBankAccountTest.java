package feature;

import com.bankaccount.kata.MyBankAccount;
import com.bankaccount.kata.Printer;
import com.bankaccount.kata.StatementsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MyBankAccountTest {
    private MyBankAccount myBankAccount;
    @Mock
    private StatementsRepository statementsRepository;
    @Mock
    private Printer printer;


    @Test
    public void should_store_deposit_statement() {
        myBankAccount = new MyBankAccount(statementsRepository, printer);
        myBankAccount.deposit(100);
        verify(statementsRepository).addDeposit(100);
    }

    @Test
    public void should_store_withdraw_statement() {
        myBankAccount = new MyBankAccount(statementsRepository, printer);
        myBankAccount.withdraw(100);
        verify(statementsRepository).addWithdraw(100);
    }

    @Test
    public void should_print_all_statements() {
        myBankAccount = new MyBankAccount(statementsRepository, printer);
        myBankAccount.deposit(12);
        myBankAccount.withdraw(4);
        myBankAccount.withdrawAll();
        myBankAccount.printStatements();
        verify(statementsRepository).getStatements();
    }
}
