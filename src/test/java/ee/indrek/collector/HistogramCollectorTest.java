package ee.indrek.collector;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static ee.indrek.collector.HistogramCollector.toHistogram;
import static org.junit.Assert.assertEquals;

public class HistogramCollectorTest {

    @Test
    public void histogramCollectTest() throws Exception {
        List<Double> numbers = Arrays.asList(1.0, 1.1, 1.4, 1.7, 1.4, 5.4, 9.9);
        Map<Integer, Integer> histogram = numbers.stream().collect(toHistogram(1));

        ImmutableMap<Integer, Integer> expected = ImmutableMap.<Integer, Integer>builder().
                put(1, 5).put(5, 1).put(9, 1).build();

        assertEquals(expected, histogram);
    }
}