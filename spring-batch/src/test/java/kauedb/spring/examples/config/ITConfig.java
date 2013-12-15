package kauedb.spring.examples.config;

import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * User: kauedb
 * Date: 11/15/13
 * Time: 3:36 PM
 */
@Configuration
@Profile("integration-test")
public class ITConfig {

    @Bean(destroyMethod = "shutdown")
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setName("mytestdb")
                .addDefaultScripts()
                .addScript("schema-drop-h2.sql")
                .addScript("schema-h2.sql")
                .build();
    }

    @Bean
    public JobLauncherTestUtils jobLauncherTestUtils(){
        final JobLauncherTestUtils jobLauncherTestUtils = new JobLauncherTestUtils();
        return jobLauncherTestUtils;

    }


}
