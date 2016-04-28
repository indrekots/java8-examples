package ee.indrek.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

import static ee.indrek.concurrency.ConcurrencyUtils.delay;

public class FutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

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
}
