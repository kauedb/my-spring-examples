package kauedb.spring.examples.config;

import kauedb.spring.examples.dto.Costumer;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * User: kauedb
 * Date: 11/16/13
 * Time: 9:48 PM
 */
@Configuration
@ComponentScan("kauedb.spring.examples")
@EnableBatchProcessing
@EnableTransactionManagement
public class AppConfig {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JobBuilderFactory jobBuilderFactory;


    @Autowired
    private StepBuilderFactory stepBuilderFactory;


    @Bean
    public Job job(Step step1) {
        return jobBuilderFactory.get("myJob").start(step1).on("FAILED").stopAndRestart(step1).on("COMPLETED").end().build().build();
    }

    @Bean
    public ItemReader<Costumer> costumerItemReader() {
        final JdbcCursorItemReader<Costumer> itemReader = new JdbcCursorItemReader<Costumer>();
        itemReader.setSql("SELECT ID_COSTUMER as id, FIRST_NAME as firstName, LAST_NAME as lastName FROM COSTUMER");
        itemReader.setDataSource(dataSource);
        itemReader.setRowMapper(new BeanPropertyRowMapper<Costumer>(Costumer.class));
        return itemReader;
    }

    @Bean
    public NamedParameterJdbcTemplate jdbcTemplate() {
        return new NamedParameterJdbcTemplate(dataSource);
    }


    @Bean
    public Step step1(ItemReader<Costumer> costumerItemReader, ItemProcessor<Costumer, Costumer> processor) {
        return stepBuilderFactory.get("step1")
                .<Costumer, Costumer>chunk(10)
                .reader(costumerItemReader)
                .processor(processor)
                .build();
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

}
