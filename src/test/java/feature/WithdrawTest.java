package feature;

import com.bankaccount.kata.Clock;
import com.bankaccount.kata.domain.MyBankAccount;
import com.bankaccount.kata.Printer;
import com.bankaccount.kata.domain.StatementsRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class WithdrawTest {
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
    public void should_subtract_withdraw_amount_from_the_balance_amount_when() {
        myBankAccount.withdrawAmount(12);
        Assert.assertEquals(-12, myBankAccount.getMyBankAccountBalance());
    }

    @Test
    public void should_not_accept_negative_amount_when_we_withdraw() {
        myBankAccount.withdrawAmount(-12);
        Assert.assertEquals(0, myBankAccount.getMyBankAccountBalance());
    }

    @Test
    public void should_withdraw_all_the_balance_amount_when_we_make_a_withdrawALL() {
        myBankAccount.depositAmount(12);
        myBankAccount.withdrawAllAmount();
        Assert.assertEquals(0, myBankAccount.getMyBankAccountBalance());
    }


}
