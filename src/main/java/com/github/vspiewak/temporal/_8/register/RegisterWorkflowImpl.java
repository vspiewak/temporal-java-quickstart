package com.github.vspiewak.temporal._8.register;

import com.github.vspiewak.temporal._8.notify.NotifyWorkflow;
import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.ChildWorkflowOptions;
import io.temporal.workflow.Workflow;

import java.time.Duration;

public class RegisterWorkflowImpl implements RegisterWorkflow {

    private final RegisterActivities activities = Workflow.newActivityStub(RegisterActivities.class, ActivityOptions.newBuilder().setStartToCloseTimeout(Duration.ofSeconds(5)).build());

    @Override
    public String execute(String email) {

        var registerResult = activities.register(email);

        var child = Workflow.newChildWorkflowStub(
                NotifyWorkflow.class,
                ChildWorkflowOptions
                        .newBuilder()
                        .setWorkflowId("my-notify-child-workflow")
                        .build());

        var childResult = child.execute(email);

        return String.format(
                "register result: %s, child workflow result: %s",
                registerResult,
                childResult
        );

    }

}
