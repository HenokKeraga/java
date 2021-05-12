package edu.miu.parallel.racecondtion;
/*
*   It means that two different threads are trying to read and write the same variable at the same time This is called a race condition
* */

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WrapperLong aLong = new WrapperLong(0L);
        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++)
                aLong.incrementValue();
        };

        Thread[] threads = new Thread[1000];

        for (int i = 0; i < 1000; i++) {
            threads[i] = new Thread(runnable);
            threads[i].start();
        }

        for (int i = 0; i < 1000; i++) {
            threads[i].join();
        }

        System.out.println(" the value is =" + aLong.getValue());
    }

}

class WrapperLong {

    private Object object= new Object();
    private long l;

    public WrapperLong(long l) {
        this.l = l;
    }

    public long getValue() {
        return l;
    }

    public void incrementValue() {
        synchronized (object){
            l = l + 1;
        }

    }
}
