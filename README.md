# Temporal Java Quickstart

    # build the project
    ./mvnw clean compile
    
    # launch temporal server/ui
    temporal server start-dev --ui-port 8080


    #
    # case 1
    #
    
    # start the worker
    ./mvnw exec:java -Dexec.mainClass="com.github.vspiewak.temporal._1.HelloWorker"

    # start a workflow execution
    temporal workflow start --type HelloWorkflow --task-queue hello-task-queue --workflow-id my-first-workflow --input '"Vincent"'

    # show the workflow execution
    temporal workflow show --workflow-id my-first-workflow


    #
    # case 2
    #
    
    # start the worker
    ./mvnw exec:java -Dexec.mainClass="com.github.vspiewak.temporal._1.HelloWorker"

    # start a workflow execution
    ./mvnw exec:java -Dexec.mainClass="com.github.vspiewak.temporal._2.StartWorkflow" -Dexec.args="'Vincent'"


    #
    # case 3
    #
    
    # start the worker
    ./mvnw exec:java -Dexec.mainClass="com.github.vspiewak.temporal._1.HelloWorker"

    # start a schedule workflow execution
    ./mvnw exec:java -Dexec.mainClass="com.github.vspiewak.temporal._3.StartScheduleWorkflow"


    #
    # case 4
    #

    # start the worker
    ./mvnw exec:java -Dexec.mainClass="com.github.vspiewak.temporal._4.OrderWorker"

    # start a workflow execution
    temporal workflow start --type OrderWorkflow --workflow-id my-order-workflow --task-queue order-task-queue

    
    #
    # case 5
    #

    # start the worker
    ./mvnw exec:java -Dexec.mainClass="com.github.vspiewak.temporal._5.RetryWorker"

    # start a workflow execution
    temporal workflow start --type RetryWorkflow --workflow-id my-retry-workflow --task-queue retry-task-queue


    #
    # case 6
    #
    
    # start the worker
    ./mvnw exec:java -Dexec.mainClass="com.github.vspiewak.temporal._6.SleepyWorker"

    # start a workflow execution
    temporal workflow start --type SleepyWorkflow --workflow-id my-sleepy-workflow --task-queue sleepy-task-queue
    

    #
    # case 7
    #

    # start the worker
    ./mvnw exec:java -Dexec.mainClass="com.github.vspiewak.temporal._7.SignalWorker"

    # start a workflow execution
    temporal workflow start --type SignalWorkflow --workflow-id my-signal-workflow --task-queue sleepy-task-queue
    
    # send a signal using temporal cli
    temporal workflow signal --name "my-signal"  -i '{ "value":"hello-signal", "count": 1}' --workflow-id "my-signal-workflow"

    # ... or with SDK
    ./mvnw exec:java -Dexec.mainClass="com.github.vspiewak.temporal._7.SignalSender"
