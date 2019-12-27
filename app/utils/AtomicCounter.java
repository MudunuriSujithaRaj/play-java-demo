package utils;

import javax.inject.Singleton;
import java.util.concurrent.atomic.AtomicInteger;

@Singleton
public class AtomicCounter {
    private AtomicInteger counter =new AtomicInteger();

    public int getCounter() {
        return counter.getAndIncrement();
    }
}
