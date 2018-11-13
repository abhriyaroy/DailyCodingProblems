package dcm.dcp_1_to_10;

import java.util.Arrays;

public class day2 {

    /* This problem was asked by Uber.

Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?*/

    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(findArray(arr)));
    }

    static int[] findArray(int arr[]) {
        int product = 1;
        for (int a : arr) {
            product *= a;
        }
        int count;
        int resultantArray[] = new int[arr.length];
        for (int a = 0; a < arr.length; a++) {
            count = 0;
            int num = product;
            while (num > 0) {
                num -= arr[a];
                count++;
            }
            resultantArray[a] = count;
        }
        return resultantArray;
    }

}
