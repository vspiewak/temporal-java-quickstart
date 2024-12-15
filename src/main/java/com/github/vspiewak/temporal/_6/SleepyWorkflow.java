package com.github.vspiewak.temporal._6;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface SleepyWorkflow {

    @WorkflowMethod
    String execute();

}
