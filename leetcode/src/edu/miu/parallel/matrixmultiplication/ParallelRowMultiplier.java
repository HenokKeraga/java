package edu.miu.parallel.matrixmultiplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParallelRowMultiplier {

    public static void main(String[] args) {

        double matrix1[][] = MatrixGenerator.generate(2000, 2000);
        double matrix2[][] = MatrixGenerator.generate(2000, 2000);
        double parallelRowMultiplier[][]= new double[matrix1.length][matrix2[0].length];
        Date start=new Date();
        ParallelRowMultiplier.multiply(matrix1, matrix2, parallelRowMultiplier);
        Date end=new Date();
        System.out.printf("Serial: %d%n",end.getTime()-start.getTime());
    }



    public static void multiply(double[][] matrix1, double[][] matrix2, double[][] result) {
        List<Thread> threads = new ArrayList<>();
        int rows1 = matrix1.length;
        for (int i = 0; i < rows1; i++) {
            RowMultiplierTask task = new RowMultiplierTask(result,matrix1,matrix2,i);
                    Thread thread = new Thread(task);
                  thread.start(); threads.add(thread);
            if (threads.size() % 10 == 0) {
                waitForThreads(threads);
            }
        }
    }
    private static void waitForThreads(List<Thread> threads){
        for (Thread thread : threads) {
            try { thread.join();
            } catch (InterruptedException e) { e.printStackTrace();
            }
        }
        threads.clear();
    }

}
class RowMultiplierTask implements Runnable {
    private final double[][] result;
    private final double[][] matrix1;
    private final double[][] matrix2;
    private final int row;
    public RowMultiplierTask(double[][] result, double[][] matrix1, double[][] matrix2, int i) {
        this.result = result;
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.row = i;
    }
    @Override
    public void run() {
        for (int j = 0; j < matrix2[0].length; j++) {
            result[row][j] = 0;
            for (int k = 0; k < matrix1[row].length; k++) {
                result[row][j] += matrix1[row][k] * matrix2[k][j];
            }
        }

    }
}
