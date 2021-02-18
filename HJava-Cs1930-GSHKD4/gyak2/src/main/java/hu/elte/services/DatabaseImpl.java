package hu.elte.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// we are now just pretending we use a database...
public class DatabaseImpl implements Database {

    private final List<Person> persons = Arrays.asList(
            new Person("TEST_NAME_1"),
            new Person("TEST_NAME_0"),
            new Person("TEST_NAME_1"));

    @Override
    public void connect() {
        // whatever, no database, so nothing to do
    }

    @Override
    public List<Person> findPersonsWithName(String name) {
        return persons.stream().filter(p -> p.getName().equals(name)).collect(Collectors.toList());
    }

    @Override
    public void disconnect() {
        // whatever, no database, so nothing to do
    }
}
