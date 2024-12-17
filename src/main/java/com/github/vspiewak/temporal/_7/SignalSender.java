package com.github.vspiewak.temporal._7;

import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;

public class SignalSender {

    public static void main(String[] args) {

        WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();

        WorkflowClient client = WorkflowClient.newInstance(service);

        SignalWorkflow workflow = client.newWorkflowStub(SignalWorkflow.class, "my-signal-workflow");

        workflow.sendSignal(new SignalInputMessage("my-message", 42));

        System.exit(0);

    }

}
