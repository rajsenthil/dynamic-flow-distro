package com.spring.aspect.dynamicflow.process;

import com.spring.aspect.dynamicflow.entity.Job;
import com.spring.aspect.dynamicflow.entity.JobContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith ( SpringRunner.class)
@SpringBootTest
public class JobProcessTest {

    private Logger logger = LoggerFactory.getLogger( this.getClass());

    @Autowired
    private JobProcess jobProcess;

    @Test
    public void testJobProcess() {
        JobContext context = new JobContext();
        Job job = new Job();

        job.setJobId( UUID.randomUUID() );
        context.setJob( job );
//        context.setJob( job );
        jobProcess.process( context );

        logger.info( "Job Status is {}", context.getJobStatus() );
    }
}
