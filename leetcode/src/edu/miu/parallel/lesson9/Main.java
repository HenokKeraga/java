package edu.miu.parallel.lesson9;
import java.util.concurrent.*;

public class Main {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int n = Runtime.getRuntime().availableProcessors();
        System.out.println(n);
        ExecutorService service = Executors.newFixedThreadPool(n);
        try {
            int until=100;

            Runnable task1 = new Task(100);
            Runnable task2 = () -> {
                int sum = 0;
                for (int i = 0; i < until; i++) {
                    sum += i;
                }
                System.out.println(sum);
            };
            service.execute(task1);
            service.execute(task2);

        } finally {
            if(service!=null)
            service.shutdown();
        }
        service = Executors.newFixedThreadPool(n);

        Callable<Integer> callable=()->123;
        Future<Integer> future=service.submit(callable);

        System.out.println(future.get());
    }
}

class Task implements Runnable {

    private final int until;

    Task(int until) {
        this.until = until;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int i = 0; i < until; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}

