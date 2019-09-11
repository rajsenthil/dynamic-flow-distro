package com.spring.aspect.dynamicflow.process;

import com.spring.aspect.dynamicflow.context.AnotherJobContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AnotherProcessImpl implements AnotherProcess {
    Logger logger = LoggerFactory.getLogger( AnotherProcessImpl.class );

    @Override public Object anotherProcess( AnotherJobContext context) {
        logger.info( "AnotherProcess is completed" );
        return null;
    }
}
