package ee.indrek.forkjoin;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class IntegerMultiplier extends RecursiveTask<Integer> {

    private static final int LIMIT = 1000;

    private int[] numbers;
    private int start;
    private int end;

    public IntegerMultiplier(int[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (start - end <= LIMIT) {
            return computeSequentially();
        }

        IntegerMultiplier left = new IntegerMultiplier(numbers, start, end/2);
        left.fork();

        IntegerMultiplier right = new IntegerMultiplier(numbers, start + end/2, end);
        Integer rightResult = right.compute();
        Integer leftResult = left.join();
        return leftResult + rightResult;
    }

    private Integer computeSequentially() {
        return Arrays.stream(numbers).reduce(1, (a, b) -> a * b);
    }
}
