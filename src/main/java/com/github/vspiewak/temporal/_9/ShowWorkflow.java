package com.github.vspiewak.temporal._9;

import io.temporal.api.common.v1.WorkflowExecution;
import io.temporal.api.workflowservice.v1.DescribeWorkflowExecutionRequest;
import io.temporal.api.workflowservice.v1.GetWorkflowExecutionHistoryRequest;
import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;

public class ShowWorkflow {

    public static void main(String[] args) {

        var service = WorkflowServiceStubs.newLocalServiceStubs();

        var client = WorkflowClient.newInstance(service);

        var describeRequest =
                DescribeWorkflowExecutionRequest.newBuilder()
                        .setNamespace(client.getOptions().getNamespace())
                        .setExecution(
                                WorkflowExecution
                                        .newBuilder()
                                        .setWorkflowId(args[0])
                                        .build())
                        .build();

        var describeResponse = service.blockingStub().describeWorkflowExecution(describeRequest);

        var historyRequest =
                GetWorkflowExecutionHistoryRequest
                        .newBuilder()
                        .setNamespace(client.getOptions().getNamespace())
                        .setExecution(
                                WorkflowExecution
                                        .newBuilder()
                                        .setWorkflowId(args[0])
                                        .build()
                        )
                        .build();

        var historyResponse = service.blockingStub().getWorkflowExecutionHistory(historyRequest);

        System.out.println(describeResponse);
        System.out.println(describeResponse.getPendingActivitiesList());

        System.out.println("----------------------------");
        System.out.println("Summary");
        System.out.println("----------------------------");

        System.out.println(describeResponse.getWorkflowExecutionInfo());

        System.out.println("----------------------------");
        System.out.println("Event History");
        System.out.println("----------------------------");

        System.out.println(historyResponse);

        System.exit(0);

    }

}
