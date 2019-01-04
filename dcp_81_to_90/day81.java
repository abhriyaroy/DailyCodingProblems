package dcm.dcp_81_to_90;

import java.util.ArrayList;
import java.util.HashMap;

public class day81 {
    /*
    Given a mapping of digits to letters (as in a phone number), and a digit string, return all possible letters the number could represent. You can assume each valid number in the mapping is a single digit.

For example if {“2”: [“a”, “b”, “c”], 3: [“d”, “e”, “f”], …} then “23” should return [“ad”, “ae”, “af”, “bd”, “be”, “bf”, “cd”, “ce”, “cf"].
     */

    public static void main(String args[]) {
        HashMap<Integer, ArrayList<String>> inputMap = new HashMap<>();
        ArrayList<String> arr1 = new ArrayList<>();
        arr1.add("a");
        arr1.add("b");
        arr1.add("c");
        inputMap.put(2, arr1);
        ArrayList<String> arr2 = new ArrayList<>();
        arr2.add("d");
        arr2.add("e");
        arr2.add("f");
        inputMap.put(3, arr2);

        System.out.println(decode(23, inputMap).toString());
    }

    private static ArrayList<String> decode(int input, HashMap<Integer, ArrayList<String>> inputMap) {
        input = reversNumber(input);
        ArrayList<String> result, temp;
        result = inputMap.get(input % 10);
        input = input / 10;
        while (input > 0) {
            temp = inputMap.get(input % 10);
            input = input / 10;
            ArrayList<String> tempResult = new ArrayList<>();
            int count = 0;
            for (String resultUpToNow : result
            ) {
                for (String newString : temp
                ) {
                    tempResult.add(resultUpToNow + newString);
                }
            }
            result = tempResult;
        }
        return result;
    }

    private static int reversNumber(int input) {
        int n = 0;
        while (input > 0) {
            n *= 10;
            n += input % 10;
            input /= 10;
        }
        return n;
    }
}
