package com.github.vspiewak.temporal._5;

import io.temporal.activity.ActivityInterface;

@ActivityInterface
public interface RetryActivities {

    void activityWhoCanFail();

}
