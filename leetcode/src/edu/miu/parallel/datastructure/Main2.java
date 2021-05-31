package edu.miu.parallel.datastructure;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

public class Main2 {
    static int n=0;
    static AtomicInteger n1= new AtomicInteger();
    static LongAdder n2= new LongAdder();
    public static void main(String[] args) {

        IntStream.range(1,100).parallel().map(i->{n++; return i;}).sum();
        IntStream.range(1,100).parallel().map(i->{n1.incrementAndGet(); return i;}).sum();
        IntStream.range(1,100).parallel().map(i->{n2.increment(); return i;}).sum();

        System.out.println(n);
        System.out.println(n1);
        System.out.println(n2.sum());
    }
}
