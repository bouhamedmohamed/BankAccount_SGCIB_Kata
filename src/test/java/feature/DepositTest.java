package feature;

import com.bankaccount.kata.Clock;
import com.bankaccount.kata.Printer;
import com.bankaccount.kata.domain.MyBankAccount;
import com.bankaccount.kata.domain.StatementsRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DepositTest {
    private StatementsRepository statementsRepository;
    MyBankAccount myBankAccount;
    @Mock
    private Printer printer;
    @Mock
    private Clock clock;

    @Before
    public void setUp() throws Exception {
        statementsRepository = new StatementsRepository(clock);
        myBankAccount = new MyBankAccount(statementsRepository, printer);
    }

    @Test
    public void should_deposit_amount_is_equal_to_balance_amount_when_first_deposit() {

        myBankAccount.depositAmount(12);
        Assert.assertEquals(12, myBankAccount.getMyBankAccountBalance());
    }

    @Test
    public void should_balance_amount_is_sum_of_all_deposit_amount_when_many_deposit() {

        myBankAccount.depositAmount(12);
        myBankAccount.depositAmount(12);
        Assert.assertEquals(24, myBankAccount.getMyBankAccountBalance());
    }

    @Test(expected = RuntimeException.class)
    public void should_not_accept_negative_amount_when_deposit() {
        myBankAccount.depositAmount(-12);
    }
}
