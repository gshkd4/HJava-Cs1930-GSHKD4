package hu.elte.haladojava.stream.easy;

import hu.elte.haladojava.stream.domain.Person;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class FindMin {

    public Optional<Person> findOldestPerson(List<Person> persons) {
        return persons.stream().min(Comparator.comparing(Person::getBirthDay));
    }

    public OptionalInt findEarliestBirthYear(List<Person> persons) {
        return persons.stream().mapToInt(person -> person.getBirthDay().getYear()).min();
    }
}
