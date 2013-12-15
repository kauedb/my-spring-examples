package kauedb.spring.examples.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * User: kauedb
 * Date: 11/22/13
 * Time: 10:49 PM
 */
@Configuration
@ComponentScan("kauedb.spring.examples")
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {



}
