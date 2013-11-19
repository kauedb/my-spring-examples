package kauedb.spring.examples.batch;

import itest.BaseIT;
import org.junit.Assert;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

/**
 * User: kauedb
 * Date: 11/16/13
 * Time: 10:05 PM
 */
public class BatchIT extends BaseIT {


    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Test
    public void launchJob() throws Exception {
        final JobExecution jobExecution = jobLauncherTestUtils.launchJob();
        Assert.assertEquals(jobExecution.getStatus(), BatchStatus.COMPLETED);

    }

}
