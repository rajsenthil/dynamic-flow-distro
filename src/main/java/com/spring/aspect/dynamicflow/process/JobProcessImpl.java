package com.spring.aspect.dynamicflow.process;

import com.spring.aspect.dynamicflow.entity.JobContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class JobProcessImpl implements JobProcess {

    Logger logger = LoggerFactory.getLogger( JobProcessImpl.class );
    @Override
    public Object process( JobContext jobContext ) {
        logger.info( "Job flow process for {} with current job status as {}", jobContext.getJob().getJobId(), jobContext.getJobStatus() );
        return null;
    }
}
