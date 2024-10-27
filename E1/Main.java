package E1;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        int[] numbersArray = {-111, -222, 111, 222, 333, 444, 556};
        HashSet<Integer> numbersSet = new HashSet<>();
        for (int number : numbersArray) {
            numbersSet.add(number);
        }

        HashSet<Integer> listResult = new HashSet<>();
        for (Integer i : numbersSet) {
            if (divisibleByThree(i)) {
                listResult.add(i);
            }
        }

        System.out.println("List of numbers divisible by 3: " + listResult);
    }

    public static boolean divisibleByThree(int a) {
        if (a < 0) {
            a = -a;
        }
        while (a > 0) {
            a -= 3;
        }
        return a == 0;
    }
}
