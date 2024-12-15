package com.github.vspiewak.temporal._4;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

import java.util.List;

@WorkflowInterface
public interface OrderWorkflow {

    @WorkflowMethod
    List<String> execute(String name);

}