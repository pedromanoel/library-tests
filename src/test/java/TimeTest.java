import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.Timer;
import io.micrometer.jmx.JmxConfig;
import io.micrometer.jmx.JmxMeterRegistry;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
import java.util.Random;

import static java.lang.Thread.sleep;

public class TimeTest {


    private JmxMeterRegistry jmxMeterRegistry;
    private Timer timer;

    @Before
    public void setUp() {
        jmxMeterRegistry = new JmxMeterRegistry(new JmxConfig() {
            @Override
            public Duration step() {
                return Duration.ofSeconds(10);
            }

            @Override
            public String get(String key) {
                return null;
            }
        }, Clock.SYSTEM);

        timer = jmxMeterRegistry.timer("function.call", Tags.of("region", "test"));
    }

    @Test
    public void name() {

        new Random().ints(100, 300).forEach((i) -> {

            timer.record(() -> {
                try {
                    sleep(i);
                } catch (InterruptedException e) {
                    // noop
                }
            });
        });
    }
}
