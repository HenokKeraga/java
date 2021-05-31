package edu.miu.parallel.ReentrantReadWriteLock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class Main2 {
    static final int READER_SIZE = 8;
    static final int WRITER_SIZE = 2;

    public static void main(String[] args) {
        ReadWriteList<Integer> db= new ReadWriteList<>();

        ExecutorService service= Executors.newFixedThreadPool(12);
        try {
            for (int i=0;i<WRITER_SIZE;i++){

                service.submit(new Write(db));

            }
            for (int i=0;i<READER_SIZE;i++){
                service.submit(new Read(db));
            }
        }finally {
            service.shutdown();
        }


    }
}

class Write implements Runnable {
    private ReadWriteList<Integer> list =  new ReadWriteList<>();

    public Write(ReadWriteList<Integer> list){
        this.list=list;
    }

    public void run(){
        list.add(new Random().nextInt()%1000);
        System.out.println("Writer list size " +list.size());
    }
}
class Read implements Runnable {
    private ReadWriteList<Integer> list =  new ReadWriteList<>();

    public Read(ReadWriteList<Integer> list){
        this.list=list;
    }
    public void run (){
        System.out.println("reader :"+ list.get(list.size()-1));
    }
}

class ReadWriteList<E> {
    private List<E> list = new ArrayList<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock readLock = readWriteLock.readLock();
    private Lock writeLock = readWriteLock.writeLock();

    public void add(E element) {
        writeLock.lock();
        try {
            list.add(element);
        }finally {
            writeLock.unlock();
        }

    }

    public E get(int index) {

        readLock.lock();
        try {
            return list.get(index);
        }finally {
            readLock.unlock();
        }

    }

    public int size() {
        readLock.lock();
        try {
            return list.size();
        }finally {
            readLock.unlock();
        }

    }

}
