package hu.elte.haladojava;

import java.util.Random;
import java.util.function.IntSupplier;

public class RandomGenerator {

  private final Random random;

  public RandomGenerator() {
    random = new Random(System.currentTimeMillis());
  }

  public IntSupplier createRandomGenerator(int inclusiveMin, int exclusiveMax) {
    return () -> random.nextInt(exclusiveMax - inclusiveMin) + inclusiveMin;
  }
}
