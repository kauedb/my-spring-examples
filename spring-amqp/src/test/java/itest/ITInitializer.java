package itest;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * User: kauedb
 * Date: 11/15/13
 * Time: 4:04 PM
 */
public class ITInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        applicationContext.getEnvironment().setActiveProfiles("integration-test");
    }
}
