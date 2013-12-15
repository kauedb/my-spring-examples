package kauedb.spring.examples.service;

import kauedb.spring.examples.entity.Costumer;
import kauedb.spring.examples.repository.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: kauedb
 * Date: 11/15/13
 * Time: 7:32 PM
 */
@Repository
@Transactional(readOnly = true)
public class CostumerServiceImpl implements CustomerService {


    @Autowired
    private CostumerRepository costumerRepository;


    private List<Costumer> findAllByLastName(String lastName) {
        return costumerRepository.findByLastName(lastName);
    }

}
