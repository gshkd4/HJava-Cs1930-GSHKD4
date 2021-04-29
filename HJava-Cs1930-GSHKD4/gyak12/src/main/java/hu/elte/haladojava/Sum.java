package hu.elte.haladojava;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sum {

    public static void main(String[] args) {

        List<Integer> integers = IntStream.range(0, 1000001).boxed().collect(Collectors.toList());

        long startTime = System.currentTimeMillis();
        int sum = integers.stream().reduce(0, Integer::sum);
        System.out.println("Sum of numbers without threading: " + sum + ", in: "
                + (System.currentTimeMillis() - startTime) + "ms");
    }
}
