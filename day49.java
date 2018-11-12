package dcm;

public class day49 {

    /*
    This problem was asked by Amazon.

Given an array of numbers, find the maximum sum of any contiguous subarray of the array.

For example, given the array [34, -50, 42, 14, -5, 86], the maximum sum would be 137, since we would take elements 42, 14, -5, and 86.

Given the array [-5, -1, -8, -9], the maximum sum would be 0, since we would not take any elements.

Do this in O(N) time
     */

    public static void main(String args[]){
        int input[] = {34, -50, 42, 14, -5, 86};

        int finalMax =0, maxUpToThisPoint = 0;

        for (int anInput : input) {
            maxUpToThisPoint += anInput;

            if (maxUpToThisPoint < 0) {
                maxUpToThisPoint = 0;
            }

            if (maxUpToThisPoint > finalMax) {
                finalMax = maxUpToThisPoint;
            }
        }

        System.out.println("The maximum is "+finalMax);
    }
}
