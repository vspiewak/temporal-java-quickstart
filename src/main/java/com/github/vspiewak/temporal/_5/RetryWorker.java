package com.github.vspiewak.temporal._5;

import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;

public class RetryWorker {

    public static void main(String[] args) {

        WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();
        WorkflowClient client = WorkflowClient.newInstance(service);
        WorkerFactory factory = WorkerFactory.newInstance(client);

        Worker worker = factory.newWorker("retry-task-queue");
        worker.registerWorkflowImplementationTypes(RetryWorkflowImpl.class);
        worker.registerActivitiesImplementations(new RetryActivitiesImpl());

        factory.start();

    }

}