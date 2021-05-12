package edu.miu.parallel.histogram;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main1 {
    static  int n=2000;
    static int max=10;
    static int image[][]=new int[n][n];

    static int hist[] = new int [max+1];


    public static void main(String[] args) {
        fillArray();
        Runnable top = new Scan_Array(image,hist,0,n/2);
        Thread threadTop= new Thread(top);

        Runnable bot= new Scan_Array(image,hist,n/2,n);
        Thread threadBot= new Thread(bot);
        Scan_Array.initLocks();
        threadTop.start();
        threadBot.start();

        try {
            threadTop.join();
            threadBot.join();

        }catch (InterruptedException e){

        }

        System.out.println(Arrays.toString(hist));


    }

   static void fillArray() {
       Random rand = new Random();
        for (int i=0;i<image.length;i++){
            for(int j=0;j<image[i].length;j++){
                image[i][j]=rand.nextInt(10)+1;
            }
        }
   }
}

class Scan_Array implements Runnable{
    int start;
    int end;
    int image[][];
    int hist[];
    static Lock[] L= new ReentrantLock[11];

    public Scan_Array( int[][] image, int[] hist,int start, int end) {
        this.start = start;
        this.end = end;
        this.image = image;
        this.hist = hist;
    }

    @Override
    public void run() {
        for (int i=start;i<end;i++){
            for (int j=0,intensity;j<hist.length;j++){
                intensity=image[i][j];
                L[intensity].lock();
                hist[intensity]++;
                L[intensity].unlock();
            }
        }

    }
    public static void initLocks(){

        for (int i=0;i<L.length;i++){
            L[i]= new ReentrantLock();
        }

    }
}
