package edu.miu.Palindrome;

public class Main {

    public static void main(String[] args) {

        String s="A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));

    }

    public static boolean isPalindrome(String s) {

        StringBuilder sb= new StringBuilder();

        for(int i=0;i<s.length();i++){
            if(Character.isLetterOrDigit(s.charAt(i)))
                sb.append(s.charAt(i));

        }
        s=sb.toString().toLowerCase();
        if(s.length()<2)
            return true;
        System.out.println(s.length());

        int mid=s.length()/2;
        int begin=0;
        int end=0;

        if(s.length()%2==0){
            begin=mid-1;
            end=mid ;

        }else{
            begin=mid;
            end=mid ;

        }



        while(begin>=0 && end<s.length()&&s.charAt(begin)==s.charAt(end) ){

            begin--;
            end++;
        }
        System.out.println(begin);
        System.out.println(end);
        if(begin==-1&&end==s.length())
            return true;



        return false;
    }
}
