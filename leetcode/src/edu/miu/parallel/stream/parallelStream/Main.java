package edu.miu.parallel.stream.parallelStream;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Stream.of(1,2,3,4,5,6,7,8,9).parallel().forEach(n->System.out.println(Thread.currentThread().getName()+"  "+n));
    }
}
