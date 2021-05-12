package edu.miu.addbinary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main2 {

    public static void main(String[] args) {
        // A1[ 3 5 6 7], A2[2 1 5 7], A3[8 9 0 5]  ==> R[5]
        //common element

        List<Integer> A= Arrays.asList(3,5,6,7);
        List<Integer> B= Arrays.asList(2,1,5,7);
        List<Integer> C= Arrays.asList(8,9,0,5);


       List<Integer> result= A.stream().filter(d->B.contains(d)&&C.contains(d)).collect(Collectors.toList());

        System.out.println(result);
    }

}
