package kauedb.spring.examples.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

/**
 * User: kauedb
 * Date: 11/15/13
 * Time: 3:56 PM
 */
@Configuration
@Profile("production")
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {
        return null;
    }

}
