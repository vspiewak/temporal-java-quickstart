package com.github.vspiewak.temporal._4;


import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Async;
import io.temporal.workflow.Promise;
import io.temporal.workflow.Workflow;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class OrderWorkflowImpl implements OrderWorkflow {

    private final OrderActivities activities =
            Workflow.newActivityStub(
                    OrderActivities.class,
                    ActivityOptions.newBuilder()
                            .setStartToCloseTimeout(Duration.ofSeconds(5))
                            .build());

    @Override
    public List<String> execute(String name) {

        var results = new ArrayList<String>();

        results.add(activities.activityOne());
        results.add(activities.activityTwo());

        // add promises
        List<Promise<String>> promiseList = new ArrayList<>();
        promiseList.add(Async.function(activities::activityThree));
        promiseList.add(Async.function(activities::activityFour));

        // invoke all
        Promise.allOf(promiseList).get();

        // loop through results
        for (Promise<String> promise : promiseList) {
            if (promise.getFailure() == null) {
                results.add(promise.get());
            }
        }

        return results;

    }

}
