package kauedb.spring.examples;

import itest.BaseIT;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * User: kauedb
 * Date: 11/16/13
 * Time: 12:57 PM
 */
public class SendMessageIT extends BaseIT {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @DataProvider(name = "bigMessageDataProvider")
    public Object[][] dataProvider() {
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            stringBuilder.append("AbC-1");
        }
        return new Object[][]{
                {
                        stringBuilder.toString()
                }
        };
    }

    @Test(invocationCount = 10000)
    public void test() {

        rabbitTemplate.convertAndSend("myExchange", "kauedb.spring.examples.queue", "hello rabbit");
    }

    @Test(invocationCount = 10, dataProvider = "bigMessageDataProvider")
    public void test2(String bigMessage) {

        rabbitTemplate.convertAndSend("myExchange", "kauedb.spring.examples.queue", bigMessage);
    }

    @Test
    public void test3(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
