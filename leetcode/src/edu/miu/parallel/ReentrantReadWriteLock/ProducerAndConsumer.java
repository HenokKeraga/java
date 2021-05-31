package edu.miu.parallel.ReentrantReadWriteLock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ProducerAndConsumer {

    public static void main(String[] args) {
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        List<Integer> buffer = new ArrayList<>();

        Lock readLock= readWriteLock.readLock();
        Lock writeLock= readWriteLock.writeLock();

         class Consumer implements Callable<String>{

             @Override
             public String call() throws Exception {

                 readLock.lock();
                 try {
                     while (buffer.size()>0){
                         buffer.remove(buffer.size()-1);
                         System.out.print("consumer " +buffer.size());
                         Thread.sleep(1000);
                     }

                 }finally {
                     readLock.unlock();
                 }

                 return "consumer" +buffer.size();
             }
         }
         class Producer implements Callable<String>{

             @Override
             public String call() throws  Exception {

                 writeLock.lock();
                 try {
                     while (buffer.size()<10){
                         buffer.add(new Random().nextInt());
                         System.out.print("producer " +buffer.size());
                         Thread.sleep(1000);
                     }

                 }finally {
                     writeLock.unlock();
                 }
                 return "producer" +buffer.size();
             }
         }


        ExecutorService service= Executors.newFixedThreadPool(8);


         try {

                 service.submit(new Producer());
                 service.submit(new Consumer());
                 service.submit(new Consumer());
                 service.submit(new Consumer());
                 service.submit(new Consumer());
                 service.submit(new Consumer());



         } finally {
             service.shutdown();
         }








    }
}
