import java.util.concurrent.*;

public class ExecutorServiceExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Result result = new Result();

        // 'Executor': object that executes submitted Runnable tasks
        // 'ExecutorService': An Executor that provides methods to manage termination and methods that can produce a Future
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10000; i++) {
            // 1. Submits a Runnable task
            // 2. returns a Future representing that task
            Future<Integer> y = executorService.submit(() -> result.left++);
            Future<Integer> z = executorService.submit(() -> result.right++);

            for (; y.isDone() == false || z.isDone() == false; ) ;    // 이게 thread join 역할

        }

        // allow previously submitted tasks to execute before terminating
        executorService.shutdown();

        // for(;executorService.isTerminated() == false;);

        System.out.println(result);

    }

    private static class Result {
        private int left, right;

        public String toString() {
            return left + " " + right;
        }
    }
}