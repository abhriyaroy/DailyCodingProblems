package dcm.dcp_31_to_40;

import java.util.ArrayList;

public class day37 {

    /*This problem was asked by Google.

The power set of a set is the set of all its subsets. Write a function that, given a set, generates its power set.

For example, given the set {1, 2, 3}, it should return {{}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}}.

You may also use a list or array to represent a set.*/

    public static void main(String args[]) {
        int input[] = {1, 2, 3};
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> firstElement = new ArrayList();
        result.add(firstElement);
        int powerSetSize = (int) Math.pow(2, input.length);

        for (int i = 1; i < powerSetSize; i++) {
            String binaryNumber = Integer.toBinaryString(i);
            String paddedBinaryNumber = new String(new char[input.length - binaryNumber.length()]).replace('\0', '0') + binaryNumber;
            result.add(new ArrayList<Integer>());
            for (int j = 0; j < paddedBinaryNumber.length(); j++) {
                if (paddedBinaryNumber.charAt(j) == '1') {
                    result.get(i).add(input[j]);
                }
            }
        }

        System.out.println(result.toString());
    }
}
