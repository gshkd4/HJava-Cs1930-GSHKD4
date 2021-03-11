package hu.elte.haladojava.stream.easy;

import java.util.List;
import java.util.Optional;

public class FindingOnFiniteCollection {

  public Optional<Integer> findFirstPrime(List<Integer> numbers) {
    return numbers.stream().filter(this::isPrime).findFirst();
  }

  public boolean isAnyPrime(List<Integer> numbers) {
    return numbers.stream().anyMatch(this::isPrime);
  }

  public boolean isAllPrime(List<Integer> numbers) {
    return numbers.stream().allMatch(this::isPrime);  }

  private boolean isPrime(int number){
    if (number <= 1) {
      return false;
    }

    for (int i = 2; i < number; i++) {
      if (number % i == 0) {
        return false;
      }
    }

    return true;
  }
}
