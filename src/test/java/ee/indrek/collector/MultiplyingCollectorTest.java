package ee.indrek.collector;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MultiplyingCollectorTest {

    @Test
    public void multiplyCollect() throws Exception {
        List<Integer> numbers = Arrays.asList(1, 1, 1, 2, 3, 4, 4, 5, 5, 5);
        Map<Integer, Integer> histogram = numbers.stream().collect(new HistogramCollector());
        assertEquals(null, histogram);
    }
}