package com.spring.aspect.dynamicflow.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class JobContext {

    private Job job;
    private TaskStatus jobStatus;
    private TaskStatus annotationTaskStatus;
    private TaskStatus reviewTaskStatus;
}
