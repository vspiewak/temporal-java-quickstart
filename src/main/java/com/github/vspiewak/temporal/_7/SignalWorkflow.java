package com.github.vspiewak.temporal._7;

import io.temporal.workflow.SignalMethod;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface SignalWorkflow {

    @WorkflowMethod
    String execute();

    @SignalMethod(name = "my-signal")
    void sendSignal(SignalInputMessage input);


}
