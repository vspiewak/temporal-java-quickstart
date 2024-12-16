package com.github.vspiewak.temporal._8.worker;

import com.github.vspiewak.temporal._8.notify.NotifyActivitiesImpl;
import com.github.vspiewak.temporal._8.notify.NotifyWorkflowImpl;
import com.github.vspiewak.temporal._8.register.RegisterActivitiesImpl;
import com.github.vspiewak.temporal._8.register.RegisterWorkflowImpl;
import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;

public class StartWorker {

    public static void main(String[] args) {

        WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();
        WorkflowClient client = WorkflowClient.newInstance(service);
        WorkerFactory factory = WorkerFactory.newInstance(client);

        Worker worker = factory.newWorker("my-task-queue");

        worker.registerWorkflowImplementationTypes(RegisterWorkflowImpl.class);
        worker.registerWorkflowImplementationTypes(NotifyWorkflowImpl.class);

        worker.registerActivitiesImplementations(new RegisterActivitiesImpl());
        worker.registerActivitiesImplementations(new NotifyActivitiesImpl());

        factory.start();

    }

}
