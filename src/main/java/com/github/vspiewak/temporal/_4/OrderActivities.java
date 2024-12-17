package com.github.vspiewak.temporal._4;

import io.temporal.activity.ActivityInterface;

@ActivityInterface
public interface OrderActivities {

    String activityOne();

    String activityTwo();

    String activityThree();

    String activityFour();

}
