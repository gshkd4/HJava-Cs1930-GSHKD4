package hu.elte.haladojava.stream.moderate;

import hu.elte.haladojava.stream.domain.Person;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Grouping {

    // hint: use collect() with the right Collector
    public Map<Character, List<Person>> groupByFirstCharacterInName(List<Person> persons) {
        return persons.stream().collect(Collectors.groupingBy(person -> person.getName().charAt(0)));
    }
}
