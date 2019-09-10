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
public class ReviewTaskActivity extends TaskActivity {

    private static final Logger log = LoggerFactory.getLogger( ReviewTaskActivity.class );

    @Override
    public Object task( ProceedingJoinPoint proceedingJoinPoint, JobContext context ) throws Throwable {
        log.info( "ReviewTaskActivity's task" );

        /*
         * Iterate through the review tasks
         */
        log.info( "Iterate through the review task list" );
        log.info( "if completed, then review task activity status is set to COMPLETED" );
        log.info( "else to IN_PROGRESS" );

        List<Task> reviewTasks = context.getJob().getAnnotationTasks();

        boolean annotationCompleted = true;
        if ( reviewTasks != null )
            annotationCompleted = reviewTasks.stream().allMatch( t -> t.getTaskStatus().equals( TaskStatus.COMPLETED ) );
        if (annotationCompleted) {
            context.setAnnotationTaskStatus( TaskStatus.COMPLETED );
            log.info( "Review tasks are completed" );
            log.info( "Setting the job status as COMPLETED as well." );
            context.setJobStatus( TaskStatus.COMPLETED );
            return proceedingJoinPoint.proceed();
        }
        else {
            context.setAnnotationTaskStatus( TaskStatus.IN_PROGRESS );
            context.setJobStatus( TaskStatus.IN_PROGRESS );
            return context;
        }
    }
}
