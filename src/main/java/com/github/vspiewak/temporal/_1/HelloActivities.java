package com.github.vspiewak.temporal._1;

import io.temporal.activity.ActivityInterface;

@ActivityInterface
public interface HelloActivities {

    String hello(String name);

}
