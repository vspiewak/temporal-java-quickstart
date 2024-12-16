package com.github.vspiewak.temporal._8.notify;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface NotifyWorkflow {

    @WorkflowMethod
    String execute(String email);

}
