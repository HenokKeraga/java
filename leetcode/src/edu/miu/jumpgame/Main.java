package edu.miu.jumpgame;

public class Main {

    public static void main(String[] args) {
        int[] a={8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5};


        int[]b={2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6};
        System.out.println(canJump(a));
        System.out.println(canJump1(b));
    }
    public  static boolean canJump1(int[] nums) {
       int lastPosition=nums.length-1;
       for (int i=nums.length-2;i>=0;i--){
           if(nums[i]>=lastPosition-i)
               lastPosition=i;
       }

        return lastPosition==0;
    }
    public  static boolean canJump(int[] nums) {

        boolean result=false;
        for(int i=0;i<nums.length;i++){
            result = result || makeJump(false,nums,i,0);
        }
        return result;
    }

    public static boolean makeJump(boolean yes,int[] nums,int k,int sum){
        System.out.println("sum  "+ sum);
        if(sum>nums.length-1 || k>=nums.length){
            System.out.println("A");
            return yes ;
        }

        if(sum==nums.length-1||yes){
            System.out.println("B");
            return true;
        }


            for(int j=1;j<=nums[k];j++){
                System.out.println( nums[k] +" : "+j);
                yes=makeJump(yes,nums,k+j,j+sum);
            }

        return yes;
    }
}
