package com.spring.aspect.dynamicflow.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TaskAspects {

    private static final Logger log = LoggerFactory.getLogger( TaskAspects.class );

    @Around( "within(com.spring.aspect.dynamicflow.activity.TaskActivity+) ")
//    @Around( "execution(com.spring.aspect.dynamicflow.activity.TaskActivity+) " + "&& args(proceedingJoinPoint)" )
    public Object handleTask( ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info( "Handling the task aspects." );
        log.info( "" + proceedingJoinPoint.getThis() );

        return proceedingJoinPoint.proceed();
    }

}
