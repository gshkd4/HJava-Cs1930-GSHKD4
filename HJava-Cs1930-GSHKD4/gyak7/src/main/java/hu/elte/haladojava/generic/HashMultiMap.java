package hu.elte.haladojava.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;

public class HashMultiMap<K, V> implements MultiMap<K, V> {

    private final Map<K, List<V>> map;

    public HashMultiMap() {
        map = new HashMap<>();
    }

    @Override
    public int size() {
        return map.values().stream().reduce(new ArrayList<>(), (subtotal, element) -> {
            subtotal.addAll(element);
            return subtotal;
        }).size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean put(K key, V value) {
        if (map.containsKey(key)) {
            return map.get(key).add(value);
        }

        List<V> values = new ArrayList<>();
        map.put(key, values);

        return values.add(value);
    }

    @Override
    public boolean putAll(K key, Collection<V> values) {
        AtomicBoolean isSuccessful = new AtomicBoolean(true);

        values.forEach(value -> isSuccessful.set(isSuccessful.get() && put(key, value)));

        return isSuccessful.get();
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public List<V> get(K key) {
        List<V> values = map.get(key);
        return values != null ? values: new ArrayList<>();
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public void forEach(BiConsumer<K, V> action) {
        map.forEach((key, values) -> values.forEach(value -> action.accept(key, value)));
    }
}
