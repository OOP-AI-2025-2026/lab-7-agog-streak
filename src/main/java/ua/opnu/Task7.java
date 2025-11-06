package ua.opnu;
import java.util.function.Function;

public class Task7 {
    public static String[] stringify(int[] arr, Function<Integer, String> func) {
        String[] result = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = func.apply(arr[i]);
        }
        return result;
    }
}