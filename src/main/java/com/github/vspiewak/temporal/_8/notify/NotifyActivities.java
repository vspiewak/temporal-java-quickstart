package com.github.vspiewak.temporal._8.notify;

import io.temporal.activity.ActivityInterface;

@ActivityInterface
public interface NotifyActivities {

    String sendEmail(String email);

}
