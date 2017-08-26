package feature;

import com.bankaccount.kata.MyBankAccount;
import com.bankaccount.kata.StatementsRepository;
import org.junit.Assert;
import org.junit.Test;

public class WithdrawTest {
    private StatementsRepository statementsRepository;
    MyBankAccount myBankAccount;


    @Test
    public void should_subtract_withdraw_amount_from_the_balance_amount_when() {
        statementsRepository = new StatementsRepository();
        myBankAccount = new MyBankAccount(statementsRepository);

        myBankAccount.withdraw(12);
        Assert.assertEquals(-12, myBankAccount.getBalance());
    }


}
