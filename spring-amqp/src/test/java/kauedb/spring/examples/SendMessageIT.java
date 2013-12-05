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
        int mega = 1000 * 1000;
        for (int i = 0; i < mega; i++) {
            stringBuilder.append("X");
        }
        return new Object[][]{
                {
                        stringBuilder.toString()
                }
        };
    }

    @Test(invocationCount = 10000, singleThreaded = false)
    public void smallMessage() {

        rabbitTemplate.convertAndSend("myExchange", "kauedb.spring.examples.queue", "hello rabbit");
    }

    @Test(invocationCount = 100, dataProvider = "bigMessageDataProvider")
    public void bigMessage(String bigMessage) {

        rabbitTemplate.convertAndSend("myExchange", "kauedb.spring.examples.queue", bigMessage);
    }


    @Test
    public void testMessageListener(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
