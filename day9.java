package dcm;

public class day9 {

    /*Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.

For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.*/

    public static void main(String arg[]) {
        int arr[] = {-5, -1, -1, -5};

        System.out.println(identify(arr));
    }

    private static int identify(int[] values) {
        if (values == null || values.length == 0) {
            throw new RuntimeException("Unable to identify sum");
        }

        if (values.length == 1) {
            return values[0];
        }

        int firstSum = 0;
        int secondSum = values[0];
        int previousValueSum = values[1];

        for (int i = 2; i < values.length; i++) {
            int value = values[i];
            int maximumCurrentElementSum = Math.max(firstSum, secondSum) + value;
            firstSum = Math.max(firstSum, secondSum);
            secondSum = previousValueSum;
            previousValueSum = maximumCurrentElementSum;
        }

        return Math.max(secondSum, previousValueSum);
    }
}
