package ee.indrek.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;

public class ForkJoinExample {
    public static void main(String[] args) {
        long[] numbers = LongStream.rangeClosed(1, 10000).toArray();
        LongSum multiplier = new LongSum(numbers, 0, numbers.length);
        Long result = new ForkJoinPool().invoke(multiplier);
        System.out.println(result);
    }
}
