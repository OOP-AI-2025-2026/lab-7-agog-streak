package ua.opnu;
import java.util.function.Predicate;
import java.util.function.Consumer;

public class Task5 {
    public static <T> void applyIf(T value, Predicate<T> predicate, Consumer<T> consumer) {
        if (predicate.test(value)) consumer.accept(value);
    }
}

