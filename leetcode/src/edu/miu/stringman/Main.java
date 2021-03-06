package edu.miu.stringman;

public class Main {


    public static void main(String[] args) {

        System.out.println(reverseString("string"));

    }

    public static String reverseString(String str){

        return new StringBuilder(str).reverse().toString();
    }
}
