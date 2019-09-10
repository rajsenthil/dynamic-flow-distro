package com.spring.aspect.dynamicflow.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Job {
    UUID jobId;
    List<Task> annotationTasks;
    List<Task> reviewTasks;
}
