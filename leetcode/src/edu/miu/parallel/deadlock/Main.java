package edu.miu.parallel.deadlock;
/*
* A deadlock is a situation where a thread T1 holds a key needed by a thread T2, and T2 holds the key needed by T1
* */

public class Main {
    public static void main(String[] args) throws InterruptedException {
        A a= new A();

        Runnable runnable1= ()->a.a();
        Runnable runnable2=()->a.b();

        Thread thread1= new Thread(runnable1);
        Thread thread2= new Thread(runnable2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();


    }
}

class A {
    private Object key1 = new Object();
    private Object key2 = new Object();


    void a() {
        synchronized (key1) {
            System.out.println("A a");
            b();
        }

    }

    void b() {
        synchronized (key2) {
            System.out.println("A b");
            c();
        }
    }

    void c() {
        synchronized (key1) {
            System.out.println("A c");
        }
    }
}
