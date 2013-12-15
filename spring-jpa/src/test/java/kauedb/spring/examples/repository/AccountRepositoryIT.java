package kauedb.spring.examples.repository;

import kauedb.spring.examples.entity.Account;
import kauedb.spring.examples.entity.Costumer;
import kauedb.spring.examples.itest.BaseIT;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.util.MatcherAssertionErrors.assertThat;

/**
 * User: kauedb
 * Date: 11/16/13
 * Time: 8:52 AM
 */
public class AccountRepositoryIT extends BaseIT {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CostumerRepository costumerRepository;

    @Test
    public void test() {
        final Costumer costumer = costumerRepository.findOne(1L);

        final List<Account> account = accountRepository.findByCostumer(costumer);
        assertThat(account.isEmpty(), is(false));
        assertThat(account.get(0).getId(), is(1L));
    }

}
