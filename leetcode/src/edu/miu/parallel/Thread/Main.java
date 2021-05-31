package edu.miu.parallel.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        ExecutorService service= Executors.newFixedThreadPool(4);

        try {
            service.submit((Runnable) new Test());
            service.submit((Callable) new Test());

        }finally {
            service.shutdown();
        }

        //new Thread( new Test()).start();

    }
}

class Test implements Runnable, Callable<Integer>{

    @Override
    public void run() {
        System.out.println("run method");
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("call mehod");
        return 0;
    }
}
