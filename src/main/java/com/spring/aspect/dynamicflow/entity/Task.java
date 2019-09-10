package com.spring.aspect.dynamicflow.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Task {
    UUID taskId;
    TaskStatus taskStatus;
}
