package edu.miu.parallel.matrixmultiplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParallelGroupMultiplier {

    public static void main(String[] args) {

        double matrix1[][] = MatrixGenerator.generate(2000, 2000);
        double matrix2[][] = MatrixGenerator.generate(2000, 2000);
        double parallelGroupMultiplier[][] = new double[matrix1.length][matrix2[0].length];
        Date start = new Date();
        ParallelGroupMultiplier.multiply(matrix1, matrix2, parallelGroupMultiplier);
        Date end = new Date();
        System.out.printf("Serial: %d%n", end.getTime() - start.getTime());
    }

    public static void multiply(double[][] matrix1, double[][] matrix2, double[][] result) {
        List<Thread> threads = new ArrayList<>();
        int rows1 = matrix1.length;
        int numThreads = Runtime.getRuntime().availableProcessors();
        int startIndex, endIndex, step;
        step = rows1 / numThreads;
        startIndex = 0;
        endIndex = step;
        for (int i = 0; i < numThreads; i++) {
            GroupMultiplierTask task = new GroupMultiplierTask(result, matrix1, matrix2, startIndex, endIndex);
            Thread thread = new Thread(task);
            thread.start();
            threads.add(thread);
            startIndex = endIndex;
            endIndex = i == numThreads - 2 ? rows1 : endIndex + step;
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}


class GroupMultiplierTask implements Runnable {
    private final double[][] result;
    private final double[][] matrix1;
    private final double[][] matrix2;
    private final int startIndex;
    private final int endIndex;

    public GroupMultiplierTask(double[][] result, double[][] matrix1, double[][] matrix2, int startIndex, int endIndex) {
        this.result = result;
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.startIndex = startIndex;
        this.endIndex = endIndex;

    }

    @Override
    public void run() {

        for (int i = startIndex; i < endIndex; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                result[i][j] = 0;
                for (int k = 0; k < matrix1[i].length; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
    }
}
