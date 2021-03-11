package hu.elte.haladojava.stream.easy;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FindingOnFiniteCollectionTest {

  private FindingOnFiniteCollection tested = new FindingOnFiniteCollection();

  @Test
  public void testFindFirstPrime() {
    assertEquals(Optional.of(7), tested.findFirstPrime(Arrays.asList(4, 6, 7, 8, 9)));
    assertEquals(Optional.empty(), tested.findFirstPrime(Arrays.asList(4, 6, 8, 9)));
  }

  @Test
  public void testIsAnyPrime() {
    assertTrue(tested.isAnyPrime(Arrays.asList(4, 6, 7, 8, 9)));
    assertTrue(tested.isAnyPrime(Arrays.asList(2)));
    assertFalse(tested.isAnyPrime(Arrays.asList()));
    assertFalse(tested.isAnyPrime(Arrays.asList(4, 6, 8, 9, 10)));
  }

  @Test
  public void testIsAllPrime() {
    assertTrue(tested.isAllPrime(Arrays.asList(3, 5, 7, 11)));
    assertTrue(tested.isAllPrime(Arrays.asList(2)));
    assertTrue(tested.isAllPrime(Arrays.asList()));
    assertFalse(tested.isAllPrime(Arrays.asList(3, 5, 7, 10)));
  }
}
