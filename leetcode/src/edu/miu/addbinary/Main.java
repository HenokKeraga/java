package edu.miu.addbinary;

public class Main {
    public static void main(String[] args) {
        System.out.println(addBinary("11","1"));
    }

    public static String addBinary(String a, String b) {

        String result="";
        int la=a.length()-1;
        int lb=b.length()-1;
        int carry=0;
        int total;

        while(la>=0 || lb>=0){
            total=carry;
            if(la>=0){
                total+=Integer.valueOf( new StringBuilder().append(a.charAt(la)).toString());
                la--;
            }
            if(lb>=0){
                total+=Integer.valueOf(new StringBuilder().append(b.charAt(lb)).toString());
                lb--;
            }

            result=total%2+result;
            carry=total/2;


        }

        if(carry==1)
            result="1"+result;



        return result;

    }
}
