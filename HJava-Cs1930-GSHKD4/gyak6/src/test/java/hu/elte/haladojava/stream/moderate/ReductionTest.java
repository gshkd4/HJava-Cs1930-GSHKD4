package hu.elte.haladojava.stream.moderate;

import hu.elte.haladojava.stream.domain.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class ReductionTest {

    private static final List<Person> PERSONS = Arrays.asList(
            new Person(LocalDate.of(1975, 8, 7), "Charlize Theron"),
            new Person(LocalDate.of(1974, 1, 30), "Christian Bale"),
            new Person(LocalDate.of(1981, 6, 9), "Natalie Portman"));

    @Test
    public void testFindOldestPerson() {
        String firstNames = new Reduction().joinFirstNames(PERSONS);

        Assertions.assertEquals("Charlize, Christian, Natalie", firstNames);
    }
}
