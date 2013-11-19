package kauedb.spring.examples.repository;

import kauedb.spring.examples.entity.Costumer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: kauedb
 * Date: 11/15/13
 * Time: 6:20 PM
 */
@Transactional(readOnly = true)
public interface CostumerRepository extends JpaRepository<Costumer, Long>, QueryDslPredicateExecutor<Costumer>{

    /**
     * findBy is standard syntax
     * <p/>
     * LastName postfix must be identical to Costumers.lastName property
     * <p>
     * Correct:     findByLastName
     * Incorrect:   findByLastname
     * </p>
     *
     * @param lastName
     * @return
     */
    List<Costumer> findByLastName(String lastName);

    /**
     * findBy is standard syntax
     * <p/>
     * LastName postfix must be identical to Costumers.lastName property
     * <p>
     * Correct:     findByLastName
     * Incorrect:   findByLastname
     * </p>
     *
     * @param lastName
     * @return
     */
    List<Costumer> findByLastName(String lastName, Sort sort);

    /**
     * findBy is standard syntax
     * <p/>
     * LastName postfix must be identical to Costumers.lastName property
     * <p>
     * Correct:     findByLastName
     * Incorrect:   findByLastname
     * </p>
     *
     * @param lastName
     * @return
     */
    Page<Costumer> findByLastName(String lastName, Pageable pageable);




}
