package com.nimesa.careers.multithreading_assignment;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Processor {


    public List<TaskResponse> execute(List<TaskRequest> taskRequest) throws InterruptedException {
        List<TaskResponse> taskResponses = new ArrayList<>();
        for (TaskRequest request : taskRequest) {
            taskResponses.add(execute(request));
        }
        return taskResponses;
    }

    public TaskResponse execute(TaskRequest taskRequest) throws InterruptedException {
        System.out.println("Starting Task " + taskRequest.getId());
        Task task = new Task(taskRequest);
        TaskResponse response = task.run();
        System.out.println("Completed Task " + response.getId() + "With Status " + response.getStatus());
        return response;
    }
}
