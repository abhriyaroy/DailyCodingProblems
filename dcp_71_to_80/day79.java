package dcm.dcp_71_to_80;

public class day79 {

    /*
    Given an array of integers, write a function to determine whether the array could become non-decreasing by modifying at most 1 element.

For example, given the array [10, 5, 7], you should return true, since we can modify the 10 into a 1 to make the array non-decreasing.

Given the array [10, 5, 1], you should return false, since we can't modify any one element to get a non-decreasing array.
     */

    public static void main(String args[]) {
        int input[] = {10, 5, 7};
        int input2[] = {10, 5, 1};
        System.out.println(check(input));
        System.out.println(check(input2));
    }

    private static boolean check(int arr[]) {
        int decreasingSequenceCounter = 0;
        if (arr.length == 1)
            return true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                decreasingSequenceCounter++;
                if (decreasingSequenceCounter > 1)
                    return false;
                else {
                    if (arr[i] % 10 > arr[i + 1] || ((arr[i] - arr[i] / 10) / 10) > arr[i + 1]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
