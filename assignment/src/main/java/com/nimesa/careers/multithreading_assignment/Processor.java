package com.nimesa.careers.multithreading_assignment;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.Function;

public class Processor {

    private final Queue<TaskRequest> queue = new LinkedBlockingQueue<>();


    Processor(TaskRequest taskRequest) {
        queue.offer(taskRequest);
    }

    Processor(List<TaskRequest> taskRequest) {
        for (TaskRequest request : taskRequest) {
            queue.offer(request);

        }
    }

    public List<TaskResponse> execute() throws InterruptedException {

        /**
         *Sequential execution
         */
        List<TaskResponse> taskResponses = new ArrayList<>();
        for (TaskRequest taskRequest : queue) {
            System.out.println("Starting Task "+taskRequest.getId());
            Task task = new Task(taskRequest);
            TaskResponse response = task.run();
            System.out.println("Completed Task "+response.getId() +"With Status"+response.getStatus());
            taskResponses.add(response);
        }
        return taskResponses;
    }
}
