package com.github.vspiewak.temporal._3;

import com.github.vspiewak.temporal._1.HelloWorkflow;
import io.temporal.client.WorkflowOptions;
import io.temporal.client.schedules.*;
import io.temporal.serviceclient.WorkflowServiceStubs;

import java.time.Duration;
import java.util.Collections;

public class StartScheduleWorkflow {

    public static void main(String[] args) {

        WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();

        ScheduleClient scheduleClient = ScheduleClient.newInstance(service);

        WorkflowOptions workflowOptions =
                WorkflowOptions
                        .newBuilder()
                        .setWorkflowId("workflow-from-schedule")
                        .setTaskQueue("hello-task-queue")
                        .build();

        ScheduleActionStartWorkflow action =
                ScheduleActionStartWorkflow
                        .newBuilder()
                        .setWorkflowType(HelloWorkflow.class)
                        .setArguments("World")
                        .setOptions(workflowOptions)
                        .build();

        Schedule schedule =
                Schedule
                        .newBuilder()
                        .setAction(action)
                        .setSpec(
                                ScheduleSpec
                                        .newBuilder()
                                        .setIntervals(
                                                Collections.singletonList(
                                                        new ScheduleIntervalSpec(Duration.ofSeconds(30))
                                                )
                                        )
                                        .build()
                        )
                        .build();

        ScheduleOptions scheduleOptions =
                ScheduleOptions
                        .newBuilder()
                        .build();

        ScheduleHandle handle =
                scheduleClient.createSchedule("HelloSchedule", schedule, scheduleOptions);

        System.exit(0);

    }

}
