package ua.opnu;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static ua.opnu.Task2.filterStudents;
import static ua.opnu.Task3.filterTwo;
import static ua.opnu.Task5.applyIf;
import static ua.opnu.Task7.stringify;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main(String[] args) {
        //1
        Predicate<Integer> isPrime = n -> {
            if (n < 2) return false;
            for (int i = 2; i <= Math.sqrt(n); i++)
                if (n % i == 0) return false;
            return true;
        };

        System.out.println("7 просте? " + isPrime.test(7));   // true
        System.out.println("10 просте? " + isPrime.test(10)); // false
        //2
        List<Student> students = List.of(
                new Student("Іван Іваненко", "AІ-241", new int[]{70, 80, 90}),
                new Student("Петро Петренко", "AІ-241", new int[]{40, 55, 75}),
                new Student("Марія Швець", "AІ-241", new int[]{100, 85, 95})
        );

        Predicate<Student> noDebts = s -> Arrays.stream(s.getMarks()).allMatch(m -> m >= 60);

        List<Student> filtered = filterStudents(students, noDebts);
        System.out.println("Студенти без заборгованостей:");
        filtered.forEach(System.out::println);
        //3
        List<Integer> numbers = List.of(10, 25, 30, 45, 50, 60);
        Predicate<Integer> divisibleBy5 = n -> n % 5 == 0;
        Predicate<Integer> lessThan40 = n -> n < 40;

        List<Integer> result = filterTwo(numbers, divisibleBy5, lessThan40);
        System.out.println("Числа, кратні 5 і менші 40: " + result);
        //4
        Student[] arr = {
                new Student("Іван Іваненко", "AІ-241", new int[]{70, 80}),
                new Student("Марія Швець", "AІ-241", new int[]{90, 95})
        };

        StudentConsumer printer = s ->
                System.out.println("Студент: " + s.getName());

        System.out.println("Список студентів:");
        for (Student s : students) {
            printer.accept(s);
        }
        //5
        Integer[] numbers_arr = {5, 10, 15, 20};

        Predicate<Integer> even = n -> n % 2 == 0;
        Consumer<Integer> print = n -> System.out.println("Парне число: " + n);

        for (int n : numbers) {
            applyIf(n, even, print);
        }
        //6
        Function<Integer, Integer> pow2 = n -> (int)Math.pow(2, n);
        int[] numbers_arr2 = {0, 1, 2, 3, 4, 5};

        for (int n : numbers) {
            System.out.println("2^" + n + " = " + pow2.apply(n));
        }
        //7
        Function<Integer, String> numToWord = n -> switch (n) {
            case 0 -> "нуль";
            case 1 -> "один";
            case 2 -> "два";
            case 3 -> "три";
            case 4 -> "чотири";
            case 5 -> "п’ять";
            case 6 -> "шість";
            case 7 -> "сім";
            case 8 -> "вісім";
            case 9 -> "дев’ять";
            default -> "невідомо";
        };

        int[] nums = {0, 3, 5, 7, 9};
        String[] words = stringify(nums, numToWord);

        System.out.println("Результат перетворення:");
        for (String w : words) System.out.println(w);
    }

}

