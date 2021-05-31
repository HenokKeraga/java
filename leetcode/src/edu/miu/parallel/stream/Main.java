package edu.miu.parallel.stream;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //1
        List<Integer> list = List.of(1,2,3,4,5);
        int sum=list.stream().mapToInt(i->i).sum();
        System.out.println(sum);

        //2
        int sum2=IntStream.range(0,10).map(i->{
            System.out.println(i);
            return i;
        }).sum();
        System.out.println(sum2);

        //integration
//        int a = 0,b = 0,n = 0;
//        double w=(b-a)/n;
//        double result=IntStream.range(1,n).asDoubleStream().parallel().map(i->f(a+i*w)).sum();
//        double answer= w*(result+f(a)+f(b))/2.0;
//        //numerical summarization ch8 mastering ch8
//        System.out.println(answer);

        Stream res=Stream.of(1,2,3).filter(i->i==2);
        System.out.println(res.findAny().get());
        System.out.println(res.findAny());


    }

    private static double f(double v) {
        return 0.0;
    }
}
