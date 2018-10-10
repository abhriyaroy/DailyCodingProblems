package dcm;

public class day12 {

    /*This problem was asked by Amazon.

There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time.
Given N, write a function that returns the number of unique ways you can climb the staircase. The order of the steps matters.

For example, if N is 4, then there are 5 unique ways:

1, 1, 1, 1
2, 1, 1
1, 2, 1
1, 1, 2
2, 2
What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a set of
positive integers X? For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.*/


    public static void main(String args[]) {
        int stepSizes[] = {1,2,3};
        int numberOfSteps = 4;

        System.out.println(findSteps(stepSizes, new int[numberOfSteps], numberOfSteps));
    }

    private static int findSteps(int arr[], int storage[], int n) {
        if (n == 0) {
            return 1;
        }
        int count = 0;


        for (int i = 0; i < arr.length; i++) {
            if (n >= arr[i]) {
                if (storage[n-arr[i]]!=0){
                    count += storage[n-arr[i]];
                }
                else {
                    count += findSteps(arr, storage, n - arr[i]);
                    storage[n - arr[i]] = count;
                }
            }
        }

        return count;
    }
}
