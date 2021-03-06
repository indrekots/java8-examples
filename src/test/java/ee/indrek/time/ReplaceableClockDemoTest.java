package ee.indrek.time;

import org.junit.Test;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ReplaceableClockDemoTest {

    @Test
    public void shouldBeBeforeStPatricksDay2017() throws Exception {
        Clock now = Clock.fixed(LocalDateTime.of(2017, 2, 15, 12, 34)
                .toInstant(ZoneOffset.UTC), ZoneId.of("UTC"));
        LocalDateTime stPatricksDay = LocalDateTime.of(2017, 3, 17, 0, 0);
        ReplaceableClockDemo demo = new ReplaceableClockDemo(now);
        assertTrue(demo.isNowBefore(stPatricksDay));
    }

    @Test
    public void shouldNotBeBeforePiDay2017() throws Exception {
        Clock now = Clock.fixed(LocalDateTime.of(2017, 5, 18, 9, 45)
                .toInstant(ZoneOffset.UTC), ZoneId.of("UTC"));
        LocalDateTime piDay = LocalDateTime.of(2017, 3, 14, 0, 0);
        ReplaceableClockDemo demo = new ReplaceableClockDemo(now);
        assertFalse(demo.isNowBefore(piDay));
    }
}