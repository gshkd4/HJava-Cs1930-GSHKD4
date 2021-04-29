package hu.elte.haladojava;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConcurrentSum {

    private static volatile AtomicInteger sum0;
    private static volatile AtomicInteger sum1;

    public static void main(String[] args) throws InterruptedException {

        List<Integer> integers = IntStream.range(0, 1000001).boxed().collect(Collectors.toList());

        // Sum with threading
        long startTime = System.currentTimeMillis();
        List<Integer> integersSubList0 = integers.subList(0, integers.size() / 2);
        List<Integer> integersSubList1 = integers.subList(integers.size() / 2, integers.size());

        sum0 = new AtomicInteger(0);
        Thread thread0 = new Thread(() -> {
            integersSubList0.forEach(num -> sum0.addAndGet(num));
        });
        sum1 = new AtomicInteger(0);
        Thread thread1 = new Thread(() -> {
            integersSubList1.forEach(num -> sum1.addAndGet(num));
        });

        thread0.start();
        thread1.start();

        thread0.join();
        thread1.join();

        int sum = sum0.get() + sum1.get();

        System.out.println("Sum of numbers with threading: " + sum + ", in: "
                + (System.currentTimeMillis() - startTime) + "ms");
    }
}
