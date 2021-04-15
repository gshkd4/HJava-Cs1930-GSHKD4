package hu.elte.haladojava.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class Basket<T> {

    private final List<T> things = new ArrayList<>();

    // used E just not to mix up with T
    public static <E> void copy(Basket<E> source, Basket<E> destination) {
        for (int i = 0; i < source.things.size(); i++) {
            destination.add(source.things.get(i));
        }
    }

    public void add(T thing) {
        things.add(thing);
    }

    public void addAll(Collection<? extends T> things) {
        this.things.addAll(things);
    }

    public void forEach(Consumer<? super T> consumer) {
        things.forEach(consumer);
    }

    public Optional<T> biggestThing(Comparator<T> comparator) {
        return things.stream().max(comparator);
    }

    public int size() {
        return things.size();
    }
}
