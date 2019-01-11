package dcm.dcp_81_to_90;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class day90 {

    /*
    Given an integer n and a list of integers l, write a function that randomly generates a number from 0 to n-1 that isn't in l (uniform).
     */

    public static void main(String args[]) {
        int n = 4;
        ArrayList<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(5);

        System.out.println(randomize(n, l));
    }

    private static int randomize(int n, ArrayList<Integer> l) {
        HashMap<Integer, Integer> excludeList = new HashMap<>();
        for (Integer i : l) {
            excludeList.put(i, i);
        }
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!excludeList.containsKey(i))
                numbers.add(i);
        }
        Random random = new Random();
        int randomPosition = random.nextInt(numbers.size());
        return numbers.get(randomPosition);
    }
}
