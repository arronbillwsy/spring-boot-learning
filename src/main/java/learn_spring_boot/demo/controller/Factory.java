package learn_spring_boot.demo.controller;


import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class Factory {

    private static ExecutorService factory = Executors.newFixedThreadPool(30);

    public static void submit(TrainingTask task){
        factory.submit(task);
    }

}
