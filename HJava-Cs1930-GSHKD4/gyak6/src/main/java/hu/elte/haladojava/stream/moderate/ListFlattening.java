package hu.elte.haladojava.stream.moderate;

import java.util.ArrayList;
import java.util.List;

public class ListFlattening {

  // hint: use reduce() or flatMap()
  public List<Integer> flatten(List<List<Integer>> listOfListsOfNumbers) {
    return listOfListsOfNumbers
            .stream()
            .reduce(new ArrayList<>(), (totalList, listOfNumbers) -> {
              List<Integer> tmp = new ArrayList<>();
              tmp.addAll(totalList);
              tmp.addAll(listOfNumbers);
              return tmp;
            });
  }
}
