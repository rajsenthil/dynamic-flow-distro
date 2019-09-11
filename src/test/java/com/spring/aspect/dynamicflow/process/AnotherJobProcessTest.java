package com.spring.aspect.dynamicflow.process;

import com.spring.aspect.dynamicflow.context.AnotherJobContext;
import com.spring.aspect.dynamicflow.entity.Job;
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
public class AnotherJobProcessTest {

    private Logger logger = LoggerFactory.getLogger( this.getClass());

    @Autowired
    private AnotherProcess anotherProcess;

    @Test
    public void testAnotherProcess() {
        AnotherJobContext context = new AnotherJobContext();
        Job job = new Job();

        job.setJobId( UUID.randomUUID() );
        context.setJob( job );
        anotherProcess.anotherProcess( context );

        logger.info( "Job Status is {}", context.getJobStatus() );
    }
}
