package kauedb.spring.examples.config;

import com.jolbox.bonecp.BoneCPDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;
import java.util.concurrent.TimeUnit;

/**
 * User: kauedb
 * Date: 11/15/13
 * Time: 3:56 PM
 */
@Configuration
@Profile("production")
public class DataSourceConfig {

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        final BoneCPDataSource boneCPDataSource = new BoneCPDataSource();


        boneCPDataSource.setDriverClass(com.mysql.jdbc.Driver.class.getName());
        boneCPDataSource.setJdbcUrl("jdbc:mysql://ubuntu:3306/test");
        boneCPDataSource.setUsername("root");
        boneCPDataSource.setPassword("1234");
        boneCPDataSource.setIdleConnectionTestPeriod(60, TimeUnit.MINUTES);
        boneCPDataSource.setIdleMaxAge(240, TimeUnit.SECONDS);
        boneCPDataSource.setMaxConnectionsPerPartition(30);
        boneCPDataSource.setMinConnectionsPerPartition(10);
        boneCPDataSource.setPartitionCount(3);
        boneCPDataSource.setAcquireIncrement(5);
        boneCPDataSource.setStatementsCacheSize(100);


        return boneCPDataSource;
    }

}
