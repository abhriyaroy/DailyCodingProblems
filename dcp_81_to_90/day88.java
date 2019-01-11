package dcm.dcp_81_to_90;

public class day88 {

    /*
    Implement division of two positive integers without using the division, multiplication, or modulus operators. Return the quotient as an integer, ignoring the remainder.
     */

    public static void main(String args[]) {
        System.out.println(divide(3, 31));
    }

    private static int divide(int divisor, int dividend) {
        int quotient = 0;
        int remainder = 0;
        if (divisor == 0)
            return Integer.MAX_VALUE;

        remainder = dividend;
        int power = 32;
        int divisorPower = divisor << power;
        System.out.println("Before loop " + divisorPower);
        while (remainder >= divisor) {
            while (divisorPower > remainder) {
                divisorPower >>= 1;
                power -= 1;
                System.out.println("In loop dP " + divisorPower);
                System.out.println("In loop p " + power);
            }
            quotient += 1 << power;
            remainder -= divisorPower;
            System.out.println("Out loop R " + remainder);
            System.out.println("Out loop P" + power);
        }
        return quotient;
    }
}
