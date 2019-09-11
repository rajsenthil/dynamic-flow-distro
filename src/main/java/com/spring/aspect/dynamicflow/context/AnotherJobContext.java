package com.spring.aspect.dynamicflow.context;

import com.spring.aspect.dynamicflow.entity.Job;
import com.spring.aspect.dynamicflow.entity.TaskStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class AnotherJobContext {

    private Job job;
    private TaskStatus jobStatus;
    private TaskStatus annotationTaskStatus;
    private TaskStatus reviewTaskStatus;
}
