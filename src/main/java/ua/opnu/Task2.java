package ua.opnu;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Task2 {
    public static List<Student> filterStudents(List<Student> students, Predicate<Student> predicate) {
        return students.stream().filter(predicate).collect(Collectors.toList());
    }
}
