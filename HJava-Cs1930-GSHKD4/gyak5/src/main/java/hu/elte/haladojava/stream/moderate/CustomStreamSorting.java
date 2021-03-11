package hu.elte.haladojava.stream.moderate;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomStreamSorting {

  // hint: use .collect() and the right method from java.util.stream.Collectors
  // additionally you should either code your own comparator or check java.util.Comparator

  public List<String> sortNamesByLength(List<String> names) {
    return names.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
  }
}
