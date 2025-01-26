import java.util.concurrent.*;

public class SimpsonIntegration {

    private static double function(double x) {
        return (1 / Math.sqrt(2 * Math.PI)) * Math.exp(-x * x / 2);
    }

    private static double simpson(double a, double b, int n) {
        double h = (b - a) / n;
        double sum = function(a) + function(b);

        for (int i = 1; i < n; i += 2) {
            sum += 4 * function(a + i * h);
        }
        for (int i = 2; i < n - 1; i += 2) {
            sum += 2 * function(a + i * h);
        }

        return sum * h / 3;
    }

    static class IntegrationTask implements Callable<Double> {
        private final double a;
        private final double b;
        private final int n;

        IntegrationTask(double a, double b, int n) {
            this.a = a;
            this.b = b;
            this.n = n;
        }

        @Override
        public Double call() {
            return simpson(a, b, n);
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        if (args.length != 1) {
            System.out.println("Usage: java SimpsonIntegration <number_of_threads>");
            return;
        }

        int numThreads = Integer.parseInt(args[0]);
        double a = -1;
        double b = 1;
        int totalPoints = 3603600;
        int pointsPerThread = totalPoints / numThreads;
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        @SuppressWarnings("unchecked")
        Future<Double>[] results = (Future<Double>[]) new Future<?>[numThreads];

        double intervalWidth = (b - a) / numThreads;

        // Record start time
        long startTime = System.nanoTime();

        for (int i = 0; i < numThreads; i++) {
            double start = a + i * intervalWidth;
            double end = start + intervalWidth;
            results[i] = executor.submit(new IntegrationTask(start, end, pointsPerThread));
        }

        double total = 0;
        for (int i = 0; i < numThreads; i++) {
            total += results[i].get();
        }

        executor.shutdown();

        // Record end time
        long endTime = System.nanoTime();
        double executionTimeMillis = (endTime - startTime) / 1_000_000.0;

        System.out.println("Integral value: " + total);
        System.out.println("Execution time: " + executionTimeMillis + " milliseconds");
    }
}
