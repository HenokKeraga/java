package edu.miu.Palindrome;

public class MainTwo {

    static  int resultStart=0;
    static  int resultLength=0;

    public static void main(String[] args) {

        String s="babad";

        System.out.println(longestPalindrome(s));


    }

    public static  String longestPalindrome(String s) {


        for(int start=0;start<s.length();start++){

            checkPalindorom(s,start,start);
            checkPalindorom(s,start,start+1);

        }


        return s.substring(resultStart,resultStart+resultLength);

    }

    public static void checkPalindorom(String s,int start,int end ){

        while(start>=0&& end<s.length()&& s.charAt(start)==s.charAt(end)){

            start--;
            end++;
        }

        if(resultLength< end-start-1){

            resultStart=start+1;
            resultLength=end-start-1;
            System.out.println(resultStart);
            System.out.println(resultLength);

        }




    }


}
