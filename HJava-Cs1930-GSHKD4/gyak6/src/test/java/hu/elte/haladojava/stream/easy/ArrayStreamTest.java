package hu.elte.haladojava.stream.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class ArrayStreamTest {

    @Test
    public void testFindMax() {
        OptionalInt max = new ArrayStream().findMax(-232, 10, 2, 20, 4);

        Assertions.assertEquals(OptionalInt.of(20), max);
    }

    @Test
    public void testFindMax_emptyArray() {
        OptionalInt max = new ArrayStream().findMax();

        Assertions.assertEquals(OptionalInt.empty(), max);
    }

    @Test
    public void testPositiveNumbers() {
        Assertions.assertEquals(Collections.emptyList(), new ArrayStream().positiveNumbers().limit(0).boxed().collect(Collectors.toList()));
        Assertions.assertEquals(Arrays.asList(1, 2, 3, 4, 5), new ArrayStream().positiveNumbers().limit(5).boxed().collect(Collectors.toList()));
    }
}
