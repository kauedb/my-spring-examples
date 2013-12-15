package itest;

import kauedb.spring.examples.config.AppConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * User: kauedb
 * Date: 11/15/13
 * Time: 4:36 PM
 */
@ContextConfiguration(initializers = ITInitializer.class, classes = AppConfig.class)
public class BaseIT extends AbstractTestNGSpringContextTests {


}
