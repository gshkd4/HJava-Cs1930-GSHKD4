package hu.elte.haladojava;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntSupplier;

public class PositiveNumberGenerator {

  public IntSupplier createPositiveSeriesGenerator() {
    AtomicInteger number = new AtomicInteger(1);

    return () -> number.getAndIncrement();
  }
}
