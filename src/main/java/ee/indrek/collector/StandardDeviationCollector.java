package ee.indrek.collector;

import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class StandardDeviationCollector<T> implements Collector<T, List<Double>, Double> {
    @Override
    public Supplier<List<Double>> supplier() {
        return null;
    }

    @Override
    public BiConsumer<List<Double>, T> accumulator() {
        return null;
    }

    @Override
    public BinaryOperator<List<Double>> combiner() {
        return null;
    }

    @Override
    public Function<List<Double>, Double> finisher() {
        return null;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return null;
    }
}
