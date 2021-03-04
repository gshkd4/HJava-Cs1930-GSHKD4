package hu.elte.haladojava;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaExamples {

    public static void main(String[] args) {
        function();
        biFunction();
        consumer();
        supplier();
        runnable();
    }

    private static void function() {
        Function<String, Integer> lengthOfString = string -> string.length();

        System.out.println("length of 'alma': " + lengthOfString.apply("alma"));
    }

    private static void biFunction() {
        BiFunction<LocalDate, LocalDate, Integer> daysBetweenDates =
                (date1, date2) -> Math.toIntExact(ChronoUnit.DAYS.between(date1, date2));

        System.out.println("days between 'Aranybulla kiadása' and 'Mohácsi csata': " + daysBetweenDates.apply(LocalDate.of(1222, 4, 24), LocalDate.of(1526, 8, 29)));
    }

    private static void consumer() {
        Consumer<Beer> drinker = beer -> beer.drink();

        // just drinking silently, nothing to print
        drinker.accept(new Beer());
        drinker.accept(new Beer());
        drinker.accept(new Beer());
        // enough
    }

    private static void supplier() {
        Random random = new Random();
        Supplier<Integer> randomNumberSupplier = () -> random.nextInt();

        System.out.println("random number: " + randomNumberSupplier.get());
        System.out.println("random number: " + randomNumberSupplier.get());
        System.out.println("random number: " + randomNumberSupplier.get());
    }

    private static void runnable() {
        CustomRunnable customRunnable = () -> {throw new IOException();};

        try {
            customRunnable.run();
        } catch (Exception e) {
            System.out.println("goodbye!");
        }
    }
}

class Student implements Consumer<Beer> {

    @Override
    public void accept(Beer beer) {
        beer.drink();
    }
}

class Beer {
    void drink() {}
}

@FunctionalInterface
interface CustomRunnable {
    void run() throws IOException;
}
