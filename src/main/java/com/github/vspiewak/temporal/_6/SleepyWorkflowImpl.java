package com.github.vspiewak.temporal._6;

import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;

import java.time.Duration;

public class SleepyWorkflowImpl implements SleepyWorkflow {

    private final SleepyActivities activities =
            Workflow.newActivityStub(
                    SleepyActivities.class,
                    ActivityOptions.newBuilder()
                            .setStartToCloseTimeout(Duration.ofSeconds(5))
                            .build());

    @Override
    public String execute() {

        var start = Workflow.currentTimeMillis();

        var resultOne = activities.activityOne();

        Workflow.sleep(Duration.ofSeconds(12));

        var resultTwo = activities.activityTwo();

        var end = Workflow.currentTimeMillis();

        var duration = Duration.ofMillis(end - start).getSeconds();

        return String.format("resultOne: %s, resultTwo: %s, took: %ds", resultOne, resultTwo, duration);

    }

}
