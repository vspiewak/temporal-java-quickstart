package com.github.vspiewak.temporal._8.register;

public class RegisterActivitiesImpl implements RegisterActivities {

    @Override
    public String register(String email) {
        return String.format("registered: %s", email);
    }

}
