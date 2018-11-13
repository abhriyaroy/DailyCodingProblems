package dcm.dcp_31_to_40;

import java.util.Arrays;

public class day35 {

    /*This problem was asked by Google.

Given an array of strictly the characters 'R', 'G', and 'B', segregate the values of the array so that all the Rs come first, the Gs come second, and the Bs come last. You can only swap elements of the array.

Do this in linear time and in-place.

For example, given the array ['G', 'B', 'R', 'R', 'B', 'R', 'G'], it should become ['R', 'R', 'R', 'G', 'G', 'B', 'B'].*/

    /* TO SOLVE THIS PROBLEM WE WILL BE USING THE DUTH NATIONAL FLAG PROBLEM ALGORITHM */

    public static void main(String args[]) {
        char input[] = {'G', 'B', 'R', 'R', 'B', 'R', 'G'};

        int high = input.length - 1;
        int mid = 0;
        int low = 0;

        while (mid <= high) {
            switch (input[mid]) {
                case 'R':
                    swap(low, mid, input);
                    low++;
                    mid++;
                    break;
                case 'G':
                    mid++;
                    break;
                case 'B':
                    swap(mid, high, input);
                    high--;
                    break;
            }
        }

        System.out.println(Arrays.toString(input));
    }

    private static void swap(int a, int b, char arr[]) {
        char temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }

}
