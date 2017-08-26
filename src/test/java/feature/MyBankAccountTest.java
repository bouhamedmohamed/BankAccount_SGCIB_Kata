package feature;

import com.bankaccount.kata.MyBankAccount;
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


    @Test
    public void should_store_deposit_statement() {
        myBankAccount = new MyBankAccount(statementsRepository);
        myBankAccount.deposit(100);
        verify(statementsRepository).addDeposit(100);
    }
}
