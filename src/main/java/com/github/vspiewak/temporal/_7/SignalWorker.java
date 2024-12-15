package com.github.vspiewak.temporal._7;

import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;

public class SignalWorker {

    public static void main(String[] args) {

        WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();
        WorkflowClient client = WorkflowClient.newInstance(service);
        WorkerFactory factory = WorkerFactory.newInstance(client);

        Worker worker = factory.newWorker("signal-task-queue");
        worker.registerWorkflowImplementationTypes(SignalWorkflowImpl.class);
        worker.registerActivitiesImplementations(new SignalActivitiesImpl());

        factory.start();

    }

}