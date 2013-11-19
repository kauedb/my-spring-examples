package kauedb.spring.examples.config;

import kauedb.spring.examples.queue.MessageConsumer;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * User: kauedb
 * Date: 11/16/13
 * Time: 12:43 PM
 */
@Configuration
@ComponentScan("kauedb.spring.examples")
public class AppConfig {

    @Autowired
    private MessageConsumer listener;

    @Bean
    public ConnectionFactory connectionFactory() {
//        final ConnectionFactory connectionFactory = new CachingConnectionFactory("ubuntu", 15672);
        final ConnectionFactory connectionFactory = new CachingConnectionFactory();
        return connectionFactory;
    }

    @Bean
    public RabbitAdmin rabbitAdmin() {
        final RabbitAdmin admin = new RabbitAdmin(connectionFactory());

        final Queue queue = new Queue("myQueue");
        admin.declareQueue(queue);

        final TopicExchange exchange = new TopicExchange("myExchange");
        admin.declareExchange(exchange);

        admin.declareBinding(BindingBuilder.bind(queue).to(exchange).with("kauedb.spring.examples.queue"));

        return admin;
    }

    @Bean(destroyMethod = "stop")
    public SimpleMessageListenerContainer simpleMessageListenerContainer() {
        final SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory());

        final MessageListenerAdapter adapter = new MessageListenerAdapter(listener);
        adapter.setDefaultListenerMethod("listen");
        container.setMessageListener(adapter);
        container.setQueueNames("myQueue");
        container.start();
        return container;
    }


    @Bean
    public RabbitTemplate rabbitTemplate() {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        return rabbitTemplate;
    }

}
