package kauedb.spring.examples.repository;

import kauedb.spring.examples.entity.Account;
import kauedb.spring.examples.entity.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: kauedb
 * Date: 11/16/13
 * Time: 8:59 AM
 */
@Transactional(readOnly = true)
public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findByCostumer(Costumer costumer);


}
