package com.github.vspiewak.temporal._1;

public class HelloActivitiesImpl implements HelloActivities {

    @Override
    public String hello(String name) {
        return String.format("Hello %s!", name);
    }

}
