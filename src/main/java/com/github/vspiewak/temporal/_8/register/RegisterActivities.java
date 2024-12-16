package com.github.vspiewak.temporal._8.register;

import io.temporal.activity.ActivityInterface;

@ActivityInterface
public interface RegisterActivities {

    String register(String email);

}
