package edu.miu.parallel.matrixmultiplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ParallelIndividualMultiplier {

    public static void main(String[] args) {

        double matrix1[][] = MatrixGenerator.generate(2000, 2000);
        double matrix2[][] = MatrixGenerator.generate(2000, 2000);
        double parallelIndividualMultiplier[][]= new double[matrix1.length][matrix2[0].length];
        Date start=new Date();
        ParallelIndividualMultiplier.multiply(matrix1, matrix2, parallelIndividualMultiplier);
        Date end=new Date();
        System.out.printf("Serial: %d%n",end.getTime()-start.getTime());
    }



    public static void multiply(double[][] matrix1, double[][] matrix2, double[][] result) {
        List<Thread> threads=new ArrayList<>();
        int rows1=matrix1.length;
        int rows2=matrix2.length;
        for (int i=0; i<rows1; i++) {
            for (int j=0; j<matrix2[i].length; j++) {
                IndividualMultiplierTask task=new IndividualMultiplierTask(result, matrix1, matrix2, i, j);
                Thread thread=new Thread(task);
                thread.start();
                threads.add(thread);
                if (threads.size() % 12 == 0) {
                    waitForThreads(threads);
                }
            }
        }
    }
    private static void waitForThreads(List<Thread> threads){
        for (Thread thread: threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        threads.clear();
    }
}

class IndividualMultiplierTask implements Runnable {
    private final double[][] result;
    private final double[][] matrix1;
    private final double[][] matrix2;
    private final int row;
    private final int column;
    public IndividualMultiplierTask(double[][] result, double[][] matrix1, double[][] matrix2,int i,int j){
    this.result = result;
    this.matrix1 = matrix1;
    this.matrix2 = matrix2;
    this.row = i;
    this.column = j;
}
    @Override
    public void run() {
        result[row][column] = 0;
        for (int k = 0; k < matrix1[row].length; k++) {
            result[row][column] += matrix1[row][k] * matrix2[k][column];
        }
    }
}

