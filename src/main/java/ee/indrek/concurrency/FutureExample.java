package ee.indrek.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class FutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Future<String> result = executorService.submit(() -> {
            delay(5000); //simulate network call
            return "{\"result\":\"success\"}";
        });

        IntStream.range(1, 10).forEach(i -> {
            delay(100);
            System.out.println("Doing useful work");
        });
        System.out.println(result.get());
    }

    public static void delay(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
