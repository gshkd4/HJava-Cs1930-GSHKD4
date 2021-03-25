package hu.elte.haladojava.generic;

import java.util.Arrays;
import java.util.Optional;

public class GenericMethods<T extends Comparable<T>> {

    public Optional<T> max(T[] elements) {
        return Arrays.stream(elements).max(Comparable::compareTo);
    }
}
