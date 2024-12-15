package com.github.vspiewak.temporal._5;

import io.temporal.activity.ActivityOptions;
import io.temporal.common.RetryOptions;
import io.temporal.workflow.Workflow;

import java.time.Duration;

public class RetryWorkflowImpl implements RetryWorkflow {

    private final RetryActivities activities =
            Workflow.newActivityStub(
                    RetryActivities.class,
                    ActivityOptions.newBuilder()
                            .setStartToCloseTimeout(Duration.ofSeconds(5))
                            .setRetryOptions(
                                    RetryOptions.newBuilder()
                                            .setInitialInterval(Duration.ofSeconds(1))
                                            .setMaximumInterval(Duration.ofSeconds(10))
                                            .setBackoffCoefficient(2)
                                            .setMaximumAttempts(5)
                                            .build()
                            )
                            .build());

    @Override
    public void execute() {

        activities.activityWhoCanFail();

    }
}
