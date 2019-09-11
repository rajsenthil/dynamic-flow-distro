package com.spring.aspect.dynamicflow.activity;

import com.spring.aspect.dynamicflow.context.JobContext;
import com.spring.aspect.dynamicflow.entity.Task;
import com.spring.aspect.dynamicflow.entity.TaskStatus;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActivityC extends TaskActivity {

    private static final Logger log = LoggerFactory.getLogger( ActivityC.class );

    @Override
    public Object task( ProceedingJoinPoint proceedingJoinPoint, JobContext context ) throws Throwable {
        log.info( "ActivityC's task" );

        return proceedingJoinPoint.proceed();
    }
}
