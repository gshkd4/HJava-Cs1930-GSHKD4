package hu.elte.haladojava.generic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenericMethodsTest {

    @Test
    void shouldFindMaxInteger() {
        final Integer[] numbers = {1, 2, 4, 3, 66, 127, 5, 8, 6, 7};

        GenericMethods<Integer> genericMethods = new GenericMethods<>();
        assertEquals(127, genericMethods.max(numbers).get());
    }
}