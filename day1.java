package dcm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class day1 {

    /*This problem was recently asked by Google.

Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

Bonus: Can you do this in one pass?*/

    public static void main(String args[]){
        int arr[] = {10, 15, 3, 7};
        System.out.println(Arrays.toString(twoSum(arr, 17)));
    }

    static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { nums[i], complement};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
