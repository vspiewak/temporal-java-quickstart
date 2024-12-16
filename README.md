# Temporal Java Quickstart

## Setup

    # build the project
    ./mvnw clean compile
    
    # launch temporal server/ui
    temporal server start-dev --ui-port 8080


## Scenario 1
    
    # start the worker
    ./mvnw exec:java -Dexec.mainClass="com.github.vspiewak.temporal._1.HelloWorker"

    # start a workflow execution
    temporal workflow start --type HelloWorkflow --task-queue hello-task-queue --workflow-id my-first-workflow --input '"Vincent"'

    # show the workflow execution
    temporal workflow show --workflow-id my-first-workflow


## Scenario 2
    
    # start the worker
    ./mvnw exec:java -Dexec.mainClass="com.github.vspiewak.temporal._1.HelloWorker"

    # start a workflow execution
    ./mvnw exec:java -Dexec.mainClass="com.github.vspiewak.temporal._2.StartWorkflow" -Dexec.args="'Vincent'"


## Scenario 3
    
    # start the worker
    ./mvnw exec:java -Dexec.mainClass="com.github.vspiewak.temporal._1.HelloWorker"

    # start a schedule workflow execution
    ./mvnw exec:java -Dexec.mainClass="com.github.vspiewak.temporal._3.StartScheduleWorkflow"


## Scenario 4

    # start the worker
    ./mvnw exec:java -Dexec.mainClass="com.github.vspiewak.temporal._4.OrderWorker"

    # start a workflow execution
    temporal workflow start --type OrderWorkflow --workflow-id my-order-workflow --task-queue order-task-queue


## Scenario 5

    # start the worker
    ./mvnw exec:java -Dexec.mainClass="com.github.vspiewak.temporal._5.RetryWorker"

    # start a workflow execution
    temporal workflow start --type RetryWorkflow --workflow-id my-retry-workflow --task-queue retry-task-queue


## Scenario 6
    
    # start the worker
    ./mvnw exec:java -Dexec.mainClass="com.github.vspiewak.temporal._6.SleepyWorker"

    # start a workflow execution
    temporal workflow start --type SleepyWorkflow --workflow-id my-sleepy-workflow --task-queue sleepy-task-queue


## Scenario 7

    # start the worker
    ./mvnw exec:java -Dexec.mainClass="com.github.vspiewak.temporal._7.SignalWorker"

    # start a workflow execution
    temporal workflow start --type SignalWorkflow --workflow-id my-signal-workflow --task-queue sleepy-task-queue
    
    # send a signal using temporal cli
    temporal workflow signal --name "my-signal"  -i '{ "value":"hello-signal", "count": 1}' --workflow-id "my-signal-workflow"

    # ... or with SDK
    ./mvnw exec:java -Dexec.mainClass="com.github.vspiewak.temporal._7.SignalSender"


## Scenario 8

    # start the worker
    ./mvnw exec:java -Dexec.mainClass="com.github.vspiewak.temporal._8.worker.StartWorker"

    # start a notify workflow execution
    temporal workflow start --type NotifyWorkflow --workflow-id my-notify-workflow --task-queue my-task-queue --input '"vince@nospam.org"'
    
    # start a register workflow execution
    temporal workflow start --type RegisterWorkflow --workflow-id my-register-workflow --task-queue my-task-queue --input '"vince@nospam.org"'
        
    