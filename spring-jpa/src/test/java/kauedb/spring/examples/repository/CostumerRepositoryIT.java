package kauedb.spring.examples.repository;

import com.mysema.query.types.expr.BooleanExpression;
import kauedb.spring.examples.entity.Costumer;
import kauedb.spring.examples.entity.QCostumer;
import kauedb.spring.examples.itest.BaseIT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * User: kauedb
 * Date: 11/15/13
 * Time: 7:01 PM
 */
public class CostumerRepositoryIT extends BaseIT {

    @Autowired
    private CostumerRepository costumerRepository;

    @Test
    public void findOne() {
        Costumer costumer = costumerRepository.findOne(1L);
        assertThat(costumer, notNullValue());
        assertThat(costumer.getFirstName(), equalTo("Kaue"));
        assertThat(costumer.getLastName(), equalTo("Carbonari"));
    }

    @Test
    public void findByLastName() {
        final List<Costumer> costumers = costumerRepository.findByLastName("Carbonari");
        assertThat(costumers.isEmpty(), is(false));
        assertThat(costumers.size(), is(1));
        assertThat(costumers.get(0), notNullValue());
        assertThat(costumers.get(0).getId(), equalTo(1L));
        assertThat(costumers.get(0).getFirstName(), equalTo("Kaue"));

    }

    @Test
    public void save() {
        final Costumer costumer = new Costumer();
        costumer.setFirstName("Kaio");
        costumer.setLastName("Carbonari");

        final Costumer result = costumerRepository.saveAndFlush(costumer);
        assertThat(result, notNullValue());
        assertThat(result.getId(), equalTo(2L));
        assertThat(costumer.getFirstName(), equalTo("Kaio"));
        assertThat(costumer.getLastName(), equalTo("Carbonari"));

    }

    @Test
    public void pagination() {

        int page = 0;
        int pageSize = 1;

        final Pageable pageable = new PageRequest(page, pageSize);

        final List<Costumer> costumers = costumerRepository.findByLastName("Carbonari", pageable).getContent();
        assertThat(costumers.isEmpty(), is(false));
        assertThat(costumers.size(), is(1));
        assertThat(costumers.get(0), notNullValue());
        assertThat(costumers.get(0).getId(), equalTo(1L));
        assertThat(costumers.get(0).getFirstName(), equalTo("Kaue"));

    }

    @Test
    public void sorting() {

        Sort sort = new Sort(Sort.Direction.ASC, "id");

        final List<Costumer> costumers = costumerRepository.findByLastName("Carbonari", sort);
        assertThat(costumers.isEmpty(), is(false));
        assertThat(costumers.size(), is(1));
        assertThat(costumers.get(0), notNullValue());
        assertThat(costumers.get(0).getId(), equalTo(1L));
        assertThat(costumers.get(0).getFirstName(), equalTo("Kaue"));

    }

    @Test
    public void queryDsl() {


        BooleanExpression predicate = QCostumer.costumer.firstName.eq("Kaue");

        final Iterable<Costumer> costumers = costumerRepository.findAll(predicate);
        assertThat(costumers.iterator().hasNext(), is(true));
        final Costumer costumer = costumers.iterator().next();
        assertThat(costumer, notNullValue());
        assertThat(costumer.getId(), equalTo(1L));
        assertThat(costumer.getFirstName(), equalTo("Kaue"));

    }


}
