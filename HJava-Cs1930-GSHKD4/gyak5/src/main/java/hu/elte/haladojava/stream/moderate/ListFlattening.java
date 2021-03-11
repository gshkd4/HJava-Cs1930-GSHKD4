package hu.elte.haladojava.stream.moderate;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ListFlattening {

  // hint: use reduce() or flatMap()
  public List<Integer> flatten(List<List<Integer>> listOfListsOfNumbers) {
    return listOfListsOfNumbers.stream().flatMap(Collection::stream).collect(Collectors.toList());
  }
}
