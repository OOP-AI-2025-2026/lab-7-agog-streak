package ua.opnu;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Task3 {
    public static <T> List<T> filterTwo(List<T> list, Predicate<T> p1, Predicate<T> p2) {
        return list.stream().filter(p1.and(p2)).collect(Collectors.toList());
    }
}