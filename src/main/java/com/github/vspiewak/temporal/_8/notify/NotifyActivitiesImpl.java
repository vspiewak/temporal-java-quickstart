package com.github.vspiewak.temporal._8.notify;

public class NotifyActivitiesImpl implements NotifyActivities {

    @Override
    public String sendEmail(String email) {
        return String.format("sent email to: %s", email);
    }

}
