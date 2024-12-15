package com.github.vspiewak.temporal._1;

import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;

import java.time.Duration;

public class HelloWorkflowImpl implements HelloWorkflow {

    ActivityOptions options = ActivityOptions.newBuilder()
            .setStartToCloseTimeout(Duration.ofSeconds(5))
            .build();

    private final HelloActivities activities = Workflow.newActivityStub(HelloActivities.class, options);

    @Override
    public String execute(String name) {
        return activities.hello(name);
    }
}
