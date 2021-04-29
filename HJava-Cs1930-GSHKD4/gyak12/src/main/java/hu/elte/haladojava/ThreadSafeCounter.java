package hu.elte.haladojava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSafeCounter {

    private static final AtomicInteger counter = new AtomicInteger(0);
    private static final int tasksToComplete = 1000;
    private static final AtomicInteger completedTasksCount = new AtomicInteger(0);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Runnable increaseCounter1000Times = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementAndGet();
            }

            completedTasksCount.incrementAndGet();
        };

        for (int i = 0; i < 1000; i++) {
            executorService.execute(increaseCounter1000Times);
        }

        // This is ugly, but for the purpose it needs to server, it will do
        while (completedTasksCount.get() != tasksToComplete) {}
        executorService.shutdownNow();

        System.out.println(counter);
    }
}
