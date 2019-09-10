package com.spring.aspect.dynamicflow.pointcuts;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PointCuts {

    @Pointcut ( "execution(public void GenericProcessImpl.execute(..)) " )
    public void processExecution(Object input) {}
}
