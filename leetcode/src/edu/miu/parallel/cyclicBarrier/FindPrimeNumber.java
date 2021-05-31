package edu.miu.parallel.cyclicBarrier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class FindPrimeNumber {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 1 to 1000 prime number
        List<Integer> input = new ArrayList<>();

        List<List<Integer>> lists= new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            input.add(i);
        }
        ExecutorService service = Executors.newFixedThreadPool(5);

        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new PrimeGrouper(lists));
        try {
            for (int i = 0; i < 5; i++) {
                Worker worker = new Worker(input, cyclicBarrier,lists,i*200,i*200+200);
              service.submit(worker);
            };

        } finally {
            service.shutdown();
        }

    }
}
class Worker implements Runnable {
    private List<Integer> input;
    private CyclicBarrier barrier;
    private List<List<Integer>> list;
    private int start;
    private int end;

    public Worker(List<Integer> input, CyclicBarrier barrier,List<List<Integer>> list,int start ,int end) {
        this.input = input;
        this.barrier = barrier;
        this.list=list;
        this.start=start;
        this.end=end;
    }

    @Override
    public void run() {
        System.out.println("workers");

        Predicate<Integer> checkDivision = (number) -> {
            for (int i = 2; i < number; i++) {
                if (number % 2 == 0)
                    return false;
            }
            return true;
        };
        System.out.println("from = "+start +" to = "+end);
        List<Integer> result = input.stream().skip(start).limit(end).filter(checkDivision).collect(Collectors.toList());
        try {
            list.add(result);
            barrier.await();
            System.out.println("After  barrier.await();");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

}

class PrimeGrouper implements Runnable {
    private List<List<Integer>> result;


    public PrimeGrouper(List<List<Integer>> result) {
        this.result = result;
    }

    @Override
    public void run() {
        List<Integer> output= new ArrayList<>();


        for (int i=0;i<result.size();i++){

                List<Integer> result2=result.get(i);
                for (int j=0;j<result2.size();j++){
                    output.add(result2.get(j));
                }

        }
        Collections.sort(output);
        System.out.println(output);
    }
}


