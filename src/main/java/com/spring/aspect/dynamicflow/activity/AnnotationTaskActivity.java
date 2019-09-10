package com.spring.aspect.dynamicflow.activity;

import com.spring.aspect.dynamicflow.entity.JobContext;
import com.spring.aspect.dynamicflow.entity.Task;
import com.spring.aspect.dynamicflow.entity.TaskStatus;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnnotationTaskActivity extends TaskActivity {

    private static final Logger log = LoggerFactory.getLogger( AnnotationTaskActivity.class );

    @Override
    public Object task( ProceedingJoinPoint proceedingJoinPoint, JobContext context ) throws Throwable {
        log.info( "AnnotationTaskActivity's task" );

        /*
         * do some validation if annotation is completed or not
         */

        log.info( "Iterate through the annotation task list and check if all tasks are completed" );
        log.info( "if completed, then annotation task activity status is set to COMPLETED" );
        log.info( "else the annotation task activity is set to IN_PROGRESS" );

        List<Task> annotationTasks = context.getJob().getAnnotationTasks();

        boolean annotationCompleted = true;

        if (annotationTasks != null) {
            annotationCompleted = annotationTasks.stream().allMatch( t -> t.getTaskStatus().equals( TaskStatus.COMPLETED ) );
        }
        if (annotationCompleted) {
            context.setAnnotationTaskStatus( TaskStatus.COMPLETED );
            context.setJobStatus( TaskStatus.IN_PROGRESS );
            return proceedingJoinPoint.proceed();
        }
        else {
            context.setAnnotationTaskStatus( TaskStatus.IN_PROGRESS );
            return context;
        }

    }

}
