package com.github.vspiewak.temporal._2;

import com.github.vspiewak.temporal._1.HelloWorkflow;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.client.WorkflowStub;
import io.temporal.serviceclient.WorkflowServiceStubs;

public class StartWorkflow {

    public static void main(String[] args) throws Exception {

        // Get a Workflow service stub
        WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();

        WorkflowClient client = WorkflowClient.newInstance(service);

        WorkflowOptions options = WorkflowOptions.newBuilder()
                .setWorkflowId("workflow-from-code")
                .setTaskQueue("hello-task-queue")
                .build();

        HelloWorkflow workflow = client.newWorkflowStub(HelloWorkflow.class, options);

        String result = workflow.execute(args[0]);

        String workflowId = WorkflowStub.fromTyped(workflow).getExecution().getWorkflowId();

        System.out.printf("HelloWorkflow id: %s, result: %s%n", workflowId, result);
        System.exit(0);

    }

}
