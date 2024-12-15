package com.github.vspiewak.temporal._6;

import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;

public class SleepyWorker {

    public static void main(String[] args) {

        WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();
        WorkflowClient client = WorkflowClient.newInstance(service);
        WorkerFactory factory = WorkerFactory.newInstance(client);

        Worker worker = factory.newWorker("sleepy-task-queue");
        worker.registerWorkflowImplementationTypes(SleepyWorkflowImpl.class);
        worker.registerActivitiesImplementations(new SleepyActivitiesImpl());

        factory.start();

    }

}