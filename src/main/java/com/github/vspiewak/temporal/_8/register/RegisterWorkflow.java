package com.github.vspiewak.temporal._8.register;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface RegisterWorkflow {

    @WorkflowMethod
    String execute(String email);

}
