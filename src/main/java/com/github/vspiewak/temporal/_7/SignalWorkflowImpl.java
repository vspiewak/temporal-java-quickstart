package com.github.vspiewak.temporal._7;

import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;

import java.time.Duration;

public class SignalWorkflowImpl implements SignalWorkflow {

    private SignalInputMessage signalInputMessage;

    private final SignalActivities activities =
            Workflow.newActivityStub(
                    SignalActivities.class,
                    ActivityOptions.newBuilder()
                            .setStartToCloseTimeout(Duration.ofSeconds(5))
                            .build());

    @Override
    public String execute() {

        var start = Workflow.currentTimeMillis();

        var resultOne = activities.activityOne();

        Workflow.await(() -> signalInputMessage != null);

        var resultTwo = activities.activityTwo();

        var end = Workflow.currentTimeMillis();

        var duration = Duration.ofMillis(end - start).getSeconds();

        return String.format(
                "resultOne: %s, resultTwo: %s, signal: (%s, %d), took: %ds",
                resultOne,
                resultTwo,
                signalInputMessage.value(),
                signalInputMessage.count(),
                duration
        );

    }

    @Override
    public void sendSignal(SignalInputMessage input) {
        signalInputMessage = input;
    }

}
