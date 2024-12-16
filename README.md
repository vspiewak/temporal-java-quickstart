# Temporal Java Quickstart

Build invincible applications with [Temporal](https://temporal.io) using the Java SDK.

## Setup

    # build the project
    ./mvnw clean compile
    
    # launch temporal server/ui
    temporal server start-dev --ui-port 8080


## Scenario 1 - Hello Workflow
    
    # start the worker
    ./mvnw exec:java -Dexec.mainClass="com.github.vspiewak.temporal._1.HelloWorker"

    # start a workflow execution
    temporal workflow start --type HelloWorkflow -t hello-task-queue -w my-first-workflow --input '"Vincent"'

    # show the workflow execution
    temporal workflow show -w my-first-workflow


## Scenario 2 - Start a Workflow Execution from the SDK
    
    # start the worker
    ./mvnw exec:java -Dexec.mainClass="com.github.vspiewak.temporal._1.HelloWorker"

    # start a workflow execution
    ./mvnw exec:java -Dexec.mainClass="com.github.vspiewak.temporal._2.StartWorkflow" -Dexec.args="'Vincent'"


## Scenario 3 - Start a Schedule Workflow
    
    # start the worker
    ./mvnw exec:java -Dexec.mainClass="com.github.vspiewak.temporal._1.HelloWorker"

    # start a schedule workflow execution
    ./mvnw exec:java -Dexec.mainClass="com.github.vspiewak.temporal._3.StartScheduleWorkflow"


## Scenario 4 - Ordering Activities

    # start the worker
    ./mvnw exec:java -Dexec.mainClass="com.github.vspiewak.temporal._4.OrderWorker"

    # start a workflow execution
    temporal workflow start --type OrderWorkflow -w my-order-workflow -t order-task-queue


## Scenario 5 - Activity Retries

    # start the worker
    ./mvnw exec:java -Dexec.mainClass="com.github.vspiewak.temporal._5.RetryWorker"

    # start a workflow execution
    temporal workflow start --type RetryWorkflow -w my-retry-workflow -t retry-task-queue


## Scenario 6 - Workflow Sleep
    
    # start the worker
    ./mvnw exec:java -Dexec.mainClass="com.github.vspiewak.temporal._6.SleepyWorker"

    # start a workflow execution
    temporal workflow start --type SleepyWorkflow -w my-sleepy-workflow -t sleepy-task-queue


## Scenario 7 - Send a signal to a Workflow Execution

    # start the worker
    ./mvnw exec:java -Dexec.mainClass="com.github.vspiewak.temporal._7.SignalWorker"

    # start a workflow execution
    temporal workflow start --type SignalWorkflow -w my-signal-workflow -t sleepy-task-queue
    
    # send a signal using temporal cli
    temporal workflow signal --name "my-signal" -w "my-signal-workflow" -i '{ "value":"hello-signal", "count": 1}'

    # ... or with SDK
    ./mvnw exec:java -Dexec.mainClass="com.github.vspiewak.temporal._7.SignalSender"


## Scenario 8 - Child Workflow

    # start the worker
    ./mvnw exec:java -Dexec.mainClass="com.github.vspiewak.temporal._8.worker.StartWorker"

    # start a notify workflow execution
    temporal workflow start --type NotifyWorkflow -w my-notify-workflow -t my-task-queue -i '"vince@nospam.org"'
    
    # start a register workflow execution
    temporal workflow start --type RegisterWorkflow -w my-register-workflow -t my-task-queue -i '"vince@nospam.org"'
        
    