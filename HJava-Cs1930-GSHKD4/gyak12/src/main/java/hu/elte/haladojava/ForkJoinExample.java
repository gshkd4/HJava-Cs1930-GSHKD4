package hu.elte.haladojava;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ForkJoinExample {

    private static volatile AtomicInteger sum0;
    private static volatile AtomicInteger sum1;

    public static void main(String[] args) throws InterruptedException {
        List<Integer> integers = IntStream.range(0, 101).boxed().collect(Collectors.toList());

        // TODO sum all integers using ForkJoinPool/RecursiveTask
        SumTask task = new SumTask(integers);
    }

    static class SumTask {

        private final List<Integer> numbers;

        SumTask(List<Integer> numbers) {
            this.numbers = numbers;
        }
    }
}
