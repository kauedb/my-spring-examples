package kauedb.spring.examples.batch;

import kauedb.spring.examples.dto.Costumer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * User: kauedb
 * Date: 11/17/13
 * Time: 11:40 AM
 */
@Component
public class EmailItemProcessor implements ItemProcessor<Costumer, Costumer> {

    @Override
    public Costumer process(Costumer costumer) throws Exception {
        System.out.println(costumer);
        return costumer;
    }
}
