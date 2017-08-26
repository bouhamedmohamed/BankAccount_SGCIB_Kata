package feature;

import com.bankaccount.kata.MyBankAccount;
import com.bankaccount.kata.StatementsRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WithdrawTest {
    private StatementsRepository statementsRepository;
    MyBankAccount myBankAccount;

    @Before
    public void setUp() throws Exception {
        statementsRepository = new StatementsRepository();
        myBankAccount = new MyBankAccount(statementsRepository);
    }

    @Test
    public void should_subtract_withdraw_amount_from_the_balance_amount_when() {
        myBankAccount.withdraw(12);
        Assert.assertEquals(-12, myBankAccount.getBalance());
    }

    @Test
    public void should_not_accept_negative_amount_when_we_withdraw() {
        myBankAccount.withdraw(-12);
        Assert.assertEquals(0, myBankAccount.getBalance());
    }


}
