package feature;

import com.bankaccount.kata.Printer;
import com.bankaccount.kata.domain.MyBankAccount;
import com.bankaccount.kata.domain.StatementsRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MyBankAccountTest {

    private MyBankAccount myBankAccount;
    @Mock
    private StatementsRepository statementsRepository;
    @Mock
    private Printer printer;

    @Before
    public void setUp() throws Exception {
        myBankAccount = new MyBankAccount(statementsRepository, printer);
    }

    @Test
    public void should_store_deposit_statement() {
        myBankAccount.depositAmount(100);
        verify(statementsRepository).addDeposit(100);
    }

    @Test
    public void should_store_withdraw_statement() {
        myBankAccount.withdrawAmount(100);
        verify(statementsRepository).addWithdraw(100);
    }

    @Test
    public void should_print_all_statements() {
        given(statementsRepository.getBalanceAmount()).willReturn(8);
        myBankAccount.depositAmount(12);
        myBankAccount.withdrawAmount(4);
        myBankAccount.withdrawAllAmount();
        myBankAccount.printAllMyBankAccountStatements();
        verify(statementsRepository).getBankAccountStatements();
    }
}
