package com.spring.aspect.dynamicflow.activity;

import com.spring.aspect.dynamicflow.context.JobContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public abstract class Activity {

    private static final Logger log = LoggerFactory.getLogger( Activity.class );

    @Around ( "execution(public java.lang.Object com.spring.aspect.dynamicflow.process.AnotherProcessImpl.anotherProcess(..)) " + "&& args(context)" )
    public Object task( ProceedingJoinPoint proceedingJoinPoint, JobContext context ) throws Throwable {
        log.info( "Dynamic Flow Distro: {} ", context.getJobStatus() );
        return  proceedingJoinPoint.proceed();
    }
}
