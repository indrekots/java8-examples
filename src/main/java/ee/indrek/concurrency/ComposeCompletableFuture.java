package ee.indrek.concurrency;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

import static ee.indrek.concurrency.ConcurrencyUtils.delay;
import static java.util.concurrent.CompletableFuture.supplyAsync;

public class ComposeCompletableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //thenApplyExample();
        composeMultiple();
    }

    private static void composeMultiple() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = supplyAsync(ComposeCompletableFuture::getFruits).
                thenCombine(supplyAsync(ComposeCompletableFuture::getVeggies),
                (fruits, veggies) -> Stream.concat(Arrays.stream(fruits), Arrays.stream(veggies))
        ).thenAccept(items -> items.forEach(System.out::println));
        future.join();
    }

    private static String[] getVeggies() {
        System.out.println("getting veggies...");
        delay(2000);
        System.out.println("completed veggies");
        return new String[]{"broccoli", "brussels sprout"};
    }

    private static String[] getFruits() {
        System.out.println("getting fruits...");
        delay(1500);
        System.out.println("completed fruits");
        return new String[]{"apple", "apricot", "banana"};
    }

    private static void thenApplyExample() throws InterruptedException, ExecutionException {
        CompletableFuture<Integer> future = supplyAsync(() -> 4 + 3)
                .thenApply(i -> i*2);
        System.out.println(future.get());
    }
}
