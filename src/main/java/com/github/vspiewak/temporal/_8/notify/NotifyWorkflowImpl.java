package com.github.vspiewak.temporal._8.notify;

import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;

import java.time.Duration;

public class NotifyWorkflowImpl implements NotifyWorkflow {

    private final NotifyActivities activities =
            Workflow.newActivityStub(
                    NotifyActivities.class,
                    ActivityOptions.newBuilder()
                            .setStartToCloseTimeout(Duration.ofSeconds(5))
                            .build());

    @Override
    public String execute(String email) {
        return activities.sendEmail(email);
    }

}
