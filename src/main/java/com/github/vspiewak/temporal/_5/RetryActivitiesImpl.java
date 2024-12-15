package com.github.vspiewak.temporal._5;

import io.temporal.activity.Activity;

public class RetryActivitiesImpl implements RetryActivities {

    @Override
    public void activityWhoCanFail() {

        var attempt = Activity.getExecutionContext().getInfo().getAttempt();

        if(attempt < 5) {
            /*
             * Instead of adding the thrown exception to the activity method signature
             * wrap it using Workflow.wrap before re-throwing it.
             * The original checked exception will be unwrapped and attached as the cause to the
             * {@link io.temporal.failure.ActivityFailure}
             */
            throw Activity.wrap(new Exception(String.format("Failed on attempt %d", attempt)));

        }

    }
}
