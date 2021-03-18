package hu.elte.haladojava.stream.moderate;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomStreamSortingTest {

  private static final List<String> NAMES = Arrays.asList("John", "Susan", "Anna", "Tom", "Michail");

  @Test
  public void testSortNamesByLength() {
    List<String> expectedList = Arrays.asList("Tom", "John", "Anna", "Susan", "Michail");

    List<String> actualList = new CustomStreamSorting().sortNamesByLength(NAMES);

    Assertions.assertEquals(expectedList, actualList);
  }
}
