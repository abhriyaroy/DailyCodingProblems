package dcm.dcp_61_to_70;

public class day70 {

    /*
    This problem was asked by Microsoft.

A number is considered perfect if its digits sum up to exactly 10.

Given a positive integer n, return the n-th perfect number.

For example, given 1, you should return 19. Given 2, you should return 28
     */

    public static void main(String args[]) {
        System.out.println(largestPerfectNumber(30));
    }

    private static int largestPerfectNumber(int limit) {
        int largestNumber = 0;
        for (int i = 0; i < limit; i++) {
            if (sumOfDigits(i) == 10) {
                largestNumber = i;
            }
        }
        return largestNumber;
    }

    private static int sumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
