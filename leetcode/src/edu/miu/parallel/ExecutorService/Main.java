package edu.miu.parallel.ExecutorService;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(4);

        Callable<Integer> r = () -> {
            System.out.println("):");
            return 1;
        };
        Future future = service.submit(r);

        System.out.println(future.get());
        System.out.println(future.isDone());
        service.shutdown();
    }
}
