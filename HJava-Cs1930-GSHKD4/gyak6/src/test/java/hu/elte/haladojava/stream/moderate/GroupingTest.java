package hu.elte.haladojava.stream.moderate;

import hu.elte.haladojava.stream.domain.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupingTest {

    private static final Person CHARLIZE_THERON = new Person(LocalDate.of(1975, 8, 7), "Charlize Theron");
    private static final Person CHRISTIAN_BALE = new Person(LocalDate.of(1974, 1, 30), "Christian Bale");
    private static final Person NATALIE_PORTMAN = new Person(LocalDate.of(1981, 6, 9), "Natalie Portman");

    private static final List<Person> PERSONS = Arrays.asList(CHARLIZE_THERON, CHRISTIAN_BALE, NATALIE_PORTMAN);


    @Test
    public void testFindOldestPerson() {
        Map<Character, List<Person>> expectedPersonsByFirstCharacterInName = new HashMap<>();
        expectedPersonsByFirstCharacterInName.put('C', Arrays.asList(CHARLIZE_THERON, CHRISTIAN_BALE));
        expectedPersonsByFirstCharacterInName.put('N', Arrays.asList(NATALIE_PORTMAN));

        Map<Character, List<Person>> personsByFirstCharacterInName = new Grouping().groupByFirstCharacterInName(PERSONS);

        Assertions.assertEquals(expectedPersonsByFirstCharacterInName, personsByFirstCharacterInName);
    }
}
