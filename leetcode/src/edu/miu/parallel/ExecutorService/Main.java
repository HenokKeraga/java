package edu.miu.parallel.ExecutorService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(4);

        Runnable r=()-> System.out.println("):");
        Future future=service.submit(r);

        System.out.println(future.get());
        System.out.println(future.isDone());
        service.shutdown();
    }
}
