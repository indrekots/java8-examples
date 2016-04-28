package ee.indrek.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

import static ee.indrek.concurrency.ConcurrencyUtils.delay;

public class SimpleCompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<String> future = getResultOverNetwork();

        IntStream.range(1, 10).forEach(i -> {
            delay(100);
            System.out.println("Doing useful work");
        });
        System.out.println(future.get());
    }

    private static Future<String> getResultOverNetwork() {
        CompletableFuture<String> future = new CompletableFuture<>();
        new Thread(() -> {
            delay(5000);
            future.complete("{\"result\":\"success\"}");
        }).start();
        return future;
    }
}
