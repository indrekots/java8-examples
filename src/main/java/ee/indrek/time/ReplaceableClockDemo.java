package ee.indrek.time;

import java.time.Clock;

public class ReplaceableClock {

    private Clock clock;

    public ReplaceableClock(Clock clock) {
        this.clock = clock;
    }
}
