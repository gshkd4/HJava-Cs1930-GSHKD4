package hu.elte.haladojava.stream.easy;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NaturalStreamSortingTest {

  private static final List<String> NAMES = Arrays.asList("John", "Susan", "Anna", "Tom", "Michail");

  @Test
  public void testSortNamesAlphabetically() {
    List<String> expectedList = Arrays.asList("Anna", "John", "Michail", "Susan", "Tom");

    List<String> actualList = new NaturalStreamSorting().sortNamesAlphabetically(NAMES);

    assertEquals(expectedList, actualList);
  }
}
