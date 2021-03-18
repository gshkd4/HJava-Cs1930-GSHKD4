package hu.elte.haladojava.stream.easy;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class ArrayStream {

    public OptionalInt findMax(int... ints) {
        return Arrays.stream(ints).max();
    }

    /**
     * Returns with a {@link IntStream} of subsequent {@code int}s that are greater than 0
     */
    public IntStream positiveNumbers() {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        return IntStream.generate(atomicInteger::incrementAndGet);
    }
}
