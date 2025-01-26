import java.util.Random;
import java.util.concurrent.*;

public class MatrixMultiplication {

    private static final int N = 1000; // Size of the matrices
    private static int[][] A;
    private static int[][] B;
    private static int[][] C;

    private static void initializeMatrix(int[][] matrix) {
        Random rand = new Random();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = rand.nextInt(11); // Random number between 0 and 10
            }
        }
    }

    static class MultiplicationTask implements Runnable {
        private final int rowStart;
        private final int rowEnd;

        MultiplicationTask(int rowStart, int rowEnd) {
            this.rowStart = rowStart;
            this.rowEnd = rowEnd;
        }

        @Override
        public void run() {
            for (int i = rowStart; i < rowEnd; i++) {
                for (int j = 0; j < N; j++) {
                    C[i][j] = 0;
                    for (int k = 0; k < N; k++) {
                        C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        if (args.length != 1) {
            System.out.println("Usage: java MatrixMultiplication <number_of_threads>");
            return;
        }

        int numThreads = Integer.parseInt(args[0]);
        A = new int[N][N];
        B = new int[N][N];
        C = new int[N][N];

        // Initialize matrices A and B with random values
        initializeMatrix(A);
        initializeMatrix(B);

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        int rowsPerThread = N / numThreads;
        int remainingRows = N % numThreads;

        int rowStart = 0;
        long startTime = System.nanoTime();
        for (int i = 0; i < numThreads; i++) {
            int rowEnd = rowStart + rowsPerThread + (i < remainingRows ? 1 : 0);
            executor.execute(new MultiplicationTask(rowStart, rowEnd));
            rowStart = rowEnd;
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);
        // Record end time
        long endTime = System.nanoTime();
        double executionTimeMillis = (endTime - startTime) / 1000000.0;

        System.out.println("Matrix multiplication completed.");
        System.out.println("Execution time: " + executionTimeMillis + " milliseconds");
    }
}