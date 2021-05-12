package edu.miu.stringman;

public class Main {


    public static void main(String[] args) {

     //   System.out.println(reverseString("string"));

        System.out.println(reverseRecursively("string"));

    }

    public static String reverseString(String str){

        return new StringBuilder(str).reverse().toString();
    }

    public static String reverseRecursively(String string){
        if(string.isEmpty())
            return "";

        return reverseString(string.substring(1))+ string.charAt(0);
    }
}
