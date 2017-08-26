package feature;

import com.bankaccount.kata.MyBankAccount;
import com.bankaccount.kata.StatementsRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DepositTest {
    private StatementsRepository statementsRepository;
    MyBankAccount myBankAccount;

    @Before
    public void setUp() throws Exception {
        statementsRepository = new StatementsRepository();
        myBankAccount = new MyBankAccount(statementsRepository);
    }

    @Test
    public void should_deposit_amount_is_equal_to_balance_amount_when_first_deposit() {

        myBankAccount.deposit(12);
        Assert.assertEquals(12, myBankAccount.getBalance());
    }

    @Test
    public void should_balance_amount_is_sum_of_all_deposit_amount_when_many_deposit() {

        myBankAccount.deposit(12);
        myBankAccount.deposit(12);
        Assert.assertEquals(24, myBankAccount.getBalance());
    }
    @Test
    public void should_not_accept_negative_amount_when_deposit() {

        myBankAccount.deposit(-12);
        Assert.assertEquals(0, myBankAccount.getBalance());
    }
}
