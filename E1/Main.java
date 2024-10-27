package E1;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int[] numbersArray = { 111, 222, 333, 444, 556};
        Set<Integer> numbersSet = new HashSet<>();
        for (int number : numbersArray) {
            numbersSet.add(number);
        }

        Set<Integer> listResult = new HashSet<>();
        for (Integer i : numbersSet) {
            if (divisibleByThree(i)) {
                listResult.add(i);
            }
        }

        System.out.println("List of numbers divisible by 3: " + listResult);
    }

    public static boolean divisibleByThree(int a) {
        while (a > 0) {
            a -= 3;
        }
        return a == 0;
    }
}
