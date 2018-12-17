package dcm.dcp_71_to_80;

import java.util.Arrays;

public class day75 {

    /*
    This problem was asked by Microsoft.

Given an array of numbers, find the length of the longest increasing subsequence in the array. The subsequence does not necessarily have to be contiguous.

For example, given the array [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15], the longest increasing subsequence has length 6: it is 0, 2, 6, 9, 11, 15.
     */

    public static void main(String args[]) {
        int input[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        System.out.println(longestSubSequence(input));
    }

    private static int longestSubSequence(int arr[]) {
        if (arr.length == 0) {
            return 0;
        }
        int cache[] = new int[arr.length];
        Arrays.fill(cache, 1);
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j])
                    cache[i] = Integer.max(cache[i], cache[j] + 1);
                if (cache[i] > max) {
                    max = cache[i];
                }
            }
        }
        return max;
    }
}
