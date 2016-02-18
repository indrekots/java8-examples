package ee.indrek.collector;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;
import static java.util.stream.Collector.Characteristics.UNORDERED;

public class HistogramCollector implements Collector<Double, Map<Integer, Integer>, Map<Integer, Integer>> {

    private int bucketSize;

    public HistogramCollector(int bucketSize) {
        this.bucketSize = bucketSize;
    }

    @Override
    public Supplier<Map<Integer, Integer>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<Integer, Integer>, Double> accumulator() {
        return (map, val) -> map.merge((int)(val / bucketSize), 1,
                (a, b) -> a + 1);
    }

    @Override
    public BinaryOperator<Map<Integer, Integer>> combiner() {
        return (map1, map2) -> {
            map2.forEach((k, v) -> map1.merge(k, v, (v1, v2) -> v1++));
            return map1;
        };
    }

    @Override
    public Function<Map<Integer, Integer>, Map<Integer, Integer>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(IDENTITY_FINISH, UNORDERED);
    }

    public static HistogramCollector toHistogram(int bucketSize) {
        return new HistogramCollector(bucketSize);
    }
}
