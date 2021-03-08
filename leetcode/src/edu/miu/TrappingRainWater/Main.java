package edu.miu.TrappingRainWater;

public class Main {
    public static void main(String[] args) {

    int[] a={  0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(trap(a));


    }

    public static int trap(int[] height) {

        int sum=0;
        int leftMax=0;
        int rightMax=0;

        for(int i=1;i<height.length-1;i++){

            leftMax=height[i];

            for(int j=0;j<i;j++){
                leftMax=Math.max(leftMax,height[j]);
            }

            rightMax=height[i];
            for(int j=i;j<height.length;j++){
                rightMax=Math.max(rightMax,height[j]);
            }

            sum+=Math.min(leftMax,rightMax)-height[i];

        }

        return sum;

    }
}
