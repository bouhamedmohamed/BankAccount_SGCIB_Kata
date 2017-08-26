package feature;

import com.bankaccount.kata.MyBankAccount;
import com.bankaccount.kata.StatementsRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DepositTest {
    @Mock
    private StatementsRepository statementsRepository;


    @Test
    public void should_deposit_amount_equal_to_balance_amount_when_first_deposit() {
        MyBankAccount myBankAccount=new MyBankAccount(statementsRepository);
        myBankAccount.deposit(12);
        Assert.assertEquals(12, myBankAccount.getBalance());
    }
}
