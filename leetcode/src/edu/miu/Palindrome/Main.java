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
        System.out.println(s);

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



        while(begin>0 && end<s.length()&&s.charAt(begin)==s.charAt(end) ){

            begin--;
            end++;
        }
        System.out.println(begin);
        System.out.println(end);
        if(begin==0&&end==s.length()-1)
            return true;



        return false;
    }
}
