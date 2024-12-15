package com.github.vspiewak.temporal._1;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface HelloWorkflow {

    @WorkflowMethod
    String execute(String name);

}
