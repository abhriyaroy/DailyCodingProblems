package dcm.dcp_1_to_10;

import java.util.HashMap;

public class day4 {


    /*This problem was asked by Stripe.

Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.

For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

You can modify the input array in-place.*/

    public static void main(String args[]) {
        int a[] = {1, 2, 0};
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            hashMap.put(a[i], i);
        }
        int i = 1;
        while (i < Integer.MAX_VALUE) {
            if (!hashMap.containsKey(i)) {
                System.out.println(i);
                break;
            }
            i++;
        }
    }
}
