package com.github.vspiewak.temporal._5;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface RetryWorkflow {

    @WorkflowMethod
    void execute();

}
